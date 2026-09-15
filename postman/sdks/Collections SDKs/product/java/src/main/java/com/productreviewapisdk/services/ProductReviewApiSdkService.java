package com.productreviewapisdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.productreviewapisdk.config.ProductReviewApiSdkConfig;
import com.productreviewapisdk.config.RequestConfig;
import com.productreviewapisdk.exceptions.ApiError;
import com.productreviewapisdk.http.Environment;
import com.productreviewapisdk.http.HttpMethod;
import com.productreviewapisdk.http.ModelConverter;
import com.productreviewapisdk.http.ProductReviewApiSdkResponse;
import com.productreviewapisdk.http.util.RequestBuilder;
import com.productreviewapisdk.models.CreateReviewRequest;
import com.productreviewapisdk.models.ListProductReviewsParameters;
import com.productreviewapisdk.models.ListProductsParameters;
import com.productreviewapisdk.models.UpdateReviewRequest;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ProductReviewApiSdkService Service
 */
public class ProductReviewApiSdkService extends BaseService {

  private RequestConfig listProductsConfig = RequestConfig.builder()
    .environment(Environment.D657_D452_55_B0_48_D1_AC4_F_4_E2_DF9809838)
    .build();
  private RequestConfig getProductConfig = RequestConfig.builder()
    .environment(Environment.D657_D452_55_B0_48_D1_AC4_F_4_E2_DF9809838)
    .build();
  private RequestConfig listProductReviewsConfig = RequestConfig.builder()
    .environment(Environment.D657_D452_55_B0_48_D1_AC4_F_4_E2_DF9809838)
    .build();
  private RequestConfig createReviewConfig = RequestConfig.builder()
    .environment(Environment.D657_D452_55_B0_48_D1_AC4_F_4_E2_DF9809838)
    .build();
  private RequestConfig getReviewConfig = RequestConfig.builder()
    .environment(Environment.D657_D452_55_B0_48_D1_AC4_F_4_E2_DF9809838)
    .build();
  private RequestConfig updateReviewConfig = RequestConfig.builder()
    .environment(Environment.D657_D452_55_B0_48_D1_AC4_F_4_E2_DF9809838)
    .build();
  private RequestConfig deleteReviewConfig = RequestConfig.builder()
    .environment(Environment.D657_D452_55_B0_48_D1_AC4_F_4_E2_DF9809838)
    .build();

  /**
   * Constructs a new instance of ProductReviewApiSdkService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public ProductReviewApiSdkService(
    @NonNull OkHttpClient httpClient,
    ProductReviewApiSdkConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code listProducts}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setListProductsConfig(RequestConfig config) {
    this.listProductsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getProduct}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setGetProductConfig(RequestConfig config) {
    this.getProductConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listProductReviews}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setListProductReviewsConfig(RequestConfig config) {
    this.listProductReviewsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createReview}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setCreateReviewConfig(RequestConfig config) {
    this.createReviewConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getReview}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setGetReviewConfig(RequestConfig config) {
    this.getReviewConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code updateReview}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setUpdateReviewConfig(RequestConfig config) {
    this.updateReviewConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteReview}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setDeleteReviewConfig(RequestConfig config) {
    this.deleteReviewConfig = config;
    return this;
  }

  /**
   * Method listProducts
   * GET /products
   *
   * @return response of {@code Object}
   */
  public Object listProducts() throws ApiError {
    return this.listProducts(ListProductsParameters.builder().build());
  }

