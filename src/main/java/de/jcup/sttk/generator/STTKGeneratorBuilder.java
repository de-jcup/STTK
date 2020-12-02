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

public class STTKGeneratorBuilder {

	private boolean c4Enabled;
	private boolean simpleTextEnabled;

	public STTKGeneratorBuilder() {
	}

	
	public STTKGeneratorBuilder enableC4() {
		c4Enabled=true;
		return this;
	}

	
	public STTKGeneratorBuilder enableSimpleText() {
		simpleTextEnabled=true;
		return this;
	}
	
	public STTKGenerator build() {
		// currently we do just return always a new instance of asciidoctor generator,
		// without any special handling
		STTKDefaultCompositeGenerator generator = new STTKDefaultCompositeGenerator();
		generator.c4Enabled=c4Enabled;
		return generator;
	}

}