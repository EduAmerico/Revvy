package com.revvy.redesocial.repository;

import com.revvy.redesocial.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository para operações de banco de dados da entidade User
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Busca usuário por username
     */
    Optional<User> findByUsername(String username);

    /**
     * Busca usuário por email
     */
    Optional<User> findByEmail(String email);

    /**
     * Verifica se username existe
     */
    boolean existsByUsername(String username);

    /**
     * Verifica se email existe
     */
    boolean existsByEmail(String email);

    /**
     * Busca usuários ativos por username (case insensitive)
     */
    @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username) AND u.isActive = true")
    Optional<User> findActiveByUsername(@Param("username") String username);

    /**
     * Busca usuários ativos por email (case insensitive)
     */
    @Query("SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email) AND u.isActive = true")
    Optional<User> findActiveByEmail(@Param("email") String email);
}
