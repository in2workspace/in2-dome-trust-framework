package es.in2.trustframework.api.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record IssuerCredential(
    @JsonProperty("@context") List<String> context,
    @JsonProperty("id") String id,
    @JsonProperty("type") List<String> type,
    @JsonProperty("issuer") String issuer,
    @JsonProperty("validFrom") String validFrom,
    @JsonProperty("validUntil") String validUntil,
    @JsonProperty("credentialSubject") CredentialSubject credentialSubject,
    @JsonProperty("credentialSchema") CredentialSchema credentialSchema
) {

    @Builder
    public record CredentialSubject(
        @JsonProperty("id") String id,
        @JsonProperty("accreditedFor") List<AccreditedFor> accreditedFor,
        @JsonProperty("reservedAttributeId") String reservedAttributeId) {

        @Builder
        public record AccreditedFor(
            @JsonProperty("schemaId") String schemaId,
            @JsonProperty("types") List<String> types
        ) {}

    }

    @Builder
    public record CredentialSchema(
        @JsonProperty("id") String id,
        @JsonProperty("type") String type
    ) {}

}
