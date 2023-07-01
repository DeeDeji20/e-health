package com.deezproject.electronic.health.record.data.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class MedicalHistoryResponse {
    private Long id;
    private String ailments;
    private String allergies;
    private String medications;
    private String message;
}
