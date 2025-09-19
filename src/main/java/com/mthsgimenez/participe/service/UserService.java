package com.mthsgimenez.participe.service;

import com.mthsgimenez.participe.domain.company.Company;
import com.mthsgimenez.participe.domain.user.User;
import com.mthsgimenez.participe.domain.user.UserDTO;
import com.mthsgimenez.participe.exception.EntityNotFoundException;
import com.mthsgimenez.participe.repository.CompanyRepository;
import com.mthsgimenez.participe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private CompanyRepository companyRepository;

    public User getUserById(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new EntityNotFoundException(User.class, id));
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User createUser(UserDTO data) {
        Company company = companyRepository.findById(data.companyId())
                .orElseThrow(() -> new EntityNotFoundException(Company.class, data.companyId()));

        User user = new User();
        user.setName(data.name());
        user.setEmail(data.email());
        user.setCompany(company);

        return repository.save(user);
    }

    public void deleteUser(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(User.class, id);
        }

        repository.deleteById(id);
    }

    public User updateUser(Long id, UserDTO data) {
        User existingUser = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(User.class, id));
        Company company = companyRepository.findById(data.companyId()).orElseThrow(() -> new EntityNotFoundException(Company.class, id));

        existingUser.setCompany(company);
        existingUser.setName(data.name());
        existingUser.setEmail(data.email());

        return existingUser;
    }
}
