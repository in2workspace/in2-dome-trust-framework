CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE SCHEMA IF NOT EXISTS trust_framework;

CREATE TABLE IF NOT EXISTS trusted_items (
    id uuid PRIMARY KEY UNIQUE DEFAULT uuid_generate_v4(),
    list_name VARCHAR(255) NOT NULL,
    did VARCHAR(255) NOT NULL,
    attributes JSONB
);
