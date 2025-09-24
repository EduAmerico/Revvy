-- Migration para criar tabela de imagens do projeto
-- V5__Create_project_images_table.sql

CREATE TABLE project_images (
    id BIGSERIAL PRIMARY KEY,
    image_url VARCHAR(500) NOT NULL,
    image_type VARCHAR(20),
    description VARCHAR(500),
    is_main_image BOOLEAN NOT NULL DEFAULT false,
    project_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (project_id) REFERENCES customization_projects(id) ON DELETE CASCADE
);

-- Índices para melhor performance
CREATE INDEX idx_images_project ON project_images(project_id);
CREATE INDEX idx_images_type ON project_images(image_type);
CREATE INDEX idx_images_main ON project_images(is_main_image);

-- Comentários para documentação
COMMENT ON TABLE project_images IS 'Tabela de imagens dos projetos de customização';
COMMENT ON COLUMN project_images.image_type IS 'Tipo da imagem (BEFORE, AFTER, STEP, REFERENCE)';
COMMENT ON COLUMN project_images.is_main_image IS 'Indica se é a imagem principal do projeto';