  /**
   * Method listProducts
   * GET /products
   *
   * @param requestParameters {@link ListProductsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listProducts(@NonNull ListProductsParameters requestParameters) throws ApiError {
    return this.listProducts(requestParameters, null);
  }

  /**
   * Method listProducts
   * GET /products
   *
   * @param requestParameters {@link ListProductsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listProducts(
    @NonNull ListProductsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().listProducts(requestParameters, requestConfig).getData();
  }

  /**
   * Method listProducts
   * GET /products
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listProductsAsync() throws ApiError {
    return this.listProductsAsync(ListProductsParameters.builder().build());
  }

  /**
   * Method listProducts
   * GET /products
   *
   * @param requestParameters {@link ListProductsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listProductsAsync(
    @NonNull ListProductsParameters requestParameters
  ) throws ApiError {
    return this.listProductsAsync(requestParameters, null);
  }

  /**
   * Method listProducts
   * GET /products
   *
   * @param requestParameters {@link ListProductsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listProductsAsync(
    @NonNull ListProductsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .listProductsAsync(requestParameters, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildListProductsRequest(
    @NonNull ListProductsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.D657_D452_55_B0_48_D1_AC4_F_4_E2_DF9809838),
      "products"
    )
      .setOptionalQueryParameter("page", requestParameters.getPage())
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .build();
  }

  /**
   * Method getProduct
   * GET /products/{productId}
   *
   * @param productId String
   * @return response of {@code Object}
   */
  public Object getProduct(@NonNull String productId) throws ApiError {
    return this.getProduct(productId, null);
  }

  /**
   * Method getProduct
   * GET /products/{productId}
   *
   * @param productId String
   * @return response of {@code Object}
   */
  public Object getProduct(@NonNull String productId, RequestConfig requestConfig) throws ApiError {
    return withRawResponse().getProduct(productId, requestConfig).getData();
  }

  /**
   * Method getProduct
   * GET /products/{productId}
   *
   * @param productId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getProductAsync(@NonNull String productId) throws ApiError {
    return this.getProductAsync(productId, null);
  }

  /**
   * Method getProduct
   * GET /products/{productId}
   *
   * @param productId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getProductAsync(
    @NonNull String productId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .getProductAsync(productId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetProductRequest(@NonNull String productId, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.D657_D452_55_B0_48_D1_AC4_F_4_E2_DF9809838),
      "products/{productId}"
    )
      .setPathParameter("productId", productId)
      .build();
  }

  /**
   * Method listProductReviews
   * GET /products/{productId}/reviews
   *
   * @param productId String
   * @param requestParameters {@link ListProductReviewsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listProductReviews(
    @NonNull String productId,
    @NonNull ListProductReviewsParameters requestParameters
  ) throws ApiError {
    return this.listProductReviews(productId, requestParameters, null);
  }

  /**
   * Method listProductReviews
   * GET /products/{productId}/reviews
   *
   * @param productId String
   * @param requestParameters {@link ListProductReviewsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listProductReviews(
    @NonNull String productId,
    @NonNull ListProductReviewsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .listProductReviews(productId, requestParameters, requestConfig)
      .getData();
  }

  /**
   * Method listProductReviews
   * GET /products/{productId}/reviews
   *
   * @param productId String
   * @param requestParameters {@link ListProductReviewsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listProductReviewsAsync(
    @NonNull String productId,
    @NonNull ListProductReviewsParameters requestParameters
  ) throws ApiError {
    return this.listProductReviewsAsync(productId, requestParameters, null);
  }

  /**
   * Method listProductReviews
   * GET /products/{productId}/reviews
   *
   * @param productId String
   * @param requestParameters {@link ListProductReviewsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listProductReviewsAsync(
    @NonNull String productId,
    @NonNull ListProductReviewsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .listProductReviewsAsync(productId, requestParameters, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildListProductReviewsRequest(
    @NonNull String productId,
    @NonNull ListProductReviewsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.D657_D452_55_B0_48_D1_AC4_F_4_E2_DF9809838),
      "products/{productId}/reviews"
    )
      .setPathParameter("productId", productId)
      .setOptionalQueryParameter("page", requestParameters.getPage())
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .build();
  }

  /**
   * Method createReview
   * POST /products/{productId}/reviews
   *
   * @param productId String
   * @param createReviewRequest {@link CreateReviewRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createReview(
    @NonNull String productId,
    @NonNull CreateReviewRequest createReviewRequest
  ) throws ApiError {
    return this.createReview(productId, createReviewRequest, null);
  }

  /**
   * Method createReview
   * POST /products/{productId}/reviews
   *
   * @param productId String
   * @param createReviewRequest {@link CreateReviewRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createReview(
    @NonNull String productId,
    @NonNull CreateReviewRequest createReviewRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().createReview(productId, createReviewRequest, requestConfig).getData();
  }

  /**
   * Method createReview
   * POST /products/{productId}/reviews
   *
   * @param productId String
   * @param createReviewRequest {@link CreateReviewRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createReviewAsync(
    @NonNull String productId,
    @NonNull CreateReviewRequest createReviewRequest
  ) throws ApiError {
    return this.createReviewAsync(productId, createReviewRequest, null);
  }

  /**
   * Method createReview
   * POST /products/{productId}/reviews
   *
   * @param productId String
   * @param createReviewRequest {@link CreateReviewRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createReviewAsync(
    @NonNull String productId,
    @NonNull CreateReviewRequest createReviewRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .createReviewAsync(productId, createReviewRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildCreateReviewRequest(
    @NonNull String productId,
    @NonNull CreateReviewRequest createReviewRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.D657_D452_55_B0_48_D1_AC4_F_4_E2_DF9809838),
      "products/{productId}/reviews"
    )
      .setPathParameter("productId", productId)
      .setJsonContent(createReviewRequest)
      .build();
  }

  /**
   * Method getReview
   * GET /reviews/{reviewId}
   *
   * @param reviewId String
   * @return response of {@code Object}
   */
  public Object getReview(@NonNull String reviewId) throws ApiError {
    return this.getReview(reviewId, null);
  }

