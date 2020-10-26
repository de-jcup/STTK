package de.jcup.sttk.model.c4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.jcup.sttk.STTKModel;
import de.jcup.sttk.model.Identifier;

public class PersonTest {
	private STTKModel model;
	
	@BeforeEach
	void init() {
		model = new STTKModel();
	}
	
	@Test
	void create_internal_person() {
		/* Prepare */
		Identifier identfier = new Identifier("Internal Person");
		
		/* Execute */
		Person person = new Person(identfier, model.getSystemContext());
		
		/* Test */
		assertNotNull(person);
		assertFalse(person.isExternal());
		assertEquals(identfier, person.getIdentifier());
	}
	
	@Test
	void create_external_person() {
		/* Prepare */
		Identifier identfier = new Identifier("External Person");
		
		/* Execute */
		Person person = new Person(identfier, model.getSystemContext());
		person.markAsExternal();
		
		/* Test */
		assertNotNull(person);
		assertTrue(person.isExternal());	
	}
}
