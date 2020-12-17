package de.jcup.sttk.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.jcup.sttk.STTKModel;
import de.jcup.sttk.model.c4.Container;
import de.jcup.sttk.model.c4.Person;
import de.jcup.sttk.model.c4.System;

public class NodeManagerTest {
	//TODO remove the model as dependency
	//Create nodes and test on those
	//Test the NodeManager not everything else as well

//	private STTKModel model;
//	
//	@BeforeEach
//	void init() {
//		model = new STTKModel();
//	}
//	
//	@Test
//	void create_manager() {	
//		/* execute */
//		NodeManager manager = new NodeManager();
//		
//		/* test */
//		assertNotNull(manager);
//	}
//	
//	@Test
//	void node_with_internal_person() {
//		/* Prepare */
//		Identifier identfier = new Identifier("Internal Person");
//		Person person = new Person(identfier, model.getSystemContext());
//		
//		/* Execute */
//		Node node = new Node(person);
//		
//		/* Test */
//		assertNotNull(node);
//		assertEquals(node.getIdentifiable(), person);
//		assertFalse(node.hasChildren());
//	}
//	
//	@Test
//	void small_tree_system_container_internal() {
//		/* Prepare */
//		Identifier systemId = new Identifier("Internal System");
//		Identifier containerId = new Identifier("Internal Container");
//		System system = new System(systemId, model.getSystemContext());
//		Container container = system.zoomIn().container(containerId);
//		
//		/* Execute */
//		Node systemNode = new Node(system);
//		Node containerNode = new Node(container);
//		systemNode.addChild(containerNode);
//
//		
//		/* Test */
//		assertNotNull(systemNode);
//		assertEquals(systemNode.getIdentifiable(), system);
//		assertEquals(NodeType.SYSTEM, systemNode.getType());
//		assertTrue(systemNode.hasChildren());
//		assertNotNull(containerNode);
//		assertEquals(containerNode.getIdentifiable(), container);
//		assertEquals(NodeType.CONTAINER, containerNode.getType());
//	}
//	
//	@Test
//	void small_tree_system_internal_context_boundary() {
//		/* Prepare */
//		Identifier systemId = new Identifier("Internal System");
//		Identifier contextBoundaryId = new Identifier("Context Boundary");
//		
//		System system = new System(systemId, model.getSystemContext());
//		
//		/* Execute */
//		Node systemNode = new Node(system);
//		//Node containerNode = new Node(ContextBoundary);
//		//systemNode.addChild(containerNode);
//
//		
//		/* Test */
//		assertNotNull(systemNode);
//		assertEquals(systemNode.getIdentifiable(), system);
//		assertTrue(systemNode.hasChildren());
//		//assertNotNull(containerNode);
//		//assertEquals(containerNode.getIdentifiable(), container);
//		assertFalse(true);
//	}
}
