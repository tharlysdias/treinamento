package com.proway.treinamento.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The Person entity.\n@author Tharlys Dias.
 */
@ApiModel(description = "The Person entity.\n@author Tharlys Dias.")
@Entity
@Table(name = "person")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID id;

    /**
     * The firstname attribute.
     */
    @NotNull
    @Size(min = 3)
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    @ApiModelProperty(value = "The firstname attribute.", required = true)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * The lastname attribute.
     */
    @ApiModelProperty(value = "The lastname attribute.")
    @Column(name = "last_name")
    private String lastName;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(
        name = "rel_person__event",
        joinColumns = @JoinColumn(name = "person_id"),
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    @JsonIgnoreProperties(value = { "people" }, allowSetters = true)
    private Set<Event> events = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(
        name = "rel_person__coffee",
        joinColumns = @JoinColumn(name = "person_id"),
        inverseJoinColumns = @JoinColumn(name = "coffee_id")
    )
    @JsonIgnoreProperties(value = { "people" }, allowSetters = true)
    private Set<Coffee> coffees = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Person id(UUID id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Person firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Person lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Event> getEvents() {
        return this.events;
    }

    public Person events(Set<Event> events) {
        this.setEvents(events);
        return this;
    }

    public Person addEvent(Event event) {
        this.events.add(event);
        event.getPeople().add(this);
        return this;
    }

    public Person removeEvent(Event event) {
        this.events.remove(event);
        event.getPeople().remove(this);
        return this;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<Coffee> getCoffees() {
        return this.coffees;
    }

    public Person coffees(Set<Coffee> coffees) {
        this.setCoffees(coffees);
        return this;
    }

    public Person addCoffee(Coffee coffee) {
        this.coffees.add(coffee);
        coffee.getPeople().add(this);
        return this;
    }

    public Person removeCoffee(Coffee coffee) {
        this.coffees.remove(coffee);
        coffee.getPeople().remove(this);
        return this;
    }

    public void setCoffees(Set<Coffee> coffees) {
        this.coffees = coffees;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        return id != null && id.equals(((Person) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Person{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            "}";
    }
}
