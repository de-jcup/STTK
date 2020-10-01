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
package de.jcup.sttk.generator;

import java.io.IOException;
import java.nio.file.Path;

import de.jcup.sttk.STTKModel;

public interface STTKGenerator {

	public static final String FILENAME_STTK_C4_SYSTEMCONTEXT = "sttk_c4_context.puml";

	
	public void generate(STTKModel model, Path targetPath) throws IOException;

}