  /**
   * Method getReview
   * GET /reviews/{reviewId}
   *
   * @param reviewId String
   * @return response of {@code Object}
   */
  public Object getReview(@NonNull String reviewId, RequestConfig requestConfig) throws ApiError {
    return withRawResponse().getReview(reviewId, requestConfig).getData();
  }

  /**
   * Method getReview
   * GET /reviews/{reviewId}
   *
   * @param reviewId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getReviewAsync(@NonNull String reviewId) throws ApiError {
    return this.getReviewAsync(reviewId, null);
  }

  /**
   * Method getReview
   * GET /reviews/{reviewId}
   *
   * @param reviewId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getReviewAsync(
    @NonNull String reviewId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .getReviewAsync(reviewId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetReviewRequest(@NonNull String reviewId, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.D657_D452_55_B0_48_D1_AC4_F_4_E2_DF9809838),
      "reviews/{reviewId}"
    )
      .setPathParameter("reviewId", reviewId)
      .build();
  }

  /**
   * Method updateReview
   * PUT /reviews/{reviewId}
   *
   * @param reviewId String
   * @param updateReviewRequest {@link UpdateReviewRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateReview(
    @NonNull String reviewId,
    @NonNull UpdateReviewRequest updateReviewRequest
  ) throws ApiError {
    return this.updateReview(reviewId, updateReviewRequest, null);
  }

  /**
   * Method updateReview
   * PUT /reviews/{reviewId}
   *
   * @param reviewId String
   * @param updateReviewRequest {@link UpdateReviewRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateReview(
    @NonNull String reviewId,
    @NonNull UpdateReviewRequest updateReviewRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().updateReview(reviewId, updateReviewRequest, requestConfig).getData();
  }

  /**
   * Method updateReview
   * PUT /reviews/{reviewId}
   *
   * @param reviewId String
   * @param updateReviewRequest {@link UpdateReviewRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateReviewAsync(
    @NonNull String reviewId,
    @NonNull UpdateReviewRequest updateReviewRequest
  ) throws ApiError {
    return this.updateReviewAsync(reviewId, updateReviewRequest, null);
  }

  /**
   * Method updateReview
   * PUT /reviews/{reviewId}
   *
   * @param reviewId String
   * @param updateReviewRequest {@link UpdateReviewRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateReviewAsync(
    @NonNull String reviewId,
    @NonNull UpdateReviewRequest updateReviewRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .updateReviewAsync(reviewId, updateReviewRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildUpdateReviewRequest(
    @NonNull String reviewId,
    @NonNull UpdateReviewRequest updateReviewRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.D657_D452_55_B0_48_D1_AC4_F_4_E2_DF9809838),
      "reviews/{reviewId}"
    )
      .setPathParameter("reviewId", reviewId)
      .setJsonContent(updateReviewRequest)
      .build();
  }

  /**
   * Method deleteReview
   * DELETE /reviews/{reviewId}
   *
   * @param reviewId String
   * @return response of {@code Object}
   */
  public Object deleteReview(@NonNull String reviewId) throws ApiError {
    return this.deleteReview(reviewId, null);
  }

