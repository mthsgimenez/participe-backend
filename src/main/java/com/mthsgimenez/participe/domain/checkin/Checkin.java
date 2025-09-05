package com.mthsgimenez.participe.domain.checkin;

import com.mthsgimenez.participe.domain.event.Event;
import com.mthsgimenez.participe.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "checkin")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Checkin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
