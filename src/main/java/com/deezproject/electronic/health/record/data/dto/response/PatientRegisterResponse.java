package com.deezproject.electronic.health.record.data.dto.response;

import com.deezproject.electronic.health.record.data.dto.request.MedicalHistoryDto;
import com.deezproject.electronic.health.record.data.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientRegisterResponse {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String phoneNumber;
    private String address;
    private String occupation;
    private LocalDate dob;
    private String  bloodGroup;
    private String genotype;
    private String registrationDate;
    private String modifiedDate;
    private String guardianName;
    private String guardianPhoneNumber;
    private MedicalHistoryDto medicalHistory;
    private String message;
}
