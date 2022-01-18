package com.idi.idipsr.dao;

import com.idi.idipsr.model.Patient;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@RestResource
@RepositoryDefinition(domainClass = Patient.class,idClass = Integer.class)
public interface PublicPatientRepo {

    @RestResource(path = "bbb")
    List<Patient> findByPsrTestsAnswerEquals(@Param("answer")Boolean answer);

}
