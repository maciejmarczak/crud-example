package org.maciejmarczak.cl.crud.core.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"company", "projects"})
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    private String firstName;
    private String lastName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COMPANY_EMPLOYEES")
    private Company company;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "EMPLOYEES_PROJECTS",
            joinColumns = @JoinColumn(name = "E_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "P_ID", referencedColumnName = "ID")
    )
    private Set<Project> projects;

}
