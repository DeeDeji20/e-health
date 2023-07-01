package com.deezproject.electronic.health.record.data.repository;

import com.deezproject.electronic.health.record.data.models.Patient;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@AllArgsConstructor
class PatientRepoTest {

    @Autowired
    private PatientRepo patientRepo;

    @BeforeEach
    void setUp(){
        patientRepo.deleteAll();
    }

    @Test
    public void findPatientByEmailTest(){
        var patient = Patient.builder()
                .email("dee@gmail.com")
                .firstName("Dee")
                .build();

        var savedPatient =patientRepo.save(patient);

        assertThat(savedPatient.getEmail()).isEqualTo("dee@gmail.com");

        assertTrue(patientRepo.existsByEmail("dee@gmail.com"));
    }
}