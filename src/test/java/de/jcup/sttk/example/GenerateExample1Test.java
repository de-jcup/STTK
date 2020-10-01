/*
 * Copyright 2020 Albert Tregnaghi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 */
package de.jcup.sttk.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import de.jcup.sttk.generator.STTKGenerator;

class GenerateExample1Test {

	@Test
	void main_can_be_started_and_c4_system_context_file_was_created() throws Exception {
		
		/* prepare */
		GenerateExample1 generateExampleToTest = new GenerateExample1();
		Path targetPath  = new File("build/sttk/example1").toPath();
		
		/* execute */
		generateExampleToTest.generate(targetPath);

		/* test */
		File expectedFile=new File(targetPath.toFile(),STTKGenerator.FILENAME_STTK_C4_SYSTEMCONTEXT);
		
		assertTrue(expectedFile.exists());
	}

}
