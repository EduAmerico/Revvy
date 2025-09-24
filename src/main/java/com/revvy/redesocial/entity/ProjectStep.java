package com.revvy.redesocial.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Entidade ProjectStep - Representa uma etapa de um projeto de customização
 */
@Entity
@Table(name = "project_steps")
public class ProjectStep extends BaseEntity {

    @NotBlank
    @Size(max = 200)
    @Column(name = "title", nullable = false)
    private String title;

    @Size(max = 2000)
    @Column(name = "description")
    private String description;

    @Column(name = "step_order", nullable = false)
    private Integer stepOrder;

    @Column(name = "estimated_time_hours")
    private Integer estimatedTimeHours;

    @Column(name = "is_completed", nullable = false)
    private Boolean isCompleted = false;

    @Column(name = "completed_at")
    private java.time.LocalDateTime completedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private CustomizationProject project;

    // Constructors
    public ProjectStep() {}

    public ProjectStep(String title, Integer stepOrder, CustomizationProject project) {
        this.title = title;
        this.stepOrder = stepOrder;
        this.project = project;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getStepOrder() { return stepOrder; }
    public void setStepOrder(Integer stepOrder) { this.stepOrder = stepOrder; }

    public Integer getEstimatedTimeHours() { return estimatedTimeHours; }
    public void setEstimatedTimeHours(Integer estimatedTimeHours) { this.estimatedTimeHours = estimatedTimeHours; }

    public Boolean getIsCompleted() { return isCompleted; }
    public void setIsCompleted(Boolean isCompleted) { this.isCompleted = isCompleted; }

    public java.time.LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(java.time.LocalDateTime completedAt) { this.completedAt = completedAt; }

    public CustomizationProject getProject() { return project; }
    public void setProject(CustomizationProject project) { this.project = project; }
}
