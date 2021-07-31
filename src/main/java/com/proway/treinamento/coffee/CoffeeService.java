package com.proway.treinamento.coffee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository repository;

    public List<Coffee> listAll() {
        return repository.findAll();
    }
}
