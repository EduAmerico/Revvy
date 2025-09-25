package com.revvy.redesocial.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

/**
 * Entidade CustomizationProject - Representa um projeto de customização
 */
@Entity
@Table(name = "customization_projects")
public class CustomizationProject extends BaseEntity {

    @NotBlank
    @Size(max = 200)
    @Column(name = "title", nullable = false)
    private String title;

    @Size(max = 1000)
    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_type", nullable = false)
    private ProjectType projectType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProjectStatus status = ProjectStatus.DRAFT;

    @Column(name = "ai_generated", nullable = false)
    private Boolean aiGenerated = false;

    @Column(name = "ai_prompt")
    private String aiPrompt;

    @Column(name = "ai_response")
    private String aiResponse;

    @Column(name = "estimated_cost", precision = 10, scale = 2)
    private BigDecimal estimatedCost;

    @Column(name = "estimated_time_hours")
    private Integer estimatedTimeHours;

    @Column(name = "difficulty_level")
    private Integer difficultyLevel; // 1-5

    @Column(name = "ai_credits_used", nullable = false)
    private Integer aiCreditsUsed = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private java.util.Set<ProjectStep> steps = new java.util.HashSet<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private java.util.Set<ProjectImage> images = new java.util.HashSet<>();

    // Constructors
    public CustomizationProject() {}

    public CustomizationProject(String title, ProjectType projectType, User user, Vehicle vehicle) {
        this.title = title;
        this.projectType = projectType;
        this.user = user;
        this.vehicle = vehicle;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public ProjectType getProjectType() { return projectType; }
    public void setProjectType(ProjectType projectType) { this.projectType = projectType; }

    public ProjectStatus getStatus() { return status; }
    public void setStatus(ProjectStatus status) { this.status = status; }

    public Boolean getAiGenerated() { return aiGenerated; }
    public void setAiGenerated(Boolean aiGenerated) { this.aiGenerated = aiGenerated; }

    public String getAiPrompt() { return aiPrompt; }
    public void setAiPrompt(String aiPrompt) { this.aiPrompt = aiPrompt; }

    public String getAiResponse() { return aiResponse; }
    public void setAiResponse(String aiResponse) { this.aiResponse = aiResponse; }

    public BigDecimal getEstimatedCost() { return estimatedCost; }
    public void setEstimatedCost(BigDecimal estimatedCost) { this.estimatedCost = estimatedCost; }

    public Integer getEstimatedTimeHours() { return estimatedTimeHours; }
    public void setEstimatedTimeHours(Integer estimatedTimeHours) { this.estimatedTimeHours = estimatedTimeHours; }

    public Integer getDifficultyLevel() { return difficultyLevel; }
    public void setDifficultyLevel(Integer difficultyLevel) { this.difficultyLevel = difficultyLevel; }

    public Integer getAiCreditsUsed() { return aiCreditsUsed; }
    public void setAiCreditsUsed(Integer aiCreditsUsed) { this.aiCreditsUsed = aiCreditsUsed; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public java.util.Set<ProjectStep> getSteps() { return steps; }
    public void setSteps(java.util.Set<ProjectStep> steps) { this.steps = steps; }

    public java.util.Set<ProjectImage> getImages() { return images; }
    public void setImages(java.util.Set<ProjectImage> images) { this.images = images; }
}
