package com.deezproject.electronic.health.record.data.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class MedicateHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @Cascade(CascadeType.ALL)
    private Patient patientId; //Might be the Patient
    private List<String> ailments;
    private List<String> allergies;
    private List<String> medications;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
