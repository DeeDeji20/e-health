package com.deezproject.electronic.health.record.service;

import com.deezproject.electronic.health.record.Config;
import com.deezproject.electronic.health.record.data.dto.request.MedicalHistoryRequest;
import com.deezproject.electronic.health.record.data.dto.response.MedicalHistoryResponse;
import com.deezproject.electronic.health.record.data.repository.MedicalHistoryRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicalHistoryImpl implements MedicalHistory{
    @Autowired
    private MedicalHistoryRepo medicalHistoryRepo;

    private Config config;

    @Override
    public MedicalHistoryResponse createMedicalHistory(MedicalHistoryRequest medicalHistoryRequest) {
        com.deezproject.electronic.health.record.data.models.MedicalHistory m= config.modelMapper().map(medicalHistoryRequest, com.deezproject.electronic.health.record.data.models.MedicalHistory.class);
        com.deezproject.electronic.health.record.data.models.MedicalHistory savedMedicalHistory = medicalHistoryRepo.save(m);
        MedicalHistoryResponse response= config.modelMapper().map(medicalHistoryRequest, MedicalHistoryResponse.class);
        response.setMessage("Patient medical history registered successfully");
        return response;
    }
}
