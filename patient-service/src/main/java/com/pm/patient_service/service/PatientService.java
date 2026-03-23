package com.pm.patient_service.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.pm.patient_service.dto.PatientRequestDTO;
import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.exception.EmailAlreadyExistsException;
import com.pm.patient_service.exception.PatientNotFoundException;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepository;

@Service
public class PatientService {

	private PatientRepository patientRepo;

	public PatientService(PatientRepository patientRepo) {
		super();
		this.patientRepo = patientRepo;
	}

	public List<PatientResponseDTO> getPatients() {

		List<Patient> patients = patientRepo.findAll();

		List<PatientResponseDTO> patientResponseDTOs = patients.stream().map(patient -> PatientMapper.toDto(patient))
				.toList();

		return patientResponseDTOs;

	}

	public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {

		if (patientRepo.existsByEmail(patientRequestDTO.getEmail())) {
			throw new EmailAlreadyExistsException(
					"A Patient with this email " + "already exists" + patientRequestDTO.getEmail());
		}

		Patient newPatient = patientRepo.save(PatientMapper.toModel(patientRequestDTO));

		return PatientMapper.toDto(newPatient);

	}

	public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO) {

		Patient patient = patientRepo.findById(id)
				.orElseThrow(() -> new PatientNotFoundException("Patient Not found with ID : " + id));
		
		if (patientRepo.existsByEmailAndIdNot(patientRequestDTO.getEmail(), id)) {
			// Here this code (existsByEmailAndIdNot) is checking if there there is a patient
			// with the same email as I am trying to update but a different id
			// If patient exists then throw the error
			throw new EmailAlreadyExistsException(
					"A Patient with this email " + "already exists" + patientRequestDTO.getEmail());
		}
		
		
		patient.setName(patientRequestDTO.getName());
		patient.setAddress(patientRequestDTO.getAddress());
		patient.setEmail(patientRequestDTO.getEmail());
		patient.setDateofBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
		
		
		Patient updatedPatient = patientRepo.save(patient);
		
		return PatientMapper.toDto(updatedPatient);
		

	}

	

}

