  /**
   * Method deleteReview
   * DELETE /reviews/{reviewId}
   *
   * @param reviewId String
   * @return response of {@code Object}
   */
  public Object deleteReview(@NonNull String reviewId, RequestConfig requestConfig)
    throws ApiError {
    return withRawResponse().deleteReview(reviewId, requestConfig).getData();
  }

  /**
   * Method deleteReview
   * DELETE /reviews/{reviewId}
   *
   * @param reviewId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteReviewAsync(@NonNull String reviewId) throws ApiError {
    return this.deleteReviewAsync(reviewId, null);
  }

  /**
   * Method deleteReview
   * DELETE /reviews/{reviewId}
   *
   * @param reviewId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteReviewAsync(
    @NonNull String reviewId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .deleteReviewAsync(reviewId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildDeleteReviewRequest(@NonNull String reviewId, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.D657_D452_55_B0_48_D1_AC4_F_4_E2_DF9809838),
      "reviews/{reviewId}"
    )
      .setPathParameter("reviewId", reviewId)
      .build();
  }

  /**
   * Returns an accessor whose methods mirror this service but return the full HTTP response
   * (status code, headers, and raw body) wrapped alongside the parsed data.
   *
   * @return An accessor exposing raw-response variants of this service's methods
   */
  public WithRawResponse withRawResponse() {
    return new WithRawResponse();
  }

  /**
   * Per-call accessor exposing raw-response variants of {@link ProductReviewApiSdkService}'s methods.
   * Reuses the enclosing service's request builders and configuration.
   */
  public class WithRawResponse {

    /**
     * Method listProducts
     * GET /products
     *
     * @return response of {@code ProductReviewApiSdkResponse<Object>}
     */
    public ProductReviewApiSdkResponse<Object> listProducts() throws ApiError {
      return this.listProducts(ListProductsParameters.builder().build());
    }

    /**
     * Method listProducts
     * GET /products
     *
     * @param requestParameters {@link ListProductsParameters} Request Parameters Object
     * @return response of {@code ProductReviewApiSdkResponse<Object>}
     */
    public ProductReviewApiSdkResponse<Object> listProducts(
      @NonNull ListProductsParameters requestParameters
    ) throws ApiError {
      return this.listProducts(requestParameters, null);
    }

