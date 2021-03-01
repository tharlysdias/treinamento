package model;

import static org.junit.Assert.*;

import org.junit.Ignore;

import org.junit.Test;

public class PersonTest {
	
	@Test
	public void testGetUsuario() {
		PersonTest personTest = new PersonTest();
		
	}

	@Test
	public boolean testPersistir() {
		PersonTest person = new PersonTest();
		
		boolean verdadeiro = person.testPersistir();
		
		assertEquals(true, verdadeiro);
		return verdadeiro;
	}
	
	@Ignore
	public void testGetPersons() {
		
	}
	

}
