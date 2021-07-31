package com.proway.treinamento.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository repository;

    public List<Event> listAll() {
        return repository.findAll();
    }
}
