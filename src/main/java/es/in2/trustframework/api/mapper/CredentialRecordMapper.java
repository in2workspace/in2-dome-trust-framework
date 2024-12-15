package es.in2.trustframework.api.mapper;

import es.in2.trustframework.api.model.RecordStatus;
import es.in2.trustframework.api.model.dto.CredentialRecordRequest;
import es.in2.trustframework.api.model.dto.CredentialRecordResponse;
import es.in2.trustframework.api.model.entity.CredentialRecord;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CredentialRecordMapper {

    public CredentialRecord toEntity(CredentialRecordRequest credentialRecordRequest) {
        CredentialRecord entity = new CredentialRecord();
        entity.setCredentialId(credentialRecordRequest.id());
        RecordStatus status = convertToRecordStatus(credentialRecordRequest.recordStatus());
        entity.setRecordStatus(status);
        entity.setCreatedAt(new Date());
        return entity;
    }

    public CredentialRecordResponse toResponse(CredentialRecord entity) {
        return new CredentialRecordResponse(
                entity.getCredentialId(),
                entity.getRecordStatus()
        );
    }

    private RecordStatus convertToRecordStatus(String status) {
        return switch (status.toLowerCase()) {
            case "active" -> RecordStatus.ACTIVE;
            case "inactive" -> RecordStatus.INACTIVE;
            default -> throw new IllegalArgumentException("Unknown status: " + status);
        };
    }

}
