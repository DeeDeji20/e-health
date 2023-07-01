package com.deezproject.electronic.health.record.data.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "medicalHistory")
    private Patient patientId;
//    @OneToMany
//    @ElementCollection(fetch = FetchType.EAGER)
//    @JoinColumn(name = "patient_id")
    private String ailments;
//    @ElementCollection(fetch = FetchType.EAGER)
//    @OneToMany
    private String allergies;
//    @ElementCollection(fetch = FetchType.EAGER)
    private String medications;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

}
