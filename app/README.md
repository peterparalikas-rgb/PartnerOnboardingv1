# Product Review API — Python (FastAPI)

A Python implementation of the **Product Review API** defined in the Postman
spec and collection in this repo. It manages **products** and their **reviews**
using an in-memory store seeded with the same example data as the spec.

## Endpoints

| Method | Path                              | Description          |
| ------ | --------------------------------- | -------------------- |
| GET    | `/products`                       | List Products        |
| GET    | `/products/{productId}`           | Get Product          |
| GET    | `/products/{productId}/reviews`   | List Product Reviews |
| POST   | `/products/{productId}/reviews`   | Create Review        |
| GET    | `/reviews/{reviewId}`             | Get Review           |
| PUT    | `/reviews/{reviewId}`             | Update Review        |
| DELETE | `/reviews/{reviewId}`             | Delete Review        |

`GET /` provides a simple health check.

## Project layout

```
app/
  main.py            # FastAPI app + router wiring + error handlers
  models.py          # Pydantic models (Product, Review, request/response schemas)
  errors.py          # ApiError hierarchy (mirrors the generated SDK) + handler
  store.py           # In-memory data store seeded with spec examples
  routers/
    products.py      # Products endpoints
    reviews.py       # Reviews endpoints
```

## Running locally

```bash
pip install -r requirements.txt
uvicorn app.main:app --reload
```

- Interactive docs (Swagger UI): http://127.0.0.1:8000/docs
- OpenAPI JSON: http://127.0.0.1:8000/openapi.json

## Quick check

```bash
curl http://127.0.0.1:8000/products
curl http://127.0.0.1:8000/products/prod_123
curl http://127.0.0.1:8000/products/prod_123/reviews
curl -X POST http://127.0.0.1:8000/products/prod_123/reviews \
  -H "Content-Type: application/json" \
  -d '{"author":"Jane Doe","rating":5,"title":"Excellent product","body":"Works exactly as described."}'
```

## Notes

- Ratings are validated to be integers between **1 and 5**.
- Product `reviewCount` and `averageRating` are recomputed automatically when
  reviews are created, updated, or deleted.
- Unknown product/review IDs return `404` with a `{ "code", "message" }` body.
- The data store is in-memory, so data resets on restart. Replace `DataStore`
  in `app/store.py` with a database-backed implementation for persistence.
