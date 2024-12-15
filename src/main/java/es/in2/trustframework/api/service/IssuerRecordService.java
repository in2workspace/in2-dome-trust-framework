package es.in2.trustframework.api.service;

import es.in2.trustframework.api.model.dto.IssuerRecordRequest;
import es.in2.trustframework.api.model.dto.IssuerRecordResponse;

public interface IssuerRecordService {
    void registerIssuerRecord(IssuerRecordRequest issuerRecordRequest);
    IssuerRecordResponse getIssuerByDid(String did);
}
