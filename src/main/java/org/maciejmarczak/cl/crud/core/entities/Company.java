package org.maciejmarczak.cl.crud.core.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"employees"})
@ToString(exclude = {"employees"})
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private Set<Employee> employees;

}
