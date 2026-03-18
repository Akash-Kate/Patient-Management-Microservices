package com.pm.patient_service.mapper;

import java.time.LocalDate;

import com.pm.patient_service.dto.PatientRequestDTO;
import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.model.Patient;

public class PatientMapper {

	public static PatientResponseDTO toDto(Patient patient) {

		PatientResponseDTO patienDto = new PatientResponseDTO();

		patienDto.setId(patient.getId().toString());
		patienDto.setName(patient.getName());
		patienDto.setAddress(patient.getAddress());
		patienDto.setEmail(patient.getEmail());
		patienDto.setDateOfBirth(patient.getDateofBirth().toString());

		return patienDto;

	}

	public static Patient toModel(PatientRequestDTO patientRequestDTO) {

		Patient patient = new Patient();
		patient.setName(patientRequestDTO.getName());
		patient.setAddress(patientRequestDTO.getAddress());
		patient.setEmail(patientRequestDTO.getEmail());
		patient.setDateofBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
		patient.setRegisterDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
		
		return patient;

	}

}
