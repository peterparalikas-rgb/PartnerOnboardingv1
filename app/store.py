"""In-memory data store seeded with the examples from the API spec.

This is a simple, thread-safe-enough-for-dev store. Swap it out for a real
database by re-implementing the same method surface.
"""

from __future__ import annotations

import itertools
from datetime import datetime, timezone
from threading import Lock
from typing import Dict, List, Optional, Tuple

from .errors import NotFoundError
from .models import CreateReviewRequest, Product, Review, UpdateReviewRequest


def _now() -> datetime:
    return datetime.now(timezone.utc)


class DataStore:
    def __init__(self) -> None:
        self._lock = Lock()
        self._products: Dict[str, Product] = {}
        self._reviews: Dict[str, Review] = {}
        self._review_seq = itertools.count(500)
        self._seed()

    # -- seeding ---------------------------------------------------------
    def _seed(self) -> None:
        products = [
            Product(
                id="prod_123",
                name="Wireless Noise-Cancelling Headphones",
                description=(
                    "Over-ear Bluetooth headphones with active noise "
                    "cancellation and 30-hour battery life."
                ),
                price=199.99,
                averageRating=4.6,
                reviewCount=128,
            ),
            Product(
                id="prod_124",
                name="Stainless Steel Water Bottle",
                description=(
                    "Insulated 1L water bottle that keeps drinks cold for 24 "
                    "hours and hot for 12 hours."
                ),
                price=29.95,
                averageRating=4.2,
                reviewCount=54,
            ),
        ]
        for p in products:
            self._products[p.id] = p

        reviews = [
            Review(
                id="rev_456",
                productId="prod_123",
                author="Jane Doe",
                rating=5,
                title="Excellent product",
                body="Works exactly as described and shipped fast.",
                createdAt=datetime(2024, 5, 1, 10, 15, tzinfo=timezone.utc),
                updatedAt=datetime(2024, 5, 1, 10, 15, tzinfo=timezone.utc),
            ),
            Review(
                id="rev_457",
                productId="prod_123",
                author="John Smith",
                rating=4,
                title="Great value",
                body="Comfortable and sounds good, though the case is a bit bulky.",
                createdAt=datetime(2024, 5, 3, 14, 22, tzinfo=timezone.utc),
                updatedAt=datetime(2024, 5, 3, 14, 22, tzinfo=timezone.utc),
            ),
        ]
        for r in reviews:
            self._reviews[r.id] = r

    # -- products --------------------------------------------------------
    def list_products(self, page: int, limit: int) -> Tuple[List[Product], int]:
        with self._lock:
            items = list(self._products.values())
        total = len(items)
        start = (page - 1) * limit
        return items[start : start + limit], total

    def get_product(self, product_id: str) -> Product:
        with self._lock:
            product = self._products.get(product_id)
        if product is None:
            raise NotFoundError(f"Product '{product_id}' not found")
        return product

    # -- reviews ---------------------------------------------------------
    def list_product_reviews(
        self, product_id: str, page: int, limit: int
    ) -> Tuple[List[Review], int]:
        # Ensure the product exists (404 otherwise).
        self.get_product(product_id)
        with self._lock:
            items = [r for r in self._reviews.values() if r.productId == product_id]
        total = len(items)
        start = (page - 1) * limit
        return items[start : start + limit], total

    def get_review(self, review_id: str) -> Review:
        with self._lock:
            review = self._reviews.get(review_id)
        if review is None:
            raise NotFoundError(f"Review '{review_id}' not found")
        return review

    def create_review(self, product_id: str, payload: CreateReviewRequest) -> Review:
        self.get_product(product_id)  # 404 if product is missing
        now = _now()
        review = Review(
            id=f"rev_{next(self._review_seq)}",
            productId=product_id,
            author=payload.author,
            rating=payload.rating,
            title=payload.title,
            body=payload.body,
            createdAt=now,
            updatedAt=now,
        )
        with self._lock:
            self._reviews[review.id] = review
            self._recompute_product_stats(product_id)
        return review

    def update_review(self, review_id: str, payload: UpdateReviewRequest) -> Review:
        review = self.get_review(review_id)
        updated = review.model_copy(
            update={
                "rating": payload.rating,
                "title": payload.title,
                "body": payload.body,
                "updatedAt": _now(),
            }
        )
        with self._lock:
            self._reviews[review_id] = updated
            self._recompute_product_stats(updated.productId)
        return updated

    def delete_review(self, review_id: str) -> None:
        with self._lock:
            review = self._reviews.pop(review_id, None)
            if review is None:
                raise NotFoundError(f"Review '{review_id}' not found")
            self._recompute_product_stats(review.productId)

    # -- helpers ---------------------------------------------------------
    def _recompute_product_stats(self, product_id: str) -> None:
        """Keep reviewCount / averageRating in sync. Assumes lock is held."""
        product = self._products.get(product_id)
        if product is None:
            return
        ratings = [r.rating for r in self._reviews.values() if r.productId == product_id]
        count = len(ratings)
        avg = round(sum(ratings) / count, 2) if count else 0.0
        self._products[product_id] = product.model_copy(
            update={"reviewCount": count, "averageRating": avg}
        )


# Singleton store used by the routers.
store = DataStore()
