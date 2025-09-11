package com.mthsgimenez.participe.controller;

import com.mthsgimenez.participe.domain.company.Company;
import com.mthsgimenez.participe.domain.company.CompanyDTO;
import com.mthsgimenez.participe.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @PostMapping
    public ResponseEntity<Company> create(@RequestParam("name") String name) {
        CompanyDTO companyDTO = new CompanyDTO(name);
        return ResponseEntity.ok(service.createCompany(companyDTO));
    }
}
