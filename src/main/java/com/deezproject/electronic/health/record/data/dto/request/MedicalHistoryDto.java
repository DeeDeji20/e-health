package com.deezproject.electronic.health.record.data.dto.request;

import com.deezproject.electronic.health.record.data.models.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalHistoryDto {
    private Patient patientId;
    private String ailments;
    private String allergies;
    private String medications;
}
