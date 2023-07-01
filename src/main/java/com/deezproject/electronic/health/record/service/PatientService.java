package com.deezproject.electronic.health.record.service;

import com.deezproject.electronic.health.record.data.dto.request.PatientRegisterDto;
import com.deezproject.electronic.health.record.data.dto.response.PatientRegisterResponse;

public interface PatientService {
    PatientRegisterResponse registerPatient(PatientRegisterDto request);
}
