package com.deezproject.electronic.health.record.data.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
