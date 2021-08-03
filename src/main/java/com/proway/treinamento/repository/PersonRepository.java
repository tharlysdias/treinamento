package com.proway.treinamento.repository;

import com.proway.treinamento.domain.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Person entity.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
    @Query(
        value = "select distinct person from Person person left join fetch person.events left join fetch person.coffees",
        countQuery = "select count(distinct person) from Person person"
    )
    Page<Person> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct person from Person person left join fetch person.events left join fetch person.coffees")
    List<Person> findAllWithEagerRelationships();

    @Query("select person from Person person left join fetch person.events left join fetch person.coffees where person.id =:id")
    Optional<Person> findOneWithEagerRelationships(@Param("id") UUID id);
}
