package com.idi.idipsr.dao;

import com.idi.idipsr.IdiPsrApplication;
import com.idi.idipsr.model.Patient;
import com.idi.idipsr.model.PsrTest;
import com.idi.idipsr.services.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Evgeny Borisov
 */
//@SpringBootTest
//@WebMvcTest
@DataJpaTest

@Import(PatientTestConf.class)
//@SpringBootTest(classes = IdiPsrApplication.class)
class PatientRepoTest {



    @Autowired
    private ApplicationContext context;

    @Autowired
    private PatientService patientService;

    @Autowired
    PatientRepo patientRepo;

    @BeforeEach
    public void initDb(){
        PsrTest psrTest1 = new PsrTest(true,new Date());
        PsrTest psrTest2 = new PsrTest(false,new Date());
        Patient jeka = Patient.builder().name("Jeka").psrTest(psrTest1).psrTest(psrTest2).build();
        patientRepo.save(jeka);
        Patient yoni = Patient.builder().name("Yoni").psrTest(new PsrTest(true,new Date())).build();
        patientRepo.save(yoni);

    }

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    void findByPsrTestsAnswerEquals() {

        patientService.printSize(1);


        List<Patient> byPsrTestsAnswerEquals = patientRepo.findByPsrTestsAnswerEquals(true);
        System.out.println();
        int sizeOfPositive = byPsrTestsAnswerEquals.size();
        int sizeOfNegative = patientRepo.findByPsrTestsAnswerEquals(false).size();
        Assertions.assertEquals(2,sizeOfPositive);
        Assertions.assertEquals(1,sizeOfNegative);


        System.out.println();
    }
}