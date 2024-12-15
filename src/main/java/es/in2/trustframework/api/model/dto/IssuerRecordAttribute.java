package es.in2.trustframework.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record IssuerRecordAttribute(
        @JsonProperty("hash") String hash,
        @JsonProperty("body") @NotNull @NotBlank String body,
        @JsonProperty("issuerType") String issuerType,
        @JsonProperty("tao") String tao,
        @JsonProperty("rootTao") String rootTao
) {
}
