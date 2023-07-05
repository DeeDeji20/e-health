package com.deezproject.electronic.health.record.data.repository;

import com.deezproject.electronic.health.record.data.models.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    boolean existsByEmail(String email);

    Page<Patient> findByFirstName(String name, Pageable pageable);

}
