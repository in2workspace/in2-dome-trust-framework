package es.in2.trustframework.api.service.impl;

import es.in2.trustframework.api.exception.IssuerRecordNotFoundException;
import es.in2.trustframework.api.mapper.IssuerRecordMapper;
import es.in2.trustframework.api.model.dto.IssuerRecordRequest;
import es.in2.trustframework.api.model.dto.IssuerRecordResponse;
import es.in2.trustframework.api.model.entity.IssuerRecord;
import es.in2.trustframework.api.service.IssuerRecordService;
import es.in2.trustframework.api.repository.IssuerRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IssuerRecordServiceImpl implements IssuerRecordService {

    private final IssuerRecordRepository issuerRecordRepository;
    private final IssuerRecordMapper issuerRecordMapper;

    @Override
    public void registerIssuerRecord(IssuerRecordRequest issuerRecordRequest) {
        IssuerRecord issuerRecord = issuerRecordMapper.toEntity(issuerRecordRequest);
        issuerRecordRepository.save(issuerRecord);
    }

    @Override
    public IssuerRecordResponse getIssuerByDid(String did) {
        Optional<IssuerRecord> issuerRecord = issuerRecordRepository.findByDid(did);
        return issuerRecord.map(issuerRecordMapper::toResponse)
                .orElseThrow(() -> new IssuerRecordNotFoundException("Issuer not found with did: " + did));
    }

}
