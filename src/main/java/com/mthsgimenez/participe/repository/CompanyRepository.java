package com.mthsgimenez.participe.repository;

import com.mthsgimenez.participe.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
