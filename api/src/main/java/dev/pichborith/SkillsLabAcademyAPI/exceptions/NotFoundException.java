package dev.pichborith.SkillsLabAcademyAPI.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
