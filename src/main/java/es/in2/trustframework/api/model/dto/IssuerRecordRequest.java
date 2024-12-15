package es.in2.trustframework.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record IssuerRecordRequest(
        @JsonProperty("did") @NotNull @NotBlank String did,
        @JsonProperty("attributes") @NotNull @NotBlank List<IssuerRecordAttribute> attributes

) {
}
