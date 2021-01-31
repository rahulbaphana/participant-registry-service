package com.participant.registry.domain.participant.exception;

public class InvalidDateOfBirthFormatException extends RuntimeException {
    public InvalidDateOfBirthFormatException(String message) {
        super(message);
    }
}
