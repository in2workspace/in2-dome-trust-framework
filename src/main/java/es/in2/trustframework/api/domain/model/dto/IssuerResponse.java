package es.in2.trustframework.api.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record IssuerResponse(
        @JsonProperty("did") String did,
        @JsonProperty("attributes") List<AttributeResponse> attributes
) {

    public record AttributeResponse(
            @JsonProperty("hash") String hash,
            @JsonProperty("body") String body,
            @JsonProperty("issuerType") String issuerType,
            @JsonProperty("tao") String tao,
            @JsonProperty("rootTao") String rootTao
    ) {}

}
