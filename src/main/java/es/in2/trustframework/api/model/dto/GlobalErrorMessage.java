package es.in2.trustframework.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record GlobalErrorMessage(
        @JsonProperty("timestamp") Date timestamp,
        @JsonProperty("error_id") String errorId,
        @JsonProperty("message") String message
) {
}
