package com.mthsgimenez.participe.repository;

import com.mthsgimenez.participe.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
