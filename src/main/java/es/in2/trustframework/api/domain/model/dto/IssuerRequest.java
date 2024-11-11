package es.in2.trustframework.api.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IssuerRequest(
        @JsonProperty("did") String did
) {
}
