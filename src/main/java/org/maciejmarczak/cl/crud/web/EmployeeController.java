package org.maciejmarczak.cl.crud.web;

import org.maciejmarczak.cl.crud.core.entities.Employee;
import org.maciejmarczak.cl.crud.core.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/delete", params = "id")
    public String deleteEmployee(@RequestParam(value = "id") long id,
                               Model model) {

        employeeService.delEmployee(employeeService.getEmployeeById(id));
        return "redirect:/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute Employee employee,
                              BindingResult result) {

        if (!result.hasErrors()) {
            employeeService.addEmployee(employee);
        }

        return "redirect:/";
    }
}
