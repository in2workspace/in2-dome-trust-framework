package es.in2.trustframework.api.repository;

import es.in2.trustframework.api.model.entity.CredentialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CredentialRecordRepository extends JpaRepository<CredentialRecord, UUID> {
    Optional<CredentialRecord> findTopByCredentialIdOrderByCreatedAtDesc(String credentialId);

}
