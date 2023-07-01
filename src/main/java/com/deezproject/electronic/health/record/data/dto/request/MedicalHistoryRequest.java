package com.deezproject.electronic.health.record.data.dto.request;

import com.deezproject.electronic.health.record.data.models.Patient;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MedicalHistoryRequest {
    private List<String> ailments;
    private List<String> allergies;
    private List<String> medications;
}
