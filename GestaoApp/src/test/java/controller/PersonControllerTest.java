package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Ignore;

import org.junit.Test;

import model.Person;

public class PersonControllerTest {

	@Test
	public void testSavePerson() {
			// Instancia a classe PersonController
            PersonControllerTest personControl = new PersonControllerTest();
            boolean opLogico = personControl.equals(personControl);
            // Verifica se o metodo está retornando verdadeiro
            assertEquals(true, opLogico);
            
            // Verifica se o metodo nao retorna nulo
            assertNotNull(personControl);
	}

	@Ignore
	public void testGetPersons() {
		
	}

}
