package com.filmfest.film.exception;

import com.filmfest.film.exception.custom.CustomBadRequestException;
import com.filmfest.film.exception.custom.CustomInternalServerErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomBadRequestException.class)
    public ResponseEntity<?> handleBadRequest(CustomBadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody(ex));
    }

    @ExceptionHandler(CustomInternalServerErrorException.class)
    public ResponseEntity<?> handleInternalError(CustomInternalServerErrorException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody(ex));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody(ex));
    }

    private Map<String, Object> errorBody(Exception ex) {
        return Map.of(
                "timestamp", LocalDateTime.now(),
                "error", ex.getClass().getSimpleName(),
                "message", ex.getMessage()
        );
    }
}
