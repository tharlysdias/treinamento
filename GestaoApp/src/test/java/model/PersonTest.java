package model;

import static org.junit.Assert.*;

import org.junit.Ignore;

import org.junit.Test;

public class PersonTest {
	
	@Test
	public void testGetUsuario() {
		Person p = new Person("Tharlys", "Dias");
		assertEquals("Tharlys", p.getName());
	}

	@Test
	public void testPersistir() {
		Person person = new Person();
		
		boolean verdadeiro = person.Persistir();
		
		assertEquals(true, verdadeiro);
	}
	
	@Ignore
	public void testGetPersons() {
		
	}
	

}
