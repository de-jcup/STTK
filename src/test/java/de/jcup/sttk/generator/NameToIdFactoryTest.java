package de.jcup.sttk.generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameToIdFactoryTest {
	
	NameToIdFactory factoryToTest;

	@BeforeEach
	void beforeEach() {
		factoryToTest = new NameToIdFactory();
	}
	
	@Test
	void factory_create_null_returns_null() {
		/* execute */
		String id = factoryToTest.create(null);

		/* test */
		assertEquals("null", id);
	}
	
	@Test
	void factory_with_given_name_translates_name_to_lowercase_and_replaces_all_parts_not_beeing_letters_or_numbers_with_underscore() {
		/* execute */
		String id = factoryToTest.create("My name$is_a|<>very\nspecial'one");

		/* test */
		assertEquals("my_name_is_a___very_special_one", id);
	}

	@Test
	void factory_created_two_times_produces_id_0_than_id_1_than_id_2() {
		/* execute */
		String firstId = factoryToTest.create("first");
		String secondId = factoryToTest.create("second");
		String thirdId = factoryToTest.create("third");

		/* test */
		assertEquals("first", firstId);
		assertEquals("second", secondId);
		assertEquals("third", thirdId);
	}
	

}