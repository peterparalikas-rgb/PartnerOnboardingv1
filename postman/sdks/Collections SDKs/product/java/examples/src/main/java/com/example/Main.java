package com.example;

import com.productreviewapisdk.ProductReviewApiSdk;
import com.productreviewapisdk.exceptions.ApiError;
import com.productreviewapisdk.models.ListProductsParameters;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    ListProductsParameters requestParameters = ListProductsParameters.builder()
      .page("1")
      .limit("20")
      .build();

    try {
      Object response = productReviewApiSdk.productReviewApiSdk.listProducts(requestParameters);

      System.out.println(response);
    } catch (ApiError e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}
