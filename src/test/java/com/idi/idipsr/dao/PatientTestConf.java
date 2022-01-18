package com.idi.idipsr.dao;

import com.idi.idipsr.services.PatientService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Evgeny Borisov
 */
@TestConfiguration
public class PatientTestConf {
    @Bean
    public PatientService patientService(){
        return new PatientService();
    }

    @Bean
    public String string12(){
        return "12";
    }
}
