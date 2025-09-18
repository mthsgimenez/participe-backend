package com.mthsgimenez.participe.controller;

import com.mthsgimenez.participe.domain.company.Company;
import com.mthsgimenez.participe.domain.company.CompanyDTO;
import com.mthsgimenez.participe.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("companyId") Long id) {
        return ResponseEntity.ok(service.getCompanyById(id));
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() {
        return ResponseEntity.ok(service.getCompanies());
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@Valid @RequestBody CompanyDTO companyDTO) {
        return ResponseEntity.ok(service.createCompany(companyDTO));
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("companyId") Long id) {
        service.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<Company> updateCompany(@PathVariable("companyId") Long id, @Valid @RequestBody CompanyDTO companyDTO) {
        return ResponseEntity.ok(service.updateCompany(id, companyDTO));
    }
}
