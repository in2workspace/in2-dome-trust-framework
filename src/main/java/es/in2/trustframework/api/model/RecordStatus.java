package es.in2.trustframework.api.model;

import lombok.Getter;

@Getter
public enum RecordStatus {
    ACTIVE("active"),
    INACTIVE("inactive");

    private final String status;

    RecordStatus(String status) {
        this.status = status;
    }
}