    /**
     * Method listProducts
     * GET /products
     *
     * @param requestParameters {@link ListProductsParameters} Request Parameters Object
     * @return response of {@code ProductReviewApiSdkResponse<Object>}
     */
    public ProductReviewApiSdkResponse<Object> listProducts(
      @NonNull ListProductsParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listProductsConfig, requestConfig);
      Request request = buildListProductsRequest(requestParameters, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ProductReviewApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method listProducts
     * GET /products
     *
     * @return response of {@code CompletableFuture<ProductReviewApiSdkResponse<Object>>}
     */
    public CompletableFuture<ProductReviewApiSdkResponse<Object>> listProductsAsync()
      throws ApiError {
      return this.listProductsAsync(ListProductsParameters.builder().build());
    }

    /**
     * Method listProducts
     * GET /products
     *
     * @param requestParameters {@link ListProductsParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<ProductReviewApiSdkResponse<Object>>}
     */
    public CompletableFuture<ProductReviewApiSdkResponse<Object>> listProductsAsync(
      @NonNull ListProductsParameters requestParameters
    ) throws ApiError {
      return this.listProductsAsync(requestParameters, null);
    }

    /**
     * Method listProducts
     * GET /products
     *
     * @param requestParameters {@link ListProductsParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<ProductReviewApiSdkResponse<Object>>}
     */
    public CompletableFuture<ProductReviewApiSdkResponse<Object>> listProductsAsync(
      @NonNull ListProductsParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listProductsConfig, requestConfig);
      Request request = buildListProductsRequest(requestParameters, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ProductReviewApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method getProduct
     * GET /products/{productId}
     *
     * @param productId String
     * @return response of {@code ProductReviewApiSdkResponse<Object>}
     */
    public ProductReviewApiSdkResponse<Object> getProduct(@NonNull String productId)
      throws ApiError {
      return this.getProduct(productId, null);
    }

    /**
     * Method getProduct
     * GET /products/{productId}
     *
     * @param productId String
     * @return response of {@code ProductReviewApiSdkResponse<Object>}
     */
    public ProductReviewApiSdkResponse<Object> getProduct(
      @NonNull String productId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getProductConfig, requestConfig);
      Request request = buildGetProductRequest(productId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ProductReviewApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method getProduct
     * GET /products/{productId}
     *
     * @param productId String
     * @return response of {@code CompletableFuture<ProductReviewApiSdkResponse<Object>>}
     */
    public CompletableFuture<ProductReviewApiSdkResponse<Object>> getProductAsync(
      @NonNull String productId
    ) throws ApiError {
      return this.getProductAsync(productId, null);
    }

    /**
     * Method getProduct
     * GET /products/{productId}
     *
     * @param productId String
     * @return response of {@code CompletableFuture<ProductReviewApiSdkResponse<Object>>}
     */
    public CompletableFuture<ProductReviewApiSdkResponse<Object>> getProductAsync(
      @NonNull String productId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getProductConfig, requestConfig);
      Request request = buildGetProductRequest(productId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ProductReviewApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method listProductReviews
     * GET /products/{productId}/reviews
     *
     * @param productId String
     * @param requestParameters {@link ListProductReviewsParameters} Request Parameters Object
     * @return response of {@code ProductReviewApiSdkResponse<Object>}
     */
    public ProductReviewApiSdkResponse<Object> listProductReviews(
      @NonNull String productId,
      @NonNull ListProductReviewsParameters requestParameters
    ) throws ApiError {
      return this.listProductReviews(productId, requestParameters, null);
    }

    /**
     * Method listProductReviews
     * GET /products/{productId}/reviews
     *
     * @param productId String
     * @param requestParameters {@link ListProductReviewsParameters} Request Parameters Object
     * @return response of {@code ProductReviewApiSdkResponse<Object>}
     */
    public ProductReviewApiSdkResponse<Object> listProductReviews(
      @NonNull String productId,
      @NonNull ListProductReviewsParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listProductReviewsConfig, requestConfig);
      Request request = buildListProductReviewsRequest(
        productId,
        requestParameters,
        resolvedConfig
      );
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ProductReviewApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method listProductReviews
     * GET /products/{productId}/reviews
     *
     * @param productId String
     * @param requestParameters {@link ListProductReviewsParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<ProductReviewApiSdkResponse<Object>>}
     */
    public CompletableFuture<ProductReviewApiSdkResponse<Object>> listProductReviewsAsync(
      @NonNull String productId,
      @NonNull ListProductReviewsParameters requestParameters
    ) throws ApiError {
      return this.listProductReviewsAsync(productId, requestParameters, null);
    }

    /**
     * Method listProductReviews
     * GET /products/{productId}/reviews
     *
     * @param productId String
     * @param requestParameters {@link ListProductReviewsParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<ProductReviewApiSdkResponse<Object>>}
     */
    public CompletableFuture<ProductReviewApiSdkResponse<Object>> listProductReviewsAsync(
      @NonNull String productId,
      @NonNull ListProductReviewsParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listProductReviewsConfig, requestConfig);
      Request request = buildListProductReviewsRequest(
        productId,
        requestParameters,
        resolvedConfig
      );
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ProductReviewApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method createReview
     * POST /products/{productId}/reviews
     *
     * @param productId String
     * @param createReviewRequest {@link CreateReviewRequest} Request Body
     * @return response of {@code ProductReviewApiSdkResponse<Object>}
     */
    public ProductReviewApiSdkResponse<Object> createReview(
      @NonNull String productId,
      @NonNull CreateReviewRequest createReviewRequest
    ) throws ApiError {
      return this.createReview(productId, createReviewRequest, null);
    }

    /**
     * Method createReview
     * POST /products/{productId}/reviews
     *
     * @param productId String
     * @param createReviewRequest {@link CreateReviewRequest} Request Body
     * @return response of {@code ProductReviewApiSdkResponse<Object>}
     */
    public ProductReviewApiSdkResponse<Object> createReview(
      @NonNull String productId,
      @NonNull CreateReviewRequest createReviewRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createReviewConfig, requestConfig);
      Request request = buildCreateReviewRequest(productId, createReviewRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ProductReviewApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method createReview
     * POST /products/{productId}/reviews
     *
     * @param productId String
     * @param createReviewRequest {@link CreateReviewRequest} Request Body
     * @return response of {@code CompletableFuture<ProductReviewApiSdkResponse<Object>>}
     */
    public CompletableFuture<ProductReviewApiSdkResponse<Object>> createReviewAsync(
      @NonNull String productId,
      @NonNull CreateReviewRequest createReviewRequest
    ) throws ApiError {
      return this.createReviewAsync(productId, createReviewRequest, null);
    }

    /**
     * Method createReview
     * POST /products/{productId}/reviews
     *
     * @param productId String
     * @param createReviewRequest {@link CreateReviewRequest} Request Body
     * @return response of {@code CompletableFuture<ProductReviewApiSdkResponse<Object>>}
     */
    public CompletableFuture<ProductReviewApiSdkResponse<Object>> createReviewAsync(
      @NonNull String productId,
      @NonNull CreateReviewRequest createReviewRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createReviewConfig, requestConfig);
      Request request = buildCreateReviewRequest(productId, createReviewRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ProductReviewApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method getReview
     * GET /reviews/{reviewId}
     *
     * @param reviewId String
     * @return response of {@code ProductReviewApiSdkResponse<Object>}
     */
    public ProductReviewApiSdkResponse<Object> getReview(@NonNull String reviewId) throws ApiError {
      return this.getReview(reviewId, null);
    }

    /**
     * Method getReview
     * GET /reviews/{reviewId}
     *
     * @param reviewId String
     * @return response of {@code ProductReviewApiSdkResponse<Object>}
     */
    public ProductReviewApiSdkResponse<Object> getReview(
      @NonNull String reviewId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getReviewConfig, requestConfig);
      Request request = buildGetReviewRequest(reviewId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ProductReviewApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method getReview
     * GET /reviews/{reviewId}
     *
     * @param reviewId String
     * @return response of {@code CompletableFuture<ProductReviewApiSdkResponse<Object>>}
     */
    public CompletableFuture<ProductReviewApiSdkResponse<Object>> getReviewAsync(
      @NonNull String reviewId
    ) throws ApiError {
      return this.getReviewAsync(reviewId, null);
    }

    /**
     * Method getReview
     * GET /reviews/{reviewId}
     *
     * @param reviewId String
     * @return response of {@code CompletableFuture<ProductReviewApiSdkResponse<Object>>}
     */
    public CompletableFuture<ProductReviewApiSdkResponse<Object>> getReviewAsync(
      @NonNull String reviewId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getReviewConfig, requestConfig);
      Request request = buildGetReviewRequest(reviewId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ProductReviewApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method updateReview
     * PUT /reviews/{reviewId}
     *
     * @param reviewId String
     * @param updateReviewRequest {@link UpdateReviewRequest} Request Body
     * @return response of {@code ProductReviewApiSdkResponse<Object>}
     */
    public ProductReviewApiSdkResponse<Object> updateReview(
      @NonNull String reviewId,
      @NonNull UpdateReviewRequest updateReviewRequest
    ) throws ApiError {
      return this.updateReview(reviewId, updateReviewRequest, null);
    }

    /**
     * Method updateReview
     * PUT /reviews/{reviewId}
     *
     * @param reviewId String
     * @param updateReviewRequest {@link UpdateReviewRequest} Request Body
     * @return response of {@code ProductReviewApiSdkResponse<Object>}
     */
    public ProductReviewApiSdkResponse<Object> updateReview(
      @NonNull String reviewId,
      @NonNull UpdateReviewRequest updateReviewRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateReviewConfig, requestConfig);
      Request request = buildUpdateReviewRequest(reviewId, updateReviewRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ProductReviewApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method updateReview
     * PUT /reviews/{reviewId}
     *
     * @param reviewId String
     * @param updateReviewRequest {@link UpdateReviewRequest} Request Body
     * @return response of {@code CompletableFuture<ProductReviewApiSdkResponse<Object>>}
     */
    public CompletableFuture<ProductReviewApiSdkResponse<Object>> updateReviewAsync(
      @NonNull String reviewId,
      @NonNull UpdateReviewRequest updateReviewRequest
    ) throws ApiError {
      return this.updateReviewAsync(reviewId, updateReviewRequest, null);
    }

    /**
     * Method updateReview
     * PUT /reviews/{reviewId}
     *
     * @param reviewId String
     * @param updateReviewRequest {@link UpdateReviewRequest} Request Body
     * @return response of {@code CompletableFuture<ProductReviewApiSdkResponse<Object>>}
     */
    public CompletableFuture<ProductReviewApiSdkResponse<Object>> updateReviewAsync(
      @NonNull String reviewId,
      @NonNull UpdateReviewRequest updateReviewRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateReviewConfig, requestConfig);
      Request request = buildUpdateReviewRequest(reviewId, updateReviewRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ProductReviewApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method deleteReview
     * DELETE /reviews/{reviewId}
     *
     * @param reviewId String
     * @return response of {@code ProductReviewApiSdkResponse<Object>}
     */
    public ProductReviewApiSdkResponse<Object> deleteReview(@NonNull String reviewId)
      throws ApiError {
      return this.deleteReview(reviewId, null);
    }

    /**
     * Method deleteReview
     * DELETE /reviews/{reviewId}
     *
     * @param reviewId String
     * @return response of {@code ProductReviewApiSdkResponse<Object>}
     */
    public ProductReviewApiSdkResponse<Object> deleteReview(
      @NonNull String reviewId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(deleteReviewConfig, requestConfig);
      Request request = buildDeleteReviewRequest(reviewId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ProductReviewApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method deleteReview
     * DELETE /reviews/{reviewId}
     *
     * @param reviewId String
     * @return response of {@code CompletableFuture<ProductReviewApiSdkResponse<Object>>}
     */
    public CompletableFuture<ProductReviewApiSdkResponse<Object>> deleteReviewAsync(
      @NonNull String reviewId
    ) throws ApiError {
      return this.deleteReviewAsync(reviewId, null);
    }

    /**
     * Method deleteReview
     * DELETE /reviews/{reviewId}
     *
     * @param reviewId String
     * @return response of {@code CompletableFuture<ProductReviewApiSdkResponse<Object>>}
     */
    public CompletableFuture<ProductReviewApiSdkResponse<Object>> deleteReviewAsync(
      @NonNull String reviewId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(deleteReviewConfig, requestConfig);
      Request request = buildDeleteReviewRequest(reviewId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ProductReviewApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }
  }
}
