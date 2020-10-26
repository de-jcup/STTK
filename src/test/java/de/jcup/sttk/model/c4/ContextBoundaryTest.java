package de.jcup.sttk.model.c4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.jcup.sttk.STTKModel;
import de.jcup.sttk.model.Identifier;

public class ContextBoundaryTest {
	private STTKModel model;
	
	@BeforeEach
	void init() {
		model = new STTKModel();
	}
	
	@Test
	void create_boundary() {
		/* Prepare */
		Identifier identfier = new Identifier("Bank System");
		
		/* Execute */
		ContextBoundary boundary = new ContextBoundary(identfier, model.getSystemContext());
		
		/* Test */
		assertNotNull(boundary);
		assertTrue(boundary.getParts().isEmpty());
	}
	
	@Test
	void hasElements_empty() {
		/* Prepare */
		Identifier bank = new Identifier("Bank");
		
		/* Execute */
		ContextBoundary boundary = new ContextBoundary(bank, model.getSystemContext());
		
		/* Test */
		assertTrue(boundary.getParts().isEmpty());
		assertFalse(boundary.containsElements());
	}
	
	@Test
	void hasElements_many() {
		/* Prepare */
		Identifier bankId = new Identifier("Bank");
		Identifier jumpServerId = new Identifier("Jump Server");
		Identifier systemAdministratorId = new Identifier("System Administrator");
		
		/* Execute */
		ContextBoundary bank = new ContextBoundary(bankId, model.getSystemContext());
		System system = new System(jumpServerId, model.getSystemContext());
		bank.addPart(system);
		
		Person systemAdministrator = new Person(systemAdministratorId, model.getSystemContext());
		bank.addPart(systemAdministrator);
		
		/* Test */
		assertEquals(2, bank.getParts().size());
		assertTrue(bank.containsElements());
	}
}
