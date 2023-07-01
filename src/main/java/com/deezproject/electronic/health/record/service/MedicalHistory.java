package com.deezproject.electronic.health.record.service;

import com.deezproject.electronic.health.record.data.dto.request.MedicalHistoryRequest;
import com.deezproject.electronic.health.record.data.dto.response.MedicalHistoryResponse;

public interface MedicalHistory {
    MedicalHistoryResponse createMedicalHistory(MedicalHistoryRequest medicalHistoryRequest);

}
