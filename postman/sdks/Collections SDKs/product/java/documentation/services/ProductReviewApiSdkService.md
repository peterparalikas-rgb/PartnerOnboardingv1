# ProductReviewApiSdkService

A list of all methods in the `ProductReviewApiSdkService` service. Click on the method name to view detailed information about that method.

| Methods                                   | Description |
| :---------------------------------------- | :---------- |
| [listProducts](#listproducts)             |             |
| [getProduct](#getproduct)                 |             |
| [listProductReviews](#listproductreviews) |             |
| [createReview](#createreview)             |             |
| [getReview](#getreview)                   |             |
| [updateReview](#updatereview)             |             |
| [deleteReview](#deletereview)             |             |

## listProducts

- HTTP Method: `GET`
- Endpoint: `/products`

**Parameters**

| Name              | Type                                                          | Required | Description               |
| :---------------- | :------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListProductsParameters](../models/ListProductsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;
import com.productreviewapisdk.models.ListProductsParameters;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    ListProductsParameters requestParameters = ListProductsParameters.builder()
      .page("1")
      .limit("20")
      .build();

    Object response = productReviewApiSdk.productReviewApiSdk.listProducts(requestParameters);

    System.out.println(response);
  }
}

```

## getProduct

- HTTP Method: `GET`
- Endpoint: `/products/{productId}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| productId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    Object response = productReviewApiSdk.productReviewApiSdk.getProduct("productId");

    System.out.println(response);
  }
}

```

## listProductReviews

- HTTP Method: `GET`
- Endpoint: `/products/{productId}/reviews`

**Parameters**

| Name              | Type                                                                      | Required | Description               |
| :---------------- | :------------------------------------------------------------------------ | :------- | :------------------------ |
| productId         | String                                                                    | ✅       |                           |
| requestParameters | [ListProductReviewsParameters](../models/ListProductReviewsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;
import com.productreviewapisdk.models.ListProductReviewsParameters;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    ListProductReviewsParameters requestParameters = ListProductReviewsParameters.builder()
      .page("1")
      .limit("20")
      .build();

    Object response = productReviewApiSdk.productReviewApiSdk.listProductReviews(
      "productId",
      requestParameters
    );

    System.out.println(response);
  }
}

```

## createReview

- HTTP Method: `POST`
- Endpoint: `/products/{productId}/reviews`

**Parameters**

| Name                | Type                                                    | Required | Description  |
| :------------------ | :------------------------------------------------------ | :------- | :----------- |
| productId           | String                                                  | ✅       |              |
| createReviewRequest | [CreateReviewRequest](../models/CreateReviewRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;
import com.productreviewapisdk.models.CreateReviewRequest;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    CreateReviewRequest createReviewRequest = CreateReviewRequest.builder()
      .author("Jane Doe")
      .rating(5D)
      .title("Excellent product")
      .body("Works exactly as described and shipped fast.")
      .build();

    Object response = productReviewApiSdk.productReviewApiSdk.createReview(
      "productId",
      createReviewRequest
    );

    System.out.println(response);
  }
}

```

## getReview

- HTTP Method: `GET`
- Endpoint: `/reviews/{reviewId}`

**Parameters**

| Name     | Type   | Required | Description |
| :------- | :----- | :------- | :---------- |
| reviewId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    Object response = productReviewApiSdk.productReviewApiSdk.getReview("reviewId");

    System.out.println(response);
  }
}

```

## updateReview

- HTTP Method: `PUT`
- Endpoint: `/reviews/{reviewId}`

**Parameters**

| Name                | Type                                                    | Required | Description  |
| :------------------ | :------------------------------------------------------ | :------- | :----------- |
| reviewId            | String                                                  | ✅       |              |
| updateReviewRequest | [UpdateReviewRequest](../models/UpdateReviewRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;
import com.productreviewapisdk.models.UpdateReviewRequest;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    UpdateReviewRequest updateReviewRequest = UpdateReviewRequest.builder()
      .rating(4D)
      .title("Still good after a month")
      .body("Updated: minor wear but overall great.")
      .build();

    Object response = productReviewApiSdk.productReviewApiSdk.updateReview(
      "reviewId",
      updateReviewRequest
    );

    System.out.println(response);
  }
}

```

## deleteReview

- HTTP Method: `DELETE`
- Endpoint: `/reviews/{reviewId}`

**Parameters**

| Name     | Type   | Required | Description |
| :------- | :----- | :------- | :---------- |
| reviewId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    Object response = productReviewApiSdk.productReviewApiSdk.deleteReview("reviewId");

    System.out.println(response);
  }
}

```
