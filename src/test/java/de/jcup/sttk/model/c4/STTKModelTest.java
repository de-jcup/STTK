package de.jcup.sttk.model.c4;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import de.jcup.sttk.STTKModel;

public class STTKModelTest {
	@Test
	void create_new_system_context() {
		/* Execute */
		STTKModel model = new STTKModel();
		
		/* Test */
		assertNotNull(model);
	}
}
