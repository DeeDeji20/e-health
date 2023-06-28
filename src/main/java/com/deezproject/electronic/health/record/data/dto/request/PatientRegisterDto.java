package com.deezproject.electronic.health.record.data.dto.request;

import com.deezproject.electronic.health.record.data.models.BloodGroup;
import com.deezproject.electronic.health.record.data.models.Gender;
import com.deezproject.electronic.health.record.data.models.Genotype;
import com.deezproject.electronic.health.record.data.models.MedicateHistory;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class PatientRegisterDto {
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
    private MedicateHistory medicalHistory;
}
