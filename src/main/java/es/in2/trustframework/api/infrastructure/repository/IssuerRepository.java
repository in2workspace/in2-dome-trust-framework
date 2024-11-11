package es.in2.trustframework.api.infrastructure.repository;

import es.in2.trustframework.api.domain.model.entity.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IssuerRepository extends JpaRepository<Issuer, String> {
    Optional<Issuer> findByDid(String did);
}
