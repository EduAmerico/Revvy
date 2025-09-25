-- Migration para criar tabela de projetos de customização
-- V3__Create_customization_projects_table.sql

CREATE TABLE customization_projects (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description VARCHAR(1000),
    project_type VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'DRAFT',
    ai_generated BOOLEAN NOT NULL DEFAULT false,
    ai_prompt TEXT,
    ai_response TEXT,
    estimated_cost DECIMAL(10,2),
    estimated_time_hours INTEGER,
    difficulty_level INTEGER CHECK (difficulty_level >= 1 AND difficulty_level <= 5),
    ai_credits_used INTEGER NOT NULL DEFAULT 0,
    user_id BIGINT NOT NULL,
    vehicle_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id) ON DELETE CASCADE
);

-- Índices para melhor performance
CREATE INDEX idx_projects_user ON customization_projects(user_id);
CREATE INDEX idx_projects_vehicle ON customization_projects(vehicle_id);
CREATE INDEX idx_projects_type ON customization_projects(project_type);
CREATE INDEX idx_projects_status ON customization_projects(status);
CREATE INDEX idx_projects_ai_generated ON customization_projects(ai_generated);

-- Comentários para documentação
COMMENT ON TABLE customization_projects IS 'Tabela de projetos de customização automotiva';
COMMENT ON COLUMN customization_projects.project_type IS 'Tipo do projeto (PERFORMANCE, AESTHETICS, etc.)';
COMMENT ON COLUMN customization_projects.status IS 'Status do projeto (DRAFT, PLANNING, etc.)';
COMMENT ON COLUMN customization_projects.ai_generated IS 'Indica se o projeto foi gerado por IA';
COMMENT ON COLUMN customization_projects.ai_credits_used IS 'Créditos de IA utilizados neste projeto';
COMMENT ON COLUMN customization_projects.difficulty_level IS 'Nível de dificuldade (1-5)';
