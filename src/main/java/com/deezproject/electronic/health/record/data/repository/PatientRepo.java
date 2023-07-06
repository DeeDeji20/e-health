package com.deezproject.electronic.health.record.data.repository;

import com.deezproject.electronic.health.record.data.models.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    boolean existsByEmail(String email);

    Page<Patient> findByFirstName(String name, Pageable pageable);

    Page<Patient> findByLastName(String name, Pageable pageRequest);
    findBy

//    Page<Patient> findByFirstNameAndLastName(String name, Pageable pageRequest);
}
