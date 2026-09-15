"""FastAPI application entrypoint for the Product Review API.

Run with:
    uvicorn app.main:app --reload

Interactive docs at http://127.0.0.1:8000/docs
"""

from __future__ import annotations

from fastapi import FastAPI

from .errors import ApiError, api_error_handler
from .routers import products, reviews

app = FastAPI(
    title="Product Review API",
    version="1.0.0",
    description=(
        "A simple REST API for a product review application. "
        "It manages products and their reviews."
    ),
)

# Error handling mirrored from the generated SDK's exception types.
app.add_exception_handler(ApiError, api_error_handler)

# Routers
app.include_router(products.router)
app.include_router(reviews.products_router)  # POST /products/{id}/reviews
app.include_router(reviews.router)


@app.get("/", tags=["Meta"], summary="Health check")
def health() -> dict:
    return {"status": "ok", "service": "product-review-api", "version": "1.0.0"}
