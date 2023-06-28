package com.deezproject.electronic.health.record.service;

import com.deezproject.electronic.health.record.data.dto.request.PatientRegisterDto;
import com.deezproject.electronic.health.record.data.models.BloodGroup;
import com.deezproject.electronic.health.record.data.models.Gender;
import com.deezproject.electronic.health.record.data.models.Genotype;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AllArgsConstructor
class PatientServiceImplTest {

    private final PatientService patientService;
    private PatientRegisterDto patientRegisterDto;

    @BeforeEach
    void setUp() {
        patientRegisterDto = PatientRegisterDto.builder()
                .firstName("John")
                .lastName("Doe")
                .address("Phase 2, Site 1")
                .email("john.doe@gmail")
                .gender(Gender.MALE)
                .occupation("Civil Engineer")
                .phoneNumber("07023456788")
                .dob(LocalDate.of(2000, 9, 15))
                .registrationDate(String.valueOf(LocalDateTime.now()))
                .genotype("AA")
                .bloodGroup("O+")
                .guardianName("Jane Doe")
                .guardianPhoneNumber("0903456724")
                .build();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void registerPatientTest(){
        //Given that
        //when
        patientService.registerPatient(patientRegisterDto);
        //action
    }
}