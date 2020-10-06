package de.jcup.sttk.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ExampleModel2Test {
	@Test
	void model_can_be_created_and_system_context_is_not_null() {
		ExampleModel1 model = new ExampleModel1();
		assertNotNull(model.getSystemContext(),"model systemcontext is not null!");
	}
	
}
