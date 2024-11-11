package es.in2.trustframework.tenant;

public interface TenantConfigurationService {
    void saveTenantConfiguration(String tenantId, String key, String value);
    String getTenantConfiguration(String tenantId, String key);
    void updateTenantConfiguration(String tenantId, String key, String value);
}
