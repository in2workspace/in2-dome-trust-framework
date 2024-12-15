package es.in2.trustframework.api.service.impl;

import es.in2.trustframework.api.exception.CredentialRecordNotFoundException;
import es.in2.trustframework.api.mapper.CredentialRecordMapper;
import es.in2.trustframework.api.model.dto.CredentialRecordRequest;
import es.in2.trustframework.api.model.dto.CredentialRecordResponse;
import es.in2.trustframework.api.model.entity.CredentialRecord;
import es.in2.trustframework.api.repository.CredentialRecordRepository;
import es.in2.trustframework.api.service.CredentialRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CredentialRecordServiceImpl implements CredentialRecordService {

    private final CredentialRecordRepository credentialRecordRepository;
    private final CredentialRecordMapper credentialRecordMapper;

    @Override
    public void registerCredentialRecord(CredentialRecordRequest credentialRecordRequest) {
        CredentialRecord entity = credentialRecordMapper.toEntity(credentialRecordRequest);
        credentialRecordRepository.save(entity);
    }

    @Override
    public CredentialRecordResponse getCredentialRecord(String id) {
        Optional<CredentialRecord> credentialRecord = credentialRecordRepository.findTopByCredentialIdOrderByCreatedAtDesc(id);
        return credentialRecord.map(credentialRecordMapper::toResponse)
                .orElseThrow(() -> new CredentialRecordNotFoundException("Credential not found with id: " + id));
    }

}
