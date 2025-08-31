package com.example.Patient_Management_System.Service;


import com.example.Patient_Management_System.DTO.PatientRequestDTO;
import com.example.Patient_Management_System.DTO.PatientResponseDTO;
import com.example.Patient_Management_System.Mapper.PatientMapper;
import com.example.Patient_Management_System.Model.Patient;
import com.example.Patient_Management_System.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOS = patients.stream().map(patient -> PatientMapper.toDTO(patient)).toList();
        return patientResponseDTOS;
    }
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }

}
