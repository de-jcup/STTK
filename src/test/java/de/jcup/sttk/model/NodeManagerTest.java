package de.jcup.sttk.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.jcup.sttk.STTKModel;
import de.jcup.sttk.model.c4.Container;
import de.jcup.sttk.model.c4.Person;
import de.jcup.sttk.model.c4.System;

public class NodeManagerTest {
	
	@Test
	void create_manager() {	
		/* execute */
		NodeManager manager = new NodeManager();
		
		/* test */
		assertNotNull(manager);
	}
	
	@Test
	void node_manager_with_one_child() {
		/* prepare */
		Identifier systemId = new Identifier("system");
		System system = mock(System.class);
		when(system.getIdentifier()).thenReturn(systemId);
		Node node = Node.of(system);
		NodeManager manager = new NodeManager();
		
		/* execute */
		manager.insert(node);
		
		/* test */
		assertNotNull(manager);
		Map<Identifier, Node> nodes = manager.getNodes();
		assertTrue(nodes.containsValue(node));
	}
	
	@Test
	void node_manager_subtree() {
		/* prepare */
		Identifier systemId = new Identifier("system");
		System system = mock(System.class);
		when(system.getIdentifier()).thenReturn(systemId);
		Node node = Node.of(system);
		NodeManager manager = new NodeManager();
		
		/* execute */
		manager.insert(node);
		
		/* test */
		assertNotNull(manager);
		Map<Identifier, Node> nodes = manager.getNodes();
		assertFalse(true);
	}
}
