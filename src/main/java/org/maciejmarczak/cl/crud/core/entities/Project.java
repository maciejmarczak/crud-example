package org.maciejmarczak.cl.crud.core.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"employees"})
public class Project {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    private String name;
    private Date deadline;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees;

}
