package com.mthsgimenez.participe.repository;

import com.mthsgimenez.participe.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    public UserDetails findByEmail(String email);
}
