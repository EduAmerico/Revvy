package com.revvy.redesocial.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Entidade Vehicle - Representa um veículo cadastrado na plataforma
 */
@Entity
@Table(name = "vehicles")
public class Vehicle extends BaseEntity {

    @NotBlank
    @Size(max = 100)
    @Column(name = "brand", nullable = false)
    private String brand;

    @NotBlank
    @Size(max = 100)
    @Column(name = "model", nullable = false)
    private String model;

    @NotNull
    @Column(name = "year", nullable = false)
    private Integer year;

    @Size(max = 20)
    @Column(name = "license_plate")
    private String licensePlate;

    @Size(max = 50)
    @Column(name = "color")
    private String color;

    @Size(max = 50)
    @Column(name = "engine_type")
    private String engineType;

    @Column(name = "engine_power")
    private Integer enginePower; // em HP

    @Size(max = 20)
    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "mileage")
    private Integer mileage; // quilometragem

    @Size(max = 500)
    @Column(name = "description")
    private String description;

    @Column(name = "main_image_url")
    private String mainImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private java.util.Set<CustomizationProject> projects = new java.util.HashSet<>();

    // Constructors
    public Vehicle() {}

    public Vehicle(String brand, String model, Integer year, User user) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.user = user;
    }

    // Getters and Setters
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getEngineType() { return engineType; }
    public void setEngineType(String engineType) { this.engineType = engineType; }

    public Integer getEnginePower() { return enginePower; }
    public void setEnginePower(Integer enginePower) { this.enginePower = enginePower; }

    public String getFuelType() { return fuelType; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public Integer getMileage() { return mileage; }
    public void setMileage(Integer mileage) { this.mileage = mileage; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getMainImageUrl() { return mainImageUrl; }
    public void setMainImageUrl(String mainImageUrl) { this.mainImageUrl = mainImageUrl; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public java.util.Set<CustomizationProject> getProjects() { return projects; }
    public void setProjects(java.util.Set<CustomizationProject> projects) { this.projects = projects; }

    // Helper methods
    public String getFullName() {
        return brand + " " + model + " (" + year + ")";
    }
}
