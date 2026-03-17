package com.pm.patient_service.mapper;

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
	
}
