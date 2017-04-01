package org.maciejmarczak.cl.crud.web;

import org.maciejmarczak.cl.crud.core.entities.Company;
import org.maciejmarczak.cl.crud.core.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

@Service
public class CompanyFormatter implements Formatter<Company> {

    private final CompanyService companyService;

    @Autowired
    public CompanyFormatter(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public Company parse(String name, Locale locale) throws ParseException {
        return companyService.getCompanyByName(name);
    }

    @Override
    public String print(Company company, Locale locale) {
        return company.getName();
    }
}
