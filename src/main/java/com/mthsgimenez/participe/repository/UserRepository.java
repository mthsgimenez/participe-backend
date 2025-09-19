package com.mthsgimenez.participe.repository;

import com.mthsgimenez.participe.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
