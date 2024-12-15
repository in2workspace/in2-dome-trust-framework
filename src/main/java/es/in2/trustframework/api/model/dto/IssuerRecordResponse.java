package es.in2.trustframework.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record IssuerRecordResponse(
        @JsonProperty("did") String did,
        @JsonProperty("attributes") List<IssuerRecordAttribute> attributes
) {
}
