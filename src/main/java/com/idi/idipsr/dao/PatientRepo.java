package com.idi.idipsr.dao;

import com.idi.idipsr.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author Evgeny Borisov
 */

public interface PatientRepo extends JpaRepository<Patient,Integer> {

    @RestResource(path = "byAnswer")
    List<Patient> findByPsrTestsAnswerEquals(@Param("answer")Boolean answer);
}
