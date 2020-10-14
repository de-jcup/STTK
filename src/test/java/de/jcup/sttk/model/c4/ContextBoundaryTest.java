package de.jcup.sttk.model.c4;

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
		Identifier identfier = new Identifier("Boundary Person");
		
		/* Execute */
		ContextBoundary boundary = new ContextBoundary(identfier, model.getSystemContext());
		
		/* Test */
		assertNotNull(boundary);
		assertTrue(boundary.getElements().isEmpty());
	}
}
