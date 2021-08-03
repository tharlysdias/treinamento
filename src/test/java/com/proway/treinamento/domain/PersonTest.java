package com.proway.treinamento.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.proway.treinamento.web.rest.TestUtil;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Person.class);
        Person person1 = new Person();
        person1.setId(UUID.randomUUID());
        Person person2 = new Person();
        person2.setId(person1.getId());
        assertThat(person1).isEqualTo(person2);
        person2.setId(UUID.randomUUID());
        assertThat(person1).isNotEqualTo(person2);
        person1.setId(null);
        assertThat(person1).isNotEqualTo(person2);
    }
}
