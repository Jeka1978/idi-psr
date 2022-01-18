package com.idi.idipsr.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idi.idipsr.dao.PatientRepo;
import com.idi.idipsr.model.Patient;
import com.idi.idipsr.model.PsrTest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Evgeny Borisov
 */
@Service
public class DatafilllerService {
    @Autowired
    private PatientRepo patientRepo;

    @EventListener(ContextRefreshedEvent.class)
    public void fillData() {
        PsrTest psrTest1 = new PsrTest(true,new Date());
        PsrTest psrTest2 = new PsrTest(false,new Date());
        Patient jeka = Patient.builder().name("Jeka").psrTest(psrTest1).psrTest(psrTest2).build();
        patientRepo.save(jeka);
        Patient yoni = Patient.builder().name("Yoni").psrTest(new PsrTest(true,new Date())).build();
        patientRepo.save(yoni);
    }

    @SneakyThrows
    public static void main(String[] args) {
        PsrTest psrTest1 = new PsrTest(true,new Date());
        PsrTest psrTest2 = new PsrTest(false,new Date());
        Patient jeka = Patient.builder().name("Jeka").psrTest(psrTest1).psrTest(psrTest2).build();

        String json = new ObjectMapper().writeValueAsString(jeka);
        System.out.println(json);
    }
}
