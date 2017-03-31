package org.maciejmarczak.cl.crud.web;

import org.maciejmarczak.cl.crud.core.dao.DaoProvider;
import org.maciejmarczak.cl.crud.core.entities.Company;
import org.maciejmarczak.cl.crud.core.entities.Employee;
import org.maciejmarczak.cl.crud.core.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    DaoProvider daoProvider;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage() {

        Company company = new Company();
        Employee employee = new Employee();
        Project project = new Project();

        company.setAddress("al. Jana Pawla II 35");
        company.setName("Comarch");
        company.setEmployees(new HashSet<Employee>());
        company.getEmployees().add(employee);

        employee.setCompany(company);
        employee.setFirstName("Adam");
        employee.setLastName("Nowak");
        employee.setProjects(new HashSet<Project>());
        employee.getProjects().add(project);

        project.setName("ERP");
        project.setDeadline(new Date());
        project.setEmployees(new HashSet<Employee>());
        project.getEmployees().add(employee);

        daoProvider.save(employee);

        List<Company> companies = daoProvider.findAll(Company.class);

        System.out.println(companies.size());

        return "index";
    }
}
