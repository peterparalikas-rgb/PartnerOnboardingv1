"""Reviews endpoints: create (nested under product), get, update, delete."""

from __future__ import annotations

from fastapi import APIRouter, Response, status

from ..models import CreateReviewRequest, Review, UpdateReviewRequest
from ..store import store

# Create is nested under a product; the rest are top-level /reviews.
products_router = APIRouter(prefix="/products", tags=["Reviews"])
router = APIRouter(prefix="/reviews", tags=["Reviews"])


@products_router.post(
    "/{product_id}/reviews",
    response_model=Review,
    status_code=status.HTTP_201_CREATED,
    summary="Create Review",
)
def create_review(product_id: str, payload: CreateReviewRequest) -> Review:
    return store.create_review(product_id, payload)


@router.get("/{review_id}", response_model=Review, summary="Get Review")
def get_review(review_id: str) -> Review:
    return store.get_review(review_id)


@router.put("/{review_id}", response_model=Review, summary="Update Review")
def update_review(review_id: str, payload: UpdateReviewRequest) -> Review:
    return store.update_review(review_id, payload)


@router.delete(
    "/{review_id}",
    status_code=status.HTTP_204_NO_CONTENT,
    summary="Delete Review",
)
def delete_review(review_id: str) -> Response:
    store.delete_review(review_id)
    return Response(status_code=status.HTTP_204_NO_CONTENT)
