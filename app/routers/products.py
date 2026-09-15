"""Products endpoints: list products, get product, list a product's reviews."""

from __future__ import annotations

from fastapi import APIRouter, Query

from ..models import Pagination, Product, ProductList, Review, ReviewList
from ..store import store

router = APIRouter(prefix="/products", tags=["Products"])


@router.get("", response_model=ProductList, summary="List Products")
def list_products(
    page: int = Query(1, ge=1),
    limit: int = Query(20, ge=1, le=100),
) -> ProductList:
    items, total = store.list_products(page, limit)
    return ProductList(
        data=items,
        pagination=Pagination(page=page, limit=limit, total=total),
    )


@router.get("/{product_id}", response_model=Product, summary="Get Product")
def get_product(product_id: str) -> Product:
    return store.get_product(product_id)


@router.get(
    "/{product_id}/reviews",
    response_model=ReviewList,
    summary="List Product Reviews",
)
def list_product_reviews(
    product_id: str,
    page: int = Query(1, ge=1),
    limit: int = Query(20, ge=1, le=100),
) -> ReviewList:
    items, total = store.list_product_reviews(product_id, page, limit)
    return ReviewList(
        data=items,
        pagination=Pagination(page=page, limit=limit, total=total),
    )
