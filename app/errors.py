"""API error types and exception handlers.

Mirrors the error classes exposed by the generated SDK
(BadRequest, Unauthorized, Forbidden, NotFound, MethodNotAllowed,
Conflict, TooManyRequests).
"""

from __future__ import annotations

from fastapi import Request
from fastapi.responses import JSONResponse


class ApiError(Exception):
    """Base API error carrying an HTTP status, a machine code, and a message."""

    status_code: int = 500
    code: str = "internal_error"

    def __init__(self, message: str | None = None, *, code: str | None = None):
        self.message = message or self.__class__.__name__
        if code:
            self.code = code
        super().__init__(self.message)


class BadRequestError(ApiError):
    status_code = 400
    code = "bad_request"


class UnauthorizedError(ApiError):
    status_code = 401
    code = "unauthorized"


class ForbiddenError(ApiError):
    status_code = 403
    code = "forbidden"


class NotFoundError(ApiError):
    status_code = 404
    code = "not_found"


class MethodNotAllowedError(ApiError):
    status_code = 405
    code = "method_not_allowed"


class ConflictError(ApiError):
    status_code = 409
    code = "conflict"


class TooManyRequestsError(ApiError):
    status_code = 429
    code = "too_many_requests"


async def api_error_handler(_: Request, exc: ApiError) -> JSONResponse:
    return JSONResponse(
        status_code=exc.status_code,
        content={"code": exc.code, "message": exc.message},
    )
