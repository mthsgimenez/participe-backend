package com.mthsgimenez.participe.service;

import com.mthsgimenez.participe.domain.company.Company;
import com.mthsgimenez.participe.domain.company.CompanyDTO;
import com.mthsgimenez.participe.exception.EntityNotFoundException;
import com.mthsgimenez.participe.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public Company createCompany(CompanyDTO data) {
        Company company = new Company();
        company.setName(data.name());

        return repository.save(company);
    }

    public Company getCompanyById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(Company.class, id));
    }

    public List<Company> getCompanies() {
        return repository.findAll();
    }

    public void deleteCompany(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(Company.class, id);
        }

        repository.deleteById(id);
    }

    public Company updateCompany(Long id, CompanyDTO data) {
        Company company = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(Company.class, id));
        company.setName(data.name());

        repository.save(company);
        return company;
    }
}
