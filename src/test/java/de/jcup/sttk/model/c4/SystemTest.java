package de.jcup.sttk.model.c4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.jcup.sttk.STTKModel;
import de.jcup.sttk.model.Identifier;

public class SystemTest {
	private STTKModel model;
	
	@BeforeEach
	void init() {
		model = new STTKModel();
	}
	
	@Test
	void create_internal_system() {
		/* Prepare */
		Identifier identfier = new Identifier("Internal System");
		
		/* Execute */
		System system = new System(identfier, model.getSystemContext());
		
		/* Test */
		assertNotNull(system);
		assertFalse(system.isExternal());	
	}
	
	@Test
	void create_external_system() {
		/* Prepare */
		Identifier identfier = new Identifier("External System");
		
		/* Execute */
		System system = new System(identfier, model.getSystemContext());
		system.markAsExternal();
		
		/* Test */
		assertNotNull(system);
		assertTrue(system.isExternal());	
	}
}
