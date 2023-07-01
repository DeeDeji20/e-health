package com.deezproject.electronic.health.record.data.repository;

import com.deezproject.electronic.health.record.data.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    boolean existsByEmail(String email);
}
