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

import java.nio.file.Files;
import java.nio.file.Path;

import de.jcup.sttk.STTK;

public class GenerateExample1 {

	public static void main(String[] args) throws Exception{
		Path targetPath  = Files.createTempDirectory("sttk");
		new GenerateExample1().generate(targetPath);
		
	}

	void generate(Path targetPath) throws Exception{
		
		ExampleModel1 model = new ExampleModel1();
		STTK.generator().build().generate(model,targetPath);
	}
}
