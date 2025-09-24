package com.revvy.redesocial.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Entidade ProjectImage - Representa uma imagem de um projeto
 */
@Entity
@Table(name = "project_images")
public class ProjectImage extends BaseEntity {

    @NotBlank
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "image_type")
    private String imageType; // BEFORE, AFTER, STEP, REFERENCE

    @Column(name = "description")
    private String description;

    @Column(name = "is_main_image", nullable = false)
    private Boolean isMainImage = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private CustomizationProject project;

    // Constructors
    public ProjectImage() {}

    public ProjectImage(String imageUrl, CustomizationProject project) {
        this.imageUrl = imageUrl;
        this.project = project;
    }

    // Getters and Setters
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getImageType() { return imageType; }
    public void setImageType(String imageType) { this.imageType = imageType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Boolean getIsMainImage() { return isMainImage; }
    public void setIsMainImage(Boolean isMainImage) { this.isMainImage = isMainImage; }

    public CustomizationProject getProject() { return project; }
    public void setProject(CustomizationProject project) { this.project = project; }
}
