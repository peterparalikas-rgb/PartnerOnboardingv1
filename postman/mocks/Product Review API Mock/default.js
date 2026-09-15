const http = require("http");

// Inline responses derived from the Product Review API collection's saved examples.
const PORT = process.env.PORT || 4500;

const products = [
  { id: 1, name: "Wireless Headphones", price: 99.99, category: "Electronics", averageRating: 4.5 },
  { id: 2, name: "Coffee Mug", price: 12.5, category: "Home", averageRating: 4.2 },
  { id: 3, name: "Running Shoes", price: 79.0, category: "Sports", averageRating: 4.7 }
];

const reviews = [
  { id: 101, productId: 1, author: "Alice", rating: 5, comment: "Excellent sound quality!" },
  { id: 102, productId: 1, author: "Bob", rating: 4, comment: "Comfortable but a bit pricey." },
  { id: 103, productId: 2, author: "Carol", rating: 4, comment: "Keeps coffee warm." }
];

function json(res, status, body) {
  res.writeHead(status, { "Content-Type": "application/json" });
  res.end(JSON.stringify(body));
}

const server = http.createServer((req, res) => {
  const { method } = req;
  const url = (req.url || "").split("?")[0];

  // @endpoint GET /products
  if (method === "GET" && url === "/products") {
    return json(res, 200, { products });
  }

  // @endpoint GET /products/:id
  const productMatch = url.match(/^\/products\/(\d+)$/);
  if (method === "GET" && productMatch) {
    const id = Number(productMatch[1]);
    const product = products.find((p) => p.id === id);
    if (!product) return json(res, 404, { error: "Product not found" });
    return json(res, 200, product);
  }

  // @endpoint GET /products/:id/reviews
  const reviewsMatch = url.match(/^\/products\/(\d+)\/reviews$/);
  if (method === "GET" && reviewsMatch) {
    const productId = Number(reviewsMatch[1]);
    return json(res, 200, { reviews: reviews.filter((r) => r.productId === productId) });
  }

  // @endpoint POST /products/:id/reviews
  const addReviewMatch = url.match(/^\/products\/(\d+)\/reviews$/);
  if (method === "POST" && addReviewMatch) {
    return json(res, 201, {
      id: 104,
      productId: Number(addReviewMatch[1]),
      author: "New Reviewer",
      rating: 5,
      comment: "Great product!"
    });
  }

  json(res, 404, { error: "Mock route not defined", method, url });
});

server.listen(PORT, () => console.log("Product Review API Mock running on port " + PORT));