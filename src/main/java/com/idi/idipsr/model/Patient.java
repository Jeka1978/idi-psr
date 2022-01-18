package com.idi.idipsr.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Entity
@Data // better to exclude id from hashcode, so don't use @Data in entity (@Setter, @Getter, ToString, @EqualsAndHashcode)
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(exclude = "id")
public class Patient {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @Singular
    private List<PsrTest> psrTests;










}


