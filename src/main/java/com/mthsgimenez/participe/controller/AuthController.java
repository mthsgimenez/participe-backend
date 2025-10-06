package com.mthsgimenez.participe.controller;

import com.mthsgimenez.participe.domain.company.Company;
import com.mthsgimenez.participe.domain.user.LoginDTO;
import com.mthsgimenez.participe.domain.user.RegisterDTO;
import com.mthsgimenez.participe.domain.user.User;
import com.mthsgimenez.participe.domain.user.UserRole;
import com.mthsgimenez.participe.repository.CompanyRepository;
import com.mthsgimenez.participe.repository.UserRepository;
import com.mthsgimenez.participe.security.JWTService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JWTService jwtService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = jwtService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO data) {
        if (this.userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        Optional<Company> company = this.companyRepository.findById(data.companyId());
        if (company.isEmpty()) return ResponseEntity.badRequest().build();

        String hashedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.email(), data.name(), hashedPassword, company.get(), UserRole.USER);

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
