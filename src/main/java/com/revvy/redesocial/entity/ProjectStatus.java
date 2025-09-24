package com.revvy.redesocial.entity;

/**
 * Enum para status do projeto
 */
public enum ProjectStatus {
    DRAFT("Rascunho", "Projeto em desenvolvimento"),
    PLANNING("Planejamento", "Definindo detalhes e materiais"),
    IN_PROGRESS("Em Andamento", "Executando as modificações"),
    COMPLETED("Concluído", "Projeto finalizado"),
    CANCELLED("Cancelado", "Projeto cancelado"),
    ON_HOLD("Pausado", "Projeto temporariamente pausado");

    private final String displayName;
    private final String description;

    ProjectStatus(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() { return displayName; }
    public String getDescription() { return description; }
}
