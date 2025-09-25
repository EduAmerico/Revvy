package com.revvy.redesocial.entity;

/**
 * Enum para tipos de projeto de customização
 */
public enum ProjectType {
    PERFORMANCE("Performance", "Melhorias de potência e torque"),
    AESTHETICS("Estética", "Modificações visuais e de estilo"),
    INTERIOR("Interior", "Customizações do interior do veículo"),
    AUDIO("Áudio", "Sistemas de som e entretenimento"),
    SUSPENSION("Suspensão", "Modificações de suspensão e rodas"),
    ENGINE("Motor", "Modificações do motor e sistema de escape"),
    ELECTRONICS("Eletrônicos", "Sistemas eletrônicos e iluminação"),
    SAFETY("Segurança", "Melhorias de segurança e proteção");

    private final String displayName;
    private final String description;

    ProjectType(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() { return displayName; }
    public String getDescription() { return description; }
}
