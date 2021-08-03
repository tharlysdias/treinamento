package com.proway.treinamento.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.proway.treinamento.web.rest.TestUtil;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class EventTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Event.class);
        Event event1 = new Event();
        event1.setId(UUID.randomUUID());
        Event event2 = new Event();
        event2.setId(event1.getId());
        assertThat(event1).isEqualTo(event2);
        event2.setId(UUID.randomUUID());
        assertThat(event1).isNotEqualTo(event2);
        event1.setId(null);
        assertThat(event1).isNotEqualTo(event2);
    }
}
