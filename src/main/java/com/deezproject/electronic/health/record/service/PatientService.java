package com.deezproject.electronic.health.record.service;

import com.deezproject.electronic.health.record.data.dto.request.PatientRegisterDto;
import com.deezproject.electronic.health.record.data.dto.response.PatientRegisterResponse;
import com.deezproject.electronic.health.record.data.models.Patient;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    PatientRegisterResponse registerPatient(PatientRegisterDto request);

    Page<Patient> findByName(String name, int pageNumber);
}
