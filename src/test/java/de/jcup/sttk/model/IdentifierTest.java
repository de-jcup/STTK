package de.jcup.sttk.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class IdentifierTest {
	//TODO test what happens on null, the identifier should not allow for null values.
	
	@Test
	void create_identifier() {	
		/* execute */
		Identifier systemId = new Identifier("System");
		
		/* test */
		assertNotNull(systemId);
	}
	
	@Test
	void create_identifier_same_key_twice() {	
		/* execute */
		Identifier systemId = new Identifier("System");
		Identifier systemId2 = new Identifier("System"); // TODO this should not be possible
		
		/* test */
		assertNotNull(systemId);
		assertNotNull(systemId2);
	}
	
	@Test
	void create_identifier_empty_string() {
		/* execute */
		Identifier emptyId = new Identifier(""); // TODO this should throw an exception
		
		/* test */
		assertNotNull(emptyId);
	}
	
	@Test
	void create_identifier_null() {
		/* execute */
		Identifier nullId = new Identifier(null); // TODO this should throw an exception
		
		/* test */
		assertNotNull(nullId);
	}
}
