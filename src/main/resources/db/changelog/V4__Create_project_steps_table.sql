-- Migration para criar tabela de etapas do projeto
-- V4__Create_project_steps_table.sql

CREATE TABLE project_steps (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description VARCHAR(2000),
    step_order INTEGER NOT NULL,
    estimated_time_hours INTEGER,
    is_completed BOOLEAN NOT NULL DEFAULT false,
    completed_at TIMESTAMP,
    project_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (project_id) REFERENCES customization_projects(id) ON DELETE CASCADE
);

-- Índices para melhor performance
CREATE INDEX idx_steps_project ON project_steps(project_id);
CREATE INDEX idx_steps_order ON project_steps(project_id, step_order);
CREATE INDEX idx_steps_completed ON project_steps(is_completed);

-- Comentários para documentação
COMMENT ON TABLE project_steps IS 'Tabela de etapas de projetos de customização';
COMMENT ON COLUMN project_steps.step_order IS 'Ordem da etapa no projeto';
COMMENT ON COLUMN project_steps.is_completed IS 'Indica se a etapa foi concluída';
COMMENT ON COLUMN project_steps.completed_at IS 'Data e hora de conclusão da etapa';
