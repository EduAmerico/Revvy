-- Migration para criar tabela de usuários da plataforma AI Tuning
-- V1__Create_users_table.sql

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    bio VARCHAR(500),
    profile_picture_url VARCHAR(500),
    is_active BOOLEAN NOT NULL DEFAULT true,
    is_verified BOOLEAN NOT NULL DEFAULT false,
    subscription_plan VARCHAR(20) NOT NULL DEFAULT 'FREE',
    subscription_expires_at TIMESTAMP,
    ai_credits_remaining INTEGER NOT NULL DEFAULT 10,
    company_name VARCHAR(200),
    phone_number VARCHAR(20),
    is_garage_owner BOOLEAN NOT NULL DEFAULT false,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Índices para melhor performance
CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_active ON users(is_active);
CREATE INDEX idx_users_subscription ON users(subscription_plan);

-- Comentários para documentação
COMMENT ON TABLE users IS 'Tabela de usuários da plataforma AI Tuning';
COMMENT ON COLUMN users.username IS 'Nome de usuário único';
COMMENT ON COLUMN users.email IS 'Email único do usuário';
COMMENT ON COLUMN users.password IS 'Senha criptografada';
COMMENT ON COLUMN users.is_active IS 'Indica se o usuário está ativo';
COMMENT ON COLUMN users.is_verified IS 'Indica se o usuário foi verificado';
COMMENT ON COLUMN users.subscription_plan IS 'Plano de assinatura (FREE, BASIC, PROFESSIONAL, ENTERPRISE)';
COMMENT ON COLUMN users.ai_credits_remaining IS 'Créditos de IA restantes para o usuário';
COMMENT ON COLUMN users.is_garage_owner IS 'Indica se o usuário é dono de oficina';
