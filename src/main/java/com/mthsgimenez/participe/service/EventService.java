package com.mthsgimenez.participe.service;

import com.mthsgimenez.participe.domain.event.Event;
import com.mthsgimenez.participe.domain.event.EventRequestDTO;
import com.mthsgimenez.participe.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    private String SaveImage(MultipartFile image) throws Exception {
        String filename = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();

        String savePath = "static/images/";
        String imagePath = Paths.get(System.getProperty("user.dir"), savePath + filename).toString();

        File destFile = new File(imagePath);
        destFile.getParentFile().mkdirs();
        image.transferTo(destFile);

        return imagePath;
    }

    public Event createEvent(EventRequestDTO data) {
        Event event = new Event();

        System.out.println(data);

        if (data.image() != null && !data.image().isEmpty()) {
            try {
                event.setImage_url(this.SaveImage(data.image()));
            } catch (Exception e) {
                return null;
            }
        }

        event.setDate(data.date());
        event.setName(data.name());
        event.setDescription(data.description());

        return this.eventRepository.save(event);
    }
}
