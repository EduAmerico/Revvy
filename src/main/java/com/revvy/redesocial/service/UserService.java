package com.revvy.redesocial.service;

import com.revvy.redesocial.dto.CreateUserDto;
import com.revvy.redesocial.dto.UserResponseDto;
import com.revvy.redesocial.entity.User;
import com.revvy.redesocial.exception.ResourceAlreadyExistsException;
import com.revvy.redesocial.exception.ResourceNotFoundException;
import com.revvy.redesocial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service para operações de usuário
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Cria um novo usuário
     */
    public UserResponseDto createUser(CreateUserDto createUserDto) {
        // Verifica se username já existe
        if (userRepository.existsByUsername(createUserDto.getUsername())) {
            throw new ResourceAlreadyExistsException("Username já está em uso: " + createUserDto.getUsername());
        }

        // Verifica se email já existe
        if (userRepository.existsByEmail(createUserDto.getEmail())) {
            throw new ResourceAlreadyExistsException("Email já está em uso: " + createUserDto.getEmail());
        }

        // Cria novo usuário
        User user = new User();
        user.setUsername(createUserDto.getUsername());
        user.setEmail(createUserDto.getEmail());
        user.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setBio(createUserDto.getBio());
        user.setCompanyName(createUserDto.getCompanyName());
        user.setPhoneNumber(createUserDto.getPhoneNumber());
        user.setIsGarageOwner(createUserDto.getIsGarageOwner());

        User savedUser = userRepository.save(user);
        return convertToResponseDto(savedUser);
    }

    /**
     * Busca usuário por ID
     */
    @Transactional(readOnly = true)
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
        return convertToResponseDto(user);
    }

    /**
     * Busca usuário por username
     */
    @Transactional(readOnly = true)
    public UserResponseDto getUserByUsername(String username) {
        User user = userRepository.findActiveByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com username: " + username));
        return convertToResponseDto(user);
    }

    /**
     * Lista todos os usuários ativos
     */
    @Transactional(readOnly = true)
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .filter(User::getIsActive)
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    /**
     * Converte entidade User para DTO de resposta
     */
    private UserResponseDto convertToResponseDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setBio(user.getBio());
        dto.setProfilePictureUrl(user.getProfilePictureUrl());
        dto.setIsActive(user.getIsActive());
        dto.setIsVerified(user.getIsVerified());
        dto.setSubscriptionPlan(user.getSubscriptionPlan());
        dto.setSubscriptionExpiresAt(user.getSubscriptionExpiresAt());
        dto.setAiCreditsRemaining(user.getAiCreditsRemaining());
        dto.setCompanyName(user.getCompanyName());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setIsGarageOwner(user.getIsGarageOwner());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        return dto;
    }
}
