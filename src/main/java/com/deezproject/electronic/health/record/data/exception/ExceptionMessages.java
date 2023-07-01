package com.deezproject.electronic.health.record.data.exception;

public enum ExceptionMessages {
    PATIENT_ALREADY_EXIST_EMAIL("Patient with email %s already exists");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
