package com.deezproject.electronic.health.record.service;

import com.deezproject.electronic.health.record.Config;
import com.deezproject.electronic.health.record.data.dto.request.MedicalHistoryRequest;
import com.deezproject.electronic.health.record.data.dto.request.PatientRegisterDto;
import com.deezproject.electronic.health.record.data.dto.response.PatientRegisterResponse;
import com.deezproject.electronic.health.record.data.exception.DuplicatePatientException;
import com.deezproject.electronic.health.record.data.exception.InvalidEmailException;
import com.deezproject.electronic.health.record.data.models.Patient;
import com.deezproject.electronic.health.record.data.repository.PatientRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.deezproject.electronic.health.record.data.exception.ExceptionMessages.INVALID_EMAIL;
import static com.deezproject.electronic.health.record.data.exception.ExceptionMessages.PATIENT_ALREADY_EXIST_EMAIL;
import static com.deezproject.electronic.health.record.util.AppUtils.SUCCESS;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    MedicalHistory medicalHistory;

    Config config;

    @Override
    public PatientRegisterResponse registerPatient(PatientRegisterDto request) {
        boolean isValidEmail = isValidEmail(request.getEmail());
        if (!isValidEmail) throw new InvalidEmailException(String.format(INVALID_EMAIL.getMessage(), request.getEmail()));
        boolean isRegisteredPatient = patientRepo.existsByEmail(request.getEmail());
        if(isRegisteredPatient) throw new DuplicatePatientException(String.format(PATIENT_ALREADY_EXIST_EMAIL.getMessage(), request.getEmail()));
        Patient patient = config.modelMapper().map(request, Patient.class);
        var savedPatient = patientRepo.save(patient);
        var mappedPatient = config.modelMapper().map(savedPatient, PatientRegisterResponse.class);
        mappedPatient.setMessage(SUCCESS);
        return mappedPatient;
    }

    private boolean isValidEmail(String email) {
        String regex = "[a-zA-z][\\w-]{1,20}@\\w{2,20}\\.\\w{2,3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


}
