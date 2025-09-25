package com.revvy.redesocial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Handler global para tratamento de exceções
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Trata exceções de validação (@Valid)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            "Erro de validação",
            errors,
            LocalDateTime.now()
        );

        return ResponseEntity.badRequest().body(errorResponse);
    }

    /**
     * Trata exceções de recurso não encontrado
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage(),
            null,
            LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    /**
     * Trata exceções de recurso já existente
     */
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.CONFLICT.value(),
            ex.getMessage(),
            null,
            LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    /**
     * Trata exceções genéricas
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Erro interno do servidor",
            null,
            LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    /**
     * Classe para resposta de erro padronizada
     */
    public static class ErrorResponse {
        private int status;
        private String message;
        private Object details;
        private LocalDateTime timestamp;

        public ErrorResponse(int status, String message, Object details, LocalDateTime timestamp) {
            this.status = status;
            this.message = message;
            this.details = details;
            this.timestamp = timestamp;
        }

        // Getters
        public int getStatus() { return status; }
        public String getMessage() { return message; }
        public Object getDetails() { return details; }
        public LocalDateTime getTimestamp() { return timestamp; }
    }
}
