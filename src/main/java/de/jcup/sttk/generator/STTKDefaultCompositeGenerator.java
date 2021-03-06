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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.jcup.sttk.STTKModel;

class STTKDefaultCompositeGenerator implements STTKGenerator {

	private static final Logger LOG = LoggerFactory.getLogger(STTKDefaultCompositeGenerator.class);

	private STTKCopyIncludeC4PlantUMLFilesGenerator includesCopyGenerator = new STTKCopyIncludeC4PlantUMLFilesGenerator();
	private STTKAsciidocGenerator asciidocGenerator = new STTKAsciidocGenerator();
	private STTKC4SystemContextPlantUMLGenerator c4SystemContextPlantUMLGenerator = new STTKC4SystemContextPlantUMLGenerator();

	@Override
	public void generate(STTKModel model, Path targetPath) throws IOException {
		LOG.info("start output generation to {}",targetPath);
		
		includesCopyGenerator.generate(model, targetPath);
		c4SystemContextPlantUMLGenerator.generate(model, targetPath);
		asciidocGenerator.generate(model, targetPath);
	}

}
