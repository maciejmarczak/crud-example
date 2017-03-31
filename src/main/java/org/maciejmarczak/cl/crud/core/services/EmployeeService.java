package org.maciejmarczak.cl.crud.core.services;

import org.maciejmarczak.cl.crud.core.dao.DaoProvider;
import org.maciejmarczak.cl.crud.core.entities.Company;
import org.maciejmarczak.cl.crud.core.entities.Employee;
import org.maciejmarczak.cl.crud.core.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final DaoProvider daoProvider;

    @Autowired
    public EmployeeService(DaoProvider daoProvider) {
        this.daoProvider = daoProvider;
    }

    public List<Employee> getAllEmployees() {
        return daoProvider.findAll(Employee.class);
    }

    public List<Employee> getEmployeesByCompany(Company company) {
        return daoProvider.findAll(Employee.class).stream()
                .filter(employee -> employee.getCompany().equals(company))
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesByProject(Project project) {
        return daoProvider.findAll(Employee.class).stream()
                .filter(employee -> employee.getProjects().contains(project))
                .collect(Collectors.toList());
    }

    public void addEmployee(Employee employee) {
        daoProvider.save(employee);
    }

    public void delEmployee(Employee employee) {
        daoProvider.delete(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return daoProvider.update(employee);
    }

}
