package com.deezproject.electronic.health.record.service;

import com.deezproject.electronic.health.record.data.dto.request.MedicalHistoryDto;
import com.deezproject.electronic.health.record.data.dto.request.MedicalHistoryRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MedicalHistoryImplTest {

    @Autowired
    MedicalHistory medicalHistory;

    private MedicalHistoryRequest medicalHistoryDto;
    @BeforeEach
    void setUp() {
        List<String> medications = new ArrayList<>();
        medications.add("Para");
        medications.add("Gestide");

        List<String> allergies = new ArrayList<>();
        allergies.add("Berries");

        List<String> ailment = new ArrayList<>();
        ailment.add("Cough");
        medicalHistoryDto= MedicalHistoryRequest.builder()
                .medications(medications)
                .allergies(allergies)
                .ailments(ailment)
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createMedicalHistoryTest(){
        var response = medicalHistory.createMedicalHistory(medicalHistoryDto);
        assertAll(
                ()-> assertThat(response.getMessage()).isNotNull(),
                    ()-> assertThat(response.getMessage()).isEqualTo("Patient medical history registered successfully")
        );
    }
}