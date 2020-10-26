package de.jcup.sttk.model.c4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.jcup.sttk.STTKModel;
import de.jcup.sttk.model.Identifier;

public class SystemContextTest {
	private STTKModel model;
	private SystemContext systemContext;
	
	@BeforeEach
	void init() {
		model = new STTKModel();
		systemContext = new SystemContext(this.model);
	}
	
	@Test
	void create_systemContext() {
		/* Execute */
		SystemContext systemContext = new SystemContext(model);
		
		/* Test */
		assertNotNull(systemContext);
		assertTrue(systemContext.getParts().isEmpty());
	}
	
	@Test
	void systemContext_create_boundary() {
		/* Prepare */
		Identifier company = new Identifier("Company");
		
		/* Execute */
		ContextBoundary contextBoundary = systemContext.boundary(company);
		
		/* Test */
		assertNotNull(contextBoundary);
		assertEquals(1, systemContext.getParts().size());
	}
	
	@Test
	void systemContext_create_system_with_boundary() {
		/* Prepare */
		Identifier companyId = new Identifier("Company");
		Identifier systemAId = new Identifier("System A");
		Identifier systemBId = new Identifier("System B");
		Identifier customerId = new Identifier("Customer");
		
		systemContext.person(customerId).markAsExternal();
		systemContext.system(systemAId).inBoundary(companyId);
		systemContext.system(systemBId).markAsExternal();

		/* Execute */
		Map<Identifier, SystemContextPart<?>> parts = systemContext.getParts();
		
		/* Test */
		assertEquals(3, parts.size());
		
		ContextBoundary contextBoundary = (ContextBoundary) parts.getOrDefault(companyId, null);
		assertEquals(1, contextBoundary.getParts().size());
	}
}
