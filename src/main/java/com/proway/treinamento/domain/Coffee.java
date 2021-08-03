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
 * The Coffee entity.\n@author Tharlys Dias.
 */
@ApiModel(description = "The Coffee entity.\n@author Tharlys Dias.")
@Entity
@Table(name = "coffee")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Coffee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID id;

    /**
     * The firstname attribute.
     */
    @NotNull
    @ApiModelProperty(value = "The firstname attribute.", required = true)
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * The lastname attribute.
     */
    @NotNull
    @ApiModelProperty(value = "The lastname attribute.", required = true)
    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @ManyToMany(mappedBy = "coffees")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "events", "coffees" }, allowSetters = true)
    private Set<Person> people = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Coffee id(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Coffee name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return this.capacity;
    }

    public Coffee capacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Set<Person> getPeople() {
        return this.people;
    }

    public Coffee people(Set<Person> people) {
        this.setPeople(people);
        return this;
    }

    public Coffee addPerson(Person person) {
        this.people.add(person);
        person.getCoffees().add(this);
        return this;
    }

    public Coffee removePerson(Person person) {
        this.people.remove(person);
        person.getCoffees().remove(this);
        return this;
    }

    public void setPeople(Set<Person> people) {
        if (this.people != null) {
            this.people.forEach(i -> i.removeCoffee(this));
        }
        if (people != null) {
            people.forEach(i -> i.addCoffee(this));
        }
        this.people = people;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Coffee)) {
            return false;
        }
        return id != null && id.equals(((Coffee) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Coffee{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", capacity=" + getCapacity() +
            "}";
    }
}
