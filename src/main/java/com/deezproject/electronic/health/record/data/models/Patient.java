package com.deezproject.electronic.health.record.data.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String email;
    private String phoneNumber;
    private String address;
    private String occupation;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
    @Enumerated(EnumType.STRING)
    private Genotype genotype;
    private String registrationDate;
    private String modifiedDate;
    private String guardianName;
    private String guardianPhoneNumber;
    @OneToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "medical_history_id")
    private MedicalHistory medicalHistory;
}
