-- Migration para criar tabela de veículos
-- V2__Create_vehicles_table.sql

CREATE TABLE vehicles (
    id BIGSERIAL PRIMARY KEY,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    year INTEGER NOT NULL,
    license_plate VARCHAR(20),
    color VARCHAR(50),
    engine_type VARCHAR(50),
    engine_power INTEGER,
    fuel_type VARCHAR(20),
    mileage INTEGER,
    description VARCHAR(500),
    main_image_url VARCHAR(500),
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Índices para melhor performance
CREATE INDEX idx_vehicles_user ON vehicles(user_id);
CREATE INDEX idx_vehicles_brand_model ON vehicles(brand, model);
CREATE INDEX idx_vehicles_year ON vehicles(year);

-- Comentários para documentação
COMMENT ON TABLE vehicles IS 'Tabela de veículos cadastrados na plataforma';
COMMENT ON COLUMN vehicles.brand IS 'Marca do veículo';
COMMENT ON COLUMN vehicles.model IS 'Modelo do veículo';
COMMENT ON COLUMN vehicles.year IS 'Ano do veículo';
COMMENT ON COLUMN vehicles.engine_power IS 'Potência do motor em HP';
COMMENT ON COLUMN vehicles.mileage IS 'Quilometragem do veículo';
