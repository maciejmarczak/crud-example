package org.maciejmarczak.cl.crud.core.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"employees"})
public class Company {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "company")
    private Set<Employee> employees;

}
