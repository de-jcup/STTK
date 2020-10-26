package de.jcup.sttk.model.c4;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.jcup.sttk.STTKModel;
import de.jcup.sttk.model.Identifier;

public class SystemContextPartTest {
	private STTKModel model;
	private SystemContext systemContext;
	
	@BeforeEach
	void init() {
		model = new STTKModel();
		systemContext = new SystemContext(this.model);
	}
	
	@Test
	void create_systemContext() {
		/* Prepare */
		Identifier partId = new Identifier("part");
		
		/* Execute */
		SystemContextPart<System> systemContextPart = new System(partId, systemContext);
		
		/* Test */
		assertNotNull(systemContextPart);
	}
	
}
