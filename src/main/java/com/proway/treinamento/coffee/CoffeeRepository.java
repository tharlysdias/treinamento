package com.proway.treinamento.coffee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
