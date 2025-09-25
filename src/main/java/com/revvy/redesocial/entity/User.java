package com.revvy.redesocial.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

/**
 * Entidade User - Representa um usuário da plataforma AI Tuning
 * Plataforma SaaS para customizações automotivas inteligentes
 */
@Entity
@Table(name = "users", 
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "username"),
           @UniqueConstraint(columnNames = "email")
       })
public class User extends BaseEntity {

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NotBlank
    @Size(max = 100)
    @Column(name = "email", unique = true, nullable = false)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 100)
    @Column(name = "password", nullable = false)
    private String password;

    @Size(max = 100)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 100)
    @Column(name = "last_name")
    private String lastName;

    @Size(max = 500)
    @Column(name = "bio")
    private String bio;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "is_verified", nullable = false)
    private Boolean isVerified = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "subscription_plan", nullable = false)
    private SubscriptionPlan subscriptionPlan = SubscriptionPlan.FREE;

    @Column(name = "subscription_expires_at")
    private java.time.LocalDateTime subscriptionExpiresAt;

    @Column(name = "ai_credits_remaining", nullable = false)
    private Integer aiCreditsRemaining = 10; // Créditos gratuitos iniciais

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_garage_owner", nullable = false)
    private Boolean isGarageOwner = false;

    // Relacionamentos
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Vehicle> vehicles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CustomizationProject> projects = new HashSet<>();

    // Constructors
    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<CustomizationProject> getProjects() {
        return projects;
    }

    public void setProjects(Set<CustomizationProject> projects) {
        this.projects = projects;
    }

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public java.time.LocalDateTime getSubscriptionExpiresAt() {
        return subscriptionExpiresAt;
    }

    public void setSubscriptionExpiresAt(java.time.LocalDateTime subscriptionExpiresAt) {
        this.subscriptionExpiresAt = subscriptionExpiresAt;
    }

    public Integer getAiCreditsRemaining() {
        return aiCreditsRemaining;
    }

    public void setAiCreditsRemaining(Integer aiCreditsRemaining) {
        this.aiCreditsRemaining = aiCreditsRemaining;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getIsGarageOwner() {
        return isGarageOwner;
    }

    public void setIsGarageOwner(Boolean isGarageOwner) {
        this.isGarageOwner = isGarageOwner;
    }

    // Helper methods
    public String getFullName() {
        if (firstName != null && lastName != null) {
            return firstName + " " + lastName;
        }
        return username;
    }

    public boolean hasActiveSubscription() {
        return subscriptionExpiresAt != null && subscriptionExpiresAt.isAfter(java.time.LocalDateTime.now());
    }

    public boolean canUseAiCredits(int creditsNeeded) {
        return aiCreditsRemaining != null && aiCreditsRemaining >= creditsNeeded;
    }
}
