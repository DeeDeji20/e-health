package com.deezproject.electronic.health.record.controller;

import com.deezproject.electronic.health.record.data.dto.request.PatientRegisterDto;
import com.deezproject.electronic.health.record.data.dto.response.ApiResponse;
import com.deezproject.electronic.health.record.data.exception.DuplicatePatientException;
import com.deezproject.electronic.health.record.data.exception.InvalidEmailException;
import com.deezproject.electronic.health.record.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {

    private PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<?> registerPatient(@RequestBody PatientRegisterDto request){
        try{
            var response =  patientService.registerPatient(request);
            return ResponseEntity.ok(response);
        }catch (InvalidEmailException | DuplicatePatientException exception){
            ApiResponse<?> response = ApiResponse.builder()
                    .message(exception.getMessage())
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build();
            return ResponseEntity.badRequest().body(request);
        }
    }
}
