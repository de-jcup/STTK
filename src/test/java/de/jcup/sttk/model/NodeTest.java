package de.jcup.sttk.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import de.jcup.sttk.model.c4.ContextBoundary;
import de.jcup.sttk.model.c4.Person;
import de.jcup.sttk.model.c4.System;

public class NodeTest {
	@Test
	void create_node() {
		/* prepare */
		Identifier systemId = new Identifier("System");
		System system = mock(System.class);
		when(system.getIdentifier()).thenReturn(systemId);
		
		/* execute */
		Node node = Node.of(system);
		
		/* test */
		assertNotNull(node);
	}
	
	@Test
	void create_node_from_null() {
		/* execute */	
		Exception exception = assertThrows(IllegalArgumentException.class, () -> Node.of(null));
		
		/* test */
		assertEquals("The identifiable cannot be null!", exception.getMessage());
	}
	
	@Test
	void node_with_no_children() {
		/* prepare */
		Identifier systemId = new Identifier("system");
		System system = mock(System.class);
		when(system.getIdentifier()).thenReturn(systemId);
		
		/* execute */
		Node node = Node.of(system);
		
		/* test */
		assertNotNull(node);
		assertFalse(node.hasChildren());
		assertFalse(node.getChildren().isPresent());
		assertEquals(system, node.getIdentifiable());
	}
	
	@Test
	void node_with_no_children_no_identifier() {
		/* prepare */
		System system = mock(System.class);
		
		/* execute */
		Exception exception = assertThrows(IllegalArgumentException.class, () -> Node.of(system));
	
		/* test */
		assertEquals("The identifier of the identifier cannot be null!", exception.getMessage());
	}
	
	@Test
	void node_with_one_child() {
		/* prepare */
		Identifier contextBoundaryId = new Identifier("ContextBoundary");
		Identifier systemId = new Identifier("system");
		
		ContextBoundary contextBoundary = mock(ContextBoundary.class);
		System system = mock(System.class);
		
		when(contextBoundary.getIdentifier()).thenReturn(contextBoundaryId);
		when(system.getIdentifier()).thenReturn(systemId);
		
		Node root = Node.of(contextBoundary);
		Node child = Node.of(system);
				
		/* execute */
		root.addChild(child);
		
		/* test */
		assertTrue(root.hasChildren());
		assertTrue(root.getChildren().isPresent());
		assertEquals(1, root.getChildren().get().size());
		assertTrue(root.getChildren().get().containsValue(child));
	}

	@Test
	void node_with_children() {
		/* prepare */
		Identifier contextBoundaryId = new Identifier("ContextBoundary");
		Identifier systemId1 = new Identifier("system1");
		Identifier systemId2 = new Identifier("system2");
		Identifier personId = new Identifier("person");
		
		ContextBoundary contextBoundary = mock(ContextBoundary.class);
		System system1 = mock(System.class);
		Person person = mock(Person.class);
		System system2 = mock(System.class);
		
		when(system1.getIdentifier()).thenReturn(systemId1);
		when(system2.getIdentifier()).thenReturn(systemId2);
		when(person.getIdentifier()).thenReturn(personId);
		when(contextBoundary.getIdentifier()).thenReturn(contextBoundaryId);
		
		Node root = Node.of(contextBoundary);
		Node child1 = Node.of(system1);
		Node child2 = Node.of(person);
		Node child3 = Node.of(system2);
				
		/* execute */
		root.addChild(child1);
		root.addChild(child2);
		root.addChild(child3);
		
		/* test */
		assertTrue(root.hasChildren());
		assertTrue(root.getChildren().isPresent());
		assertEquals(3, root.getChildren().get().size());
		assertTrue(root.getChildren().get().containsValue(child3));
	}
}
