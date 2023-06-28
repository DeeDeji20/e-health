package com.deezproject.electronic.health.record.data.dto.request;

import com.deezproject.electronic.health.record.data.models.BloodGroup;
import com.deezproject.electronic.health.record.data.models.Gender;
import com.deezproject.electronic.health.record.data.models.Genotype;
import com.deezproject.electronic.health.record.data.models.MedicateHistory;

import java.time.LocalDateTime;

public class PatientRegisterDto {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String phoneNumber;
    private String address;
    private String occupation;
    private LocalDateTime dob;
    private BloodGroup bloodGroup;
    private Genotype genotype;
    private String registrationDate;
    private String modifiedDate;
    private String guardianName;
    private String guardianPhoneNumber;
    private MedicateHistory medicalHistory;
}
