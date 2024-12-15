package es.in2.trustframework.api.service;

import es.in2.trustframework.api.model.dto.CredentialRecordRequest;
import es.in2.trustframework.api.model.dto.CredentialRecordResponse;

public interface CredentialRecordService {
    void registerCredentialRecord(CredentialRecordRequest credentialRecordRequest);
    CredentialRecordResponse getCredentialRecord(String id);
}
