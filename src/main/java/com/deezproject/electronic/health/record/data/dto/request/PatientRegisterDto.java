package com.deezproject.electronic.health.record.data.dto.request;

import com.deezproject.electronic.health.record.data.models.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PatientRegisterDto {
    private Long id;
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
}
