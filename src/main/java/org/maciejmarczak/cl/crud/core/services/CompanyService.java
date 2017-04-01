package org.maciejmarczak.cl.crud.core.services;

import org.maciejmarczak.cl.crud.core.dao.DaoProvider;
import org.maciejmarczak.cl.crud.core.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final DaoProvider daoProvider;

    @Autowired
    public CompanyService(DaoProvider daoProvider) {
        this.daoProvider = daoProvider;
    }

    public List<Company> getAllCompanies() {
        return daoProvider.findAll(Company.class);
    }

    public Company getCompanyById(long id) {
        return daoProvider.findById(Company.class, id);
    }

    public Company getCompanyByName(String name) {
        return daoProvider.findAll(Company.class).stream()
                .filter(c -> c.getName().equals(name))
                .findFirst().get();
    }

    public void addCompany(Company company) {
        daoProvider.save(company);
    }

}
