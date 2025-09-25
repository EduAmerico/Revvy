package com.revvy.redesocial.entity;

/**
 * Enum para planos de assinatura da plataforma AI Tuning
 */
public enum SubscriptionPlan {
    FREE("Gratuito", 0.0, 10, false),
    BASIC("Básico", 29.90, 100, true),
    PROFESSIONAL("Profissional", 79.90, 500, true),
    ENTERPRISE("Empresarial", 199.90, 2000, true);

    private final String displayName;
    private final Double monthlyPrice;
    private final Integer aiCreditsPerMonth;
    private final Boolean hasAdvancedFeatures;

    SubscriptionPlan(String displayName, Double monthlyPrice, Integer aiCreditsPerMonth, Boolean hasAdvancedFeatures) {
        this.displayName = displayName;
        this.monthlyPrice = monthlyPrice;
        this.aiCreditsPerMonth = aiCreditsPerMonth;
        this.hasAdvancedFeatures = hasAdvancedFeatures;
    }

    // Getters
    public String getDisplayName() { return displayName; }
    public Double getMonthlyPrice() { return monthlyPrice; }
    public Integer getAiCreditsPerMonth() { return aiCreditsPerMonth; }
    public Boolean getHasAdvancedFeatures() { return hasAdvancedFeatures; }
}
