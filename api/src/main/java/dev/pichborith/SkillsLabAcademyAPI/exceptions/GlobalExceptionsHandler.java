package dev.pichborith.SkillsLabAcademyAPI.exceptions;

import dev.pichborith.SkillsLabAcademyAPI.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(
        NotFoundException e) {

        var response = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                                         e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleException(
        UnauthorizedException e) {

        var response = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(),
                                         e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> handleException(ConflictException e) {

        var response = new ErrorResponse(HttpStatus.CONFLICT.value(),
                                         e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
