package com.mthsgimenez.participe.domain.user;

import com.mthsgimenez.participe.domain.checkin.Checkin;
import com.mthsgimenez.participe.domain.company.Company;
import com.mthsgimenez.participe.domain.event.Event;
import com.mthsgimenez.participe.domain.feedback.Feedback;
import com.mthsgimenez.participe.domain.permission.Permission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany
    @JoinTable(
            name = "permissions_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions;

    @ManyToMany(mappedBy = "users")
    private Set<Event> events;

    @OneToMany(mappedBy = "user")
    private Set<Feedback> feedbacks;

    @OneToMany(mappedBy = "user")
    private Set<Checkin> checkins;
}
