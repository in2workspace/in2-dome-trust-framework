package es.in2.trustframework.tenant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenantConfigurationServiceImpl implements TenantConfigurationService {

    private final TenantConfigurationRepository tenantConfigurationRepository;

    @Override
    public void saveTenantConfiguration(String tenantId, String key, String value) {
        TenantConfiguration tenantConfiguration = TenantConfiguration.builder()
                .tenantId(tenantId)
                .configKey(key)
                .configValue(value)
                .build();
        tenantConfigurationRepository.save(tenantConfiguration);
    }

    @Override
    public String getTenantConfiguration(String tenantId, String key) {
        return tenantConfigurationRepository.findByTenantIdAndConfigKey(tenantId, key)
                .map(TenantConfiguration::getConfigValue)
                .orElse(null);
    }

    @Override
    public void updateTenantConfiguration(String tenantId, String key, String value) {
        TenantConfiguration tenantConfiguration = TenantConfiguration.builder()
                .tenantId(tenantId)
                .configKey(key)
                .configValue(value)
                .build();
        tenantConfigurationRepository.save(tenantConfiguration);
    }

}
