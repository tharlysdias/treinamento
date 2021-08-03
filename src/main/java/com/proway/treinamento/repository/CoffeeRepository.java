package com.proway.treinamento.repository;

import com.proway.treinamento.domain.Coffee;
import java.util.UUID;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Coffee entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, UUID> {}
