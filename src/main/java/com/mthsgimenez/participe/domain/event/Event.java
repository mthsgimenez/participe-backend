package com.mthsgimenez.participe.domain.event;

import com.mthsgimenez.participe.domain.checkin.Checkin;
import com.mthsgimenez.participe.domain.feedback.Feedback;
import com.mthsgimenez.participe.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private OffsetDateTime date;
    private String image_url;
    private String event_page_qrcode;
    private String checkin_qrcode;

    @ManyToMany
    @JoinTable(
            name = "events_users",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;

    @OneToMany(mappedBy = "event")
    private Set<Feedback> feedbacks;

    @OneToMany(mappedBy = "event")
    private Set<Checkin> checkins;
}
