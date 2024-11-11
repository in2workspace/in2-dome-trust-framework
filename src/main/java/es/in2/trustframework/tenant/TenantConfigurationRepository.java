package es.in2.trustframework.tenant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TenantConfigurationRepository extends JpaRepository<TenantConfiguration, UUID> {
    Optional<TenantConfiguration> findByTenantIdAndConfigKey(String tenantId, String configKey);
}
