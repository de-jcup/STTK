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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.jcup.sttk.STTKModel;

class STTKCopyIncludeC4PlantUMLFilesGenerator implements STTKGenerator {

	private static final Logger LOG = LoggerFactory.getLogger(STTKCopyIncludeC4PlantUMLFilesGenerator.class);

	@Override
	public void generate(STTKModel model, Path targetPath) throws IOException {
		LOG.debug("start copying c4 include files into {}",targetPath);
		
		File targetFolder = targetPath.toFile();
		copyFromJarToTargetPath("C4_Component.puml",targetFolder);
		copyFromJarToTargetPath("C4_Container.puml",targetFolder);
		copyFromJarToTargetPath("C4_Context.puml",targetFolder);
		copyFromJarToTargetPath("C4.puml",targetFolder);
	}

	private void copyFromJarToTargetPath(String fileName, File targetFolder) throws IOException {
		targetFolder.mkdirs();
		
		File file = new File(targetFolder,fileName);
		if (file.exists()) {
			return;
		}
		try(InputStream is = STTKCopyIncludeC4PlantUMLFilesGenerator.class.getResourceAsStream("/"+fileName)){
			Files.copy(is, file.toPath());
		}
	}

}
