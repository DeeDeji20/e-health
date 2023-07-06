package com.deezproject.electronic.health.record.service;

import com.deezproject.electronic.health.record.Config;
import com.deezproject.electronic.health.record.data.dto.request.MedicalHistoryRequest;
import com.deezproject.electronic.health.record.data.dto.request.PatientRegisterDto;
import com.deezproject.electronic.health.record.data.dto.response.PatientRegisterResponse;
import com.deezproject.electronic.health.record.data.exception.DuplicatePatientException;
import com.deezproject.electronic.health.record.data.exception.InvalidEmailException;
import com.deezproject.electronic.health.record.data.models.BloodGroup;
import com.deezproject.electronic.health.record.data.models.Gender;
import com.deezproject.electronic.health.record.data.models.Genotype;
import com.deezproject.electronic.health.record.data.models.Patient;
import com.deezproject.electronic.health.record.data.repository.PatientRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.deezproject.electronic.health.record.data.exception.ExceptionMessages.INVALID_EMAIL;
import static com.deezproject.electronic.health.record.data.exception.ExceptionMessages.PATIENT_ALREADY_EXIST_EMAIL;
import static com.deezproject.electronic.health.record.util.AppUtils.*;

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
        patient.setGender(Gender.valueOf(request.getGender().name()));
        patient.setGenotype(Genotype.valueOf(request.getGenotype()));
        patient.setBloodGroup(BloodGroup.valueOf(request.getBloodGroup()));
        patient.getMedicalHistory().setCreatedDate(LocalDateTime.now());
        var savedPatient = patientRepo.save(patient);
        var mappedPatient = config.modelMapper().map(savedPatient, PatientRegisterResponse.class);
        mappedPatient.setMessage(SUCCESS);
        return mappedPatient;
    }

    @Override
    public Page<Patient> findByName(String name, int pageNumber) {
        String[] splitString =name.split(" ");
        if (pageNumber<1) pageNumber=1;
        Sort sortBy = Sort.by(Sort.Direction.DESC, REGISTRATION_DATE);
        Pageable pageRequest = PageRequest.of(pageNumber-1, PAGE_LIMIT, sortBy);
        Page<Patient> patients = Page.empty();
        for (String str : splitString) {
           patients= patientRepo.findByFirstName(str, pageRequest);
            if (patients.getContent().isEmpty()){
                patients =patientRepo.findByLastName(str, pageRequest);
            }
        }

        return patients.getContent().isEmpty()? Page.empty(): patients;
    }

    private boolean isValidEmail(String email) {
        String regex = "[a-zA-z][\\w-]{1,20}@\\w{2,20}\\.\\w{2,3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }



}
