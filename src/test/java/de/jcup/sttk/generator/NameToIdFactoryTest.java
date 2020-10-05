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
	void factory_start_with_id_0() {
		/* execute */
		String id = factoryToTest.create();

		/* test */
		assertEquals("id_0", id);
	}
	
	@Test
	void factory_with_given_name_translates_name_to_lowercase_and_replaces_all_parts_not_beeing_letters_or_numbers_with_underscore() {
		/* execute */
		String id = factoryToTest.create("My name$is_a|<>very\nspecial'one");

		/* test */
		assertEquals("my_name_is_a___very_special_one_0", id);
	}

	@Test
	void factory_created_two_times_produces_id_0_than_id_1_than_id_2() {
		/* execute */
		String firstId = factoryToTest.create();
		String secondId = factoryToTest.create();
		String thirdId = factoryToTest.create();

		/* test */
		assertEquals("id_0", firstId);
		assertEquals("id_1", secondId);
		assertEquals("id_2", thirdId);
	}

	@Test
	void two_factory_start_both_with_id_0_even_when_one_has_already_build() {
		NameToIdFactory anotherfactoryToTest = new NameToIdFactory();

		/* execute */
		String id1 = factoryToTest.create();
		String id2 = anotherfactoryToTest.create();

		/* test */
		assertEquals("id_0", id1);
		assertEquals("id_0", id2);
	}

}