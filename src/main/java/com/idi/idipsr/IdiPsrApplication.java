package com.idi.idipsr;

import com.idi.idipsr.services.PatientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IdiPsrApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(IdiPsrApplication.class, args);
        context.getBean(PatientService.class).printSize(1);
    }

}
