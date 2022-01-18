package com.idi.idipsr.services;

import com.idi.idipsr.dao.PatientRepo;
import com.idi.idipsr.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Evgeny Borisov
 */
@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Transactional
    public void printSize(int id) {
        Patient patient = patientRepo.findById(id).get();

        System.out.println("***************** "+patient.getPsrTests().size());
    }



}
