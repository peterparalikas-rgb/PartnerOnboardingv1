"""Pydantic models mirroring the Product Review API spec schemas."""

from __future__ import annotations

from datetime import datetime
from typing import List

from pydantic import BaseModel, Field


# ---------------------------------------------------------------------------
# Core resources
# ---------------------------------------------------------------------------
class Product(BaseModel):
    id: str
    name: str
    description: str
    price: float
    averageRating: float
    reviewCount: int


class Review(BaseModel):
    id: str
    productId: str
    author: str
    rating: int = Field(..., ge=1, le=5, description="Integer rating from 1 to 5")
    title: str
    body: str
    createdAt: datetime
    updatedAt: datetime


# ---------------------------------------------------------------------------
# Request bodies
# ---------------------------------------------------------------------------
class CreateReviewRequest(BaseModel):
    author: str
    rating: int = Field(..., ge=1, le=5)
    title: str
    body: str


class UpdateReviewRequest(BaseModel):
    rating: int = Field(..., ge=1, le=5)
    title: str
    body: str


# ---------------------------------------------------------------------------
# Pagination + list envelopes
# ---------------------------------------------------------------------------
class Pagination(BaseModel):
    page: int
    limit: int
    total: int


class ProductList(BaseModel):
    data: List[Product]
    pagination: Pagination


class ReviewList(BaseModel):
    data: List[Review]
    pagination: Pagination


# ---------------------------------------------------------------------------
# Error envelope
# ---------------------------------------------------------------------------
class ErrorResponse(BaseModel):
    code: str
    message: str
