package com.pm.patient_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pm.patient_service.dto.PatientResponseDTO;
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
		
		List<PatientResponseDTO> patientResponseDTOs = patients.stream().map(patient -> PatientMapper.toDto(patient)).toList();
		
		
		return patientResponseDTOs;
		
	}
	
}
