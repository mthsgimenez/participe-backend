package com.mthsgimenez.participe.service;

import com.mthsgimenez.participe.domain.company.Company;
import com.mthsgimenez.participe.domain.company.CompanyDTO;
import com.mthsgimenez.participe.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public Company createCompany(CompanyDTO data) {
        Company company = new Company();
        company.setName(data.name());

        return repository.save(company);
    }
}
