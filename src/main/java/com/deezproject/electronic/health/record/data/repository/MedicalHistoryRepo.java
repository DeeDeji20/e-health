package com.deezproject.electronic.health.record.data.repository;

import com.deezproject.electronic.health.record.data.models.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalHistoryRepo extends JpaRepository<MedicalHistory, Long> {
}
