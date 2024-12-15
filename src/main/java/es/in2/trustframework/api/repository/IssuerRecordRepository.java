package es.in2.trustframework.api.repository;

import es.in2.trustframework.api.model.entity.IssuerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IssuerRecordRepository extends JpaRepository<IssuerRecord, UUID> {
    Optional<IssuerRecord> findByDid(String did);
}
