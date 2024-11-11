CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE SCHEMA IF NOT EXISTS trust_framework;

CREATE TABLE IF NOT EXISTS trust_framework.tenants(
    id         UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    tenant_id  VARCHAR(255) NOT NULL UNIQUE,
    name       VARCHAR(255) NOT NULL,
    domain     VARCHAR(255) UNIQUE,
    country    VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS trust_framework.tenant_configurations (
    id              UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    tenant_id       VARCHAR(255) REFERENCES trust_framework.tenants(tenant_id) ON DELETE CASCADE,
    config_key      VARCHAR(255) NOT NULL,
    config_value    TEXT,
    UNIQUE (tenant_id, config_key)
);

INSERT INTO trust_framework.tenants (tenant_id, name, domain, country)
VALUES ('770f2936-e76a-470d-84d9-6eec9f0f90d0',
        'dome-trust-framework',
        'trust-framework.dome-marketplace.eu',
        'ES');

INSERT INTO trust_framework.tenant_configurations (tenant_id, config_key, config_value)
VALUES ('770f2936-e76a-470d-84d9-6eec9f0f90d0',
        'did', 'did:key:zDnaeyRsn2w9UMZsyMBJpccfehBguSwqLxnVor3EPfmuGWyEV');


INSERT INTO trust_framework.tenant_configurations (tenant_id, config_key, config_value)
VALUES ('770f2936-e76a-470d-84d9-6eec9f0f90d0',
        'privateKeyHex', '0x1c60390469fd5fc043fbfcf89617b879c774511a27b609b0950a56b0fca17277');

INSERT INTO trust_framework.tenant_configurations (tenant_id, config_key, config_value)
VALUES ('770f2936-e76a-470d-84d9-6eec9f0f90d0',
        'publicKeyHex',
        '0x04ea4bb602567250eea058bf6372e198350cca1a5f036f61e25e0cd8d24eb03be6b453bd37226298acea1308d36c1bcc24a6beec668af56c9a8ea675d46290f787');
