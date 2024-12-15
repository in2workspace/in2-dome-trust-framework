package es.in2.trustframework.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import es.in2.trustframework.api.model.RecordStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CredentialRecordResponse(
        @JsonProperty("id") @NotNull @NotBlank String id,
        @JsonProperty("status") @NotNull @NotBlank RecordStatus recordStatus
) {
}
