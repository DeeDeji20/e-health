package com.deezproject.electronic.health.record.service;

import com.deezproject.electronic.health.record.data.dto.request.MedicalHistoryDto;
import com.deezproject.electronic.health.record.data.dto.request.PatientRegisterDto;
import com.deezproject.electronic.health.record.data.dto.response.ApiResponse;
import com.deezproject.electronic.health.record.data.exception.DuplicatePatientException;
import com.deezproject.electronic.health.record.data.exception.InvalidEmailException;
import com.deezproject.electronic.health.record.data.models.BloodGroup;
import com.deezproject.electronic.health.record.data.models.Gender;
import com.deezproject.electronic.health.record.data.models.Genotype;
import com.deezproject.electronic.health.record.data.models.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@AllArgsConstructor
class PatientServiceImplTest {

    @Autowired
    private PatientService patientService;
    private PatientRegisterDto patientRegisterDto;
    private MedicalHistoryDto medicalHistoryDto;
    @BeforeEach
    void setUp() {
        List<String> medications = new ArrayList<>();
        medications.add("Para");
        medications.add("Gestide");

        List<String> allergies = new ArrayList<>();
        allergies.add("Berries");

        List<String> ailment = new ArrayList<>();
        ailment.add("Cough");
        medicalHistoryDto= MedicalHistoryDto.builder()
                .medications("Gestide")
                .allergies("Berries")
                .ailments("Cough")
                .build();
        patientRegisterDto = PatientRegisterDto.builder()
                .firstName("zane")
                .lastName("Doe")
                .address("Phase 2, Site 1")
                .email("zaneDoe@gmail.com")
                .gender(Gender.MALE)
                .occupation("Civil Engineer")
                .phoneNumber("07023456788")
                .dob(LocalDate.of(2000, 9, 15))
                .registrationDate(String.valueOf(LocalDateTime.now()))
                .genotype("AA")
                .bloodGroup("O_POSITIVE")
                .guardianName("Jane Doe")
                .guardianPhoneNumber("0903456724")
                .medicalHistory(medicalHistoryDto)
                .build();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void registerPatientTest(){
        //Given that
        //when
        var response = patientService.registerPatient(patientRegisterDto);
        //action
        assertAll(
                ()-> assertThat(response).isNotNull(),
                ()-> assertThat(response.getMessage()).isEqualTo("Patient registered successfully")
        );
    }

    @Test
    void patientAlreadyExistsTest(){
        patientRegisterDto = PatientRegisterDto.builder()
                .firstName("zane")
                .lastName("Doe")
                .address("Phase 2, Site 1")
                .email("zane.doe@gmail")
                .gender(Gender.MALE)
                .occupation("Civil Engineer")
                .phoneNumber("07023456788")
                .dob(LocalDate.of(2000, 9, 15))
                .registrationDate(String.valueOf(LocalDateTime.now()))
                .genotype("AA")
                .bloodGroup("O+")
                .guardianName("Jane Doe")
                .guardianPhoneNumber("0903456724")
                .medicalHistory(medicalHistoryDto)
                .build();

        assertThrows(DuplicatePatientException.class,()-> patientService.registerPatient(patientRegisterDto));
    }

    @Test
    void emailIsInvalidTest(){
        patientRegisterDto = PatientRegisterDto.builder()
                .firstName("zane")
                .lastName("Doe")
                .address("Phase 2, Site 1")
                .email("zane.doe.gmail")
                .gender(Gender.MALE)
                .occupation("Civil Engineer")
                .phoneNumber("07023456788")
                .dob(LocalDate.of(2000, 9, 15))
                .registrationDate(String.valueOf(LocalDateTime.now()))
                .genotype("AA")
                .bloodGroup("O+")
                .guardianName("Jane Doe")
                .guardianPhoneNumber("0903456724")
                .medicalHistory(medicalHistoryDto)
                .build();
        assertThrows(InvalidEmailException.class,()-> patientService.registerPatient(patientRegisterDto));

    }

    @Test
    void findPatientByFirstNameTest(){
        Page<Patient> patients = patientService.findByName("zane", 1);
       assertAll(
               ()-> assertThat(patients.getTotalElements()).isEqualTo(1),
               ()-> assertThat(patients.stream().findFirst().get().getFirstName()).isEqualTo("zane")
       );

    }

    @Test
    void findPatientByLastNameTest(){
        Page<Patient> patients = patientService.findByName("Doe", 1);
        assertAll(
                ()-> assertThat(patients.getTotalElements()).isEqualTo(1),
                ()-> assertThat(patients.stream().findFirst().get().getLastName()).isEqualTo("Doe")
        );

    }

    @Test
    void findPatientByFirstNameAndLastNameTest(){
        Page<Patient> patients = patientService.findByName("zane Doe", 1);
        assertAll(
                ()-> assertThat(patients.getTotalElements()).isEqualTo(1),
                ()-> assertThat(patients.stream().findFirst().get().getLastName()).isEqualTo("Doe")
        );

    }

//    @Test
//    void getPatientDetailsTest(){
//        Patient patient = patientService.findPatientById(702L);
//
//        asse
//    }
}