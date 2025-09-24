package com.revvy.redesocial.dto;

import com.revvy.redesocial.entity.SubscriptionPlan;
import java.time.LocalDateTime;

/**
 * DTO para resposta de usuário (sem informações sensíveis)
 */
public class UserResponseDto {

    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String bio;
    private String profilePictureUrl;
    private Boolean isActive;
    private Boolean isVerified;
    private SubscriptionPlan subscriptionPlan;
    private LocalDateTime subscriptionExpiresAt;
    private Integer aiCreditsRemaining;
    private String companyName;
    private String phoneNumber;
    private Boolean isGarageOwner;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors
    public UserResponseDto() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public LocalDateTime getSubscriptionExpiresAt() {
        return subscriptionExpiresAt;
    }

    public void setSubscriptionExpiresAt(LocalDateTime subscriptionExpiresAt) {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
