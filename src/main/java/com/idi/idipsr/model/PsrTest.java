package com.idi.idipsr.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Evgeny Borisov
 */
@Entity
@Data
@NoArgsConstructor
public class PsrTest {
    @Id
    @GeneratedValue
    private Long id;

    private Boolean answer;

    private Date date;


    public PsrTest(Date date) {
        this.date = date;
    }

    public PsrTest(Boolean answer, Date date) {
        this.answer = answer;
        this.date = date;
    }
}
