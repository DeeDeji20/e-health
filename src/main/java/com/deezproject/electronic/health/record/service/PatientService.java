package com.deezproject.electronic.health.record.service;

import com.deezproject.electronic.health.record.data.dto.request.PatientRegisterDto;
import com.deezproject.electronic.health.record.data.dto.response.ApiResponse;

public interface PatientService {
    ApiResponse<?> registerPatient(PatientRegisterDto request);
}
