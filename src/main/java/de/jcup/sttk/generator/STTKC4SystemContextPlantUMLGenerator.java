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
import java.nio.file.Path;

import de.jcup.sttk.STTKModel;
import de.jcup.sttk.model.Identifier;
import de.jcup.sttk.model.c4.Person;

class STTKC4SystemContextPlantUMLGenerator implements STTKGenerator{

	@Override
	public void generate(STTKModel model, Path targetFolder) throws IOException{
		SourceBuilder sb = new SourceBuilder();
		
		sb.add("@startuml context");
		sb.add("!include C4_Context.puml");
		
		for (Person person: model.getSystemContext().getPeople()) {
			Identifier identifier = person.getIdentifier();
			sb.append("Person(").append(identifier.getId());
			sb.append(",\"").append(identifier.getName()).append("\"").newLine();
		}
		
		for (de.jcup.sttk.model.c4.System person: model.getSystemContext().getSystems()) {
			Identifier identifier = person.getIdentifier();
			sb.append("System(").append(identifier.getId());
			sb.append(",\"").append(identifier.getName()).append("\"").newLine();
		}
		
		/* relations */
		/* FIXME de-jcup implement!*/
		
		sb.add("@enduml");
		
		GeneratorUtil.writeFile(sb.toString(), new File(targetFolder.toFile(), "c4_context.puml"));
		
	}

	
}
