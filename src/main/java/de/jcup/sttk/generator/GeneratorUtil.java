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
import java.nio.charset.Charset;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneratorUtil {
	private static final Logger LOG = LoggerFactory.getLogger(GeneratorUtil.class);

	
	private static final Charset UTF_8 = Charset.forName("UTF-8");

	/**
	 * Writes given string to filesystem, using UTF-8
	 * 
	 * @param string
	 * @param path
	 * @throws IOException
	 */
	public static void writeFile(String string, File file) throws IOException {
		writeFile(string, file, true);
	}

	/**
	 * Writes given string to filesystem, using UTF-8
	 * 
	 * @param string
	 * @param path
	 * @throws IOException
	 */
	public static void writeFile(String string, File file, boolean overwrite) throws IOException {
		if (file==null) {
			throw new IllegalArgumentException("File may not be null!");
		}
		if (file.isDirectory()) {
			throw new IOException("Cannot write to directory!");
		}
		if (!file.isFile()) {
			throw new IOException("Cannot write to something not being a file!");
		}
		if (file.exists()) {
			if (overwrite) {
				file.delete();
			}else{
				LOG.info("File already exists, overwrite turned off- so ignored:{}",file.getAbsolutePath());
				return;
			}
		}
		Files.write(file.toPath(), string.getBytes(UTF_8));
	}
}
