package com.revvy.redesocial.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO para criação de usuário
 */
public class CreateUserDto {

    @NotBlank(message = "Username é obrigatório")
    @Size(min = 3, max = 50, message = "Username deve ter entre 3 e 50 caracteres")
    private String username;

    @NotBlank(message = "Email é obrigatório")
    @Size(max = 100, message = "Email deve ter no máximo 100 caracteres")
    @Email(message = "Email deve ter formato válido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, max = 100, message = "Senha deve ter entre 6 e 100 caracteres")
    private String password;

    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    private String firstName;

    @Size(max = 100, message = "Sobrenome deve ter no máximo 100 caracteres")
    private String lastName;

    @Size(max = 500, message = "Bio deve ter no máximo 500 caracteres")
    private String bio;

    @Size(max = 200, message = "Nome da empresa deve ter no máximo 200 caracteres")
    private String companyName;

    @Size(max = 20, message = "Telefone deve ter no máximo 20 caracteres")
    private String phoneNumber;

    private Boolean isGarageOwner = false;

    // Constructors
    public CreateUserDto() {}

    public CreateUserDto(String username, String email, String password) {
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
}
