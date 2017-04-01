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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    private String firstName;
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "COMPANY")
    private Company company;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "EMPLOYEES_PROJECTS",
            joinColumns = @JoinColumn(name = "E_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "P_ID", referencedColumnName = "ID")
    )
    private Set<Project> projects;

}
