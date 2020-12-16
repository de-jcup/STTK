package de.jcup.sttk.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ManagerTest {
	@Test
	void create_manager() {	
		/* execute */
		NodeManager manager = new NodeManager();
		
		/* test */
		assertNotNull(manager);
	}
}
