package com.pm.patient_service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.patient_service.dto.PatientRequestDTO;
import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.dto.validators.CreatePatientValidationGroup;
import com.pm.patient_service.repository.PatientRepository;
import com.pm.patient_service.service.PatientService;

import jakarta.validation.Valid;
import jakarta.validation.groups.Default;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientRepository patientRepository;

	private final PatientService patientService;

	public PatientController(PatientService patientService, PatientRepository patientRepository) {
		super();
		this.patientService = patientService;
		this.patientRepository = patientRepository;
	}

	@GetMapping
	public ResponseEntity<List<PatientResponseDTO>> getPatients() {

		List<PatientResponseDTO> patients = patientService.getPatients();

		return ResponseEntity.ok().body(patients);

	}

	@PostMapping
	public ResponseEntity<PatientResponseDTO> createPatient(@Validated({Default.class, CreatePatientValidationGroup.class}) @RequestBody PatientRequestDTO patientRequestDTO) {
		PatientResponseDTO patientResponseDTO = patientService.createPatient(patientRequestDTO);

		return ResponseEntity.ok().body(patientResponseDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id,
			@Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO) {
		
		// @ Validated tag to @RequestBody to trigger the validation checks so that JPA will validate if the email is not blank

		
		PatientResponseDTO patientResponseDTO = patientService.updatePatient(id, patientRequestDTO);
		
		
		return ResponseEntity.ok().body(patientResponseDTO);

	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePatient(@PathVariable UUID id){
		
		
		patientService.deletePatient(id);
		
	
		return ResponseEntity.noContent().build();
	}

}








