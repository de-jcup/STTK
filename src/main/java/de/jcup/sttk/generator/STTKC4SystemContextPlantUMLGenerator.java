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
import java.util.Iterator;
import java.util.List;

import de.jcup.sttk.STTKModel;
import de.jcup.sttk.model.Direction;
import de.jcup.sttk.model.Identifier;
import de.jcup.sttk.model.c4.Person;
import de.jcup.sttk.model.c4.ContextBoundary;
import de.jcup.sttk.model.c4.SystemContextPart;
import de.jcup.sttk.model.c4.SystemContextRelationship;
import de.jcup.sttk.model.c4.Usage;

class STTKC4SystemContextPlantUMLGenerator implements STTKGenerator{

	
	@Override
	public void generate(STTKModel model, Path targetFolder) throws IOException{
		SourceBuilder sb = new SourceBuilder();
		
		sb.add("@startuml context");
		sb.add("!include C4_Context.puml");
		sb.add("LAYOUT_WITH_LEGEND()");
		
		for (Person person: model.getSystemContext().getPeople()) {
			Identifier identifier = person.getIdentifier();
			if (person.isExternal()) {
				sb.append("Person_Ext(").append(identifier.getId());
			} else {
				sb.append("Person(").append(identifier.getId());
			}
			
			sb.append(",\"").append(identifier.getName());
			
			String description = person.getIdentifier().getDescription();

			if (description != null && !description.isEmpty()) {
				sb.append("\", \"").append(description);
			}
			
			sb.append("\")").newLine();
		}
		
		for (de.jcup.sttk.model.c4.System system : model.getSystemContext().getSystems()) {
			Identifier identifier = system.getIdentifier();
			if (system.isExternal()) {
				sb.append("System_Ext(").append(identifier.getId());
			} else {
				sb.append("System(").append(identifier.getId());
			}

			sb.append(", \"").append(identifier.getName());

			String description = system.getIdentifier().getDescription();

			if (description != null && !description.isEmpty()) {
				sb.append("\", \"").append(description);
			}

			sb.append("\")").newLine();
		}
		
		for(ContextBoundary boundary : model.getSystemContext().getBoundries()) {
			Identifier identifier = boundary.getIdentifier();
			sb.append("Boundary(").append(identifier.getId());

			sb.append(", \"").append(identifier.getName());

			sb.append("\") {").newLine();
			
			//TODO add the systems/person in the boundary
			
			
			sb.append("}").newLine();
		}
		
		/* relations */
		for (Person person: model.getSystemContext().getPeople()) {
			List<SystemContextRelationship> relations = person.getRelations();
			addRelations(sb, relations);
		}
		for (de.jcup.sttk.model.c4.System system: model.getSystemContext().getSystems()) {
			List<SystemContextRelationship> relations = system.getRelations();
			addRelations(sb, relations);
		}
		
		
		sb.add("@enduml");
		
		GeneratorUtil.writeFile(sb.toString(), new File(targetFolder.toFile(), FILENAME_STTK_C4_SYSTEMCONTEXT));
		
	}

	private void addRelations(SourceBuilder sb, List<SystemContextRelationship> relations) {
		for (SystemContextRelationship relation: relations) {
			Usage usage = relation.getUsage();
			Direction direction = usage.getDirection();
			SystemContextPart<?> part1 = relation.getPart1();
			SystemContextPart<?> part2 = relation.getPart2();
			
			if (Direction.P1_CALLS_P2==direction) {
				String part1Id = part1.getIdentifier().getId();
				String part2Id = part2.getIdentifier().getId();
				
				sb.append("Rel(").append(part1Id).append(", ").append(part2Id);
				sb.append(", \"").append(relation.getWhat());
				sb.append("\"");
				
				Iterator<String> it = usage.buildTechnicalInfo().iterator();
				while (it.hasNext()) {
					sb.append(", \"");
					sb.append(it.next());
					sb.append("\"");
				}
				sb.add(")");
			}
		}
	}

	
}
