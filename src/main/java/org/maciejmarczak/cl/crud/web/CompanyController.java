package org.maciejmarczak.cl.crud.web;

import org.maciejmarczak.cl.crud.core.entities.Company;
import org.maciejmarczak.cl.crud.core.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCompany(@ModelAttribute Company company,
                             BindingResult result) {

        if (!result.hasErrors()) {
            companyService.addCompany(company);
        }

        return "redirect:/";
    }

}
