package com.productreviewapisdk.http;

import lombok.Getter;

/**
 * Predefined environment configurations for the SDK.
 * Each environment represents a different base URL (e.g., production, staging, development).
 */
@Getter
public enum Environment {
  DEFAULT("https://d657d452-55b0-48d1-ac4f-4e2df9809838.mock.pstmn.io"),
  D657_D452_55_B0_48_D1_AC4_F_4_E2_DF9809838(
    "https://d657d452-55b0-48d1-ac4f-4e2df9809838.mock.pstmn.io"
  );

  private final String url;

  Environment(String url) {
    this.url = url;
  }
}
