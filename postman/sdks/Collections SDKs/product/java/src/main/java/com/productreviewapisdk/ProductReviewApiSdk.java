package com.productreviewapisdk;

import com.productreviewapisdk.config.ProductReviewApiSdkConfig;
import com.productreviewapisdk.http.Environment;
import com.productreviewapisdk.http.interceptors.DefaultHeadersInterceptor;
import com.productreviewapisdk.http.interceptors.LoggingInterceptor;
import com.productreviewapisdk.http.interceptors.RetryInterceptor;
import com.productreviewapisdk.logging.Logger;
import com.productreviewapisdk.services.ProductReviewApiSdkService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/**
 * # Product Review API
 *
 * A simple REST API for a product review application. It manages **products** and their **reviews**.
 *
 * - **Products** have an `id`, `name`, `description`, `price`, `averageRating`, and `reviewCount`.
 * - **Reviews** belong to a product and include an `author`, a `rating` (an integer from **1 to 5**), a `title`, and a `body`, along with `createdAt` and `updatedAt` timestamps.
 *
 * All endpoints are relative to the base URL, which is stored in the `{{baseUrl}}` collection variable (`https://api.productreview.example.com/v1`).
 *
 * Requests are grouped into two folders: **Products** and **Reviews**.
 */
public class ProductReviewApiSdk {

  public final ProductReviewApiSdkService productReviewApiSdk;

  private final ProductReviewApiSdkConfig config;

  /**
   * Constructs a new instance of ProductReviewApiSdk with default configuration.
   */
  public ProductReviewApiSdk() {
    // Default configs
    this(ProductReviewApiSdkConfig.builder().build());
  }

  /**
   * Constructs a new instance of ProductReviewApiSdk with custom configuration.
   * Initializes all services, HTTP client, and optional OAuth token manager.
   *
   * @param config The SDK configuration including base URL, authentication, timeout, and retry settings
   */
  public ProductReviewApiSdk(ProductReviewApiSdkConfig config) {
    this.config = config;

    // A user-supplied client is augmented (not replaced): the SDK derives its client from
    // the injected instance so its transport settings and interceptors are preserved, then
    // layers the SDK's own interceptors on top.
    final OkHttpClient customHttpClient = config.getHttpClient();
    final OkHttpClient.Builder httpClientBuilder =
      (customHttpClient != null
          ? customHttpClient.newBuilder()
          : new OkHttpClient.Builder()).addInterceptor(new DefaultHeadersInterceptor(config))
        .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
        // Logging is added last so it observes the fully-decorated request (auth headers
        // included, then redacted). Silent by default — see LogConfig.
        .addInterceptor(new LoggingInterceptor(Logger.from(config.getLogConfig())));

    // Only apply the SDK's default read timeout when building the client ourselves; a
    // user-supplied client owns its own transport (timeout) settings.
    if (customHttpClient == null) {
      httpClientBuilder.readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS);
    }

    final OkHttpClient httpClient = httpClientBuilder.build();

    this.productReviewApiSdk = new ProductReviewApiSdkService(httpClient, config);
  }

  /**
   * Sets the environment for all API requests.
   *
   * @param environment The environment to use (e.g., DEFAULT, PRODUCTION, STAGING)
   */
  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  /**
   * Sets the base URL for all API requests.
   *
   * @param baseUrl The base URL to use for API requests
   */
  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
