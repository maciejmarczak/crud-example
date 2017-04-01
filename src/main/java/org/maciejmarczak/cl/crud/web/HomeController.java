package org.maciejmarczak.cl.crud.web;

import org.maciejmarczak.cl.crud.core.entities.Company;
import org.maciejmarczak.cl.crud.core.entities.Employee;
import org.maciejmarczak.cl.crud.core.services.CompanyService;
import org.maciejmarczak.cl.crud.core.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;

    @Autowired
    public HomeController(EmployeeService employeeService,
                          CompanyService companyService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("companies", companyService.getAllCompanies());
        model.addAttribute("employee", new Employee());
        model.addAttribute("company", new Company());
        return "index";
    }
}
