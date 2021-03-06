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
package de.jcup.sttk.model.c4;

import java.util.ArrayList;
import java.util.List;

import de.jcup.sttk.STTK;
import de.jcup.sttk.model.Identifier;
import de.jcup.sttk.model.Technology;

public class Container extends SystemPart {
	
	private List<Technology> technologies = new ArrayList<>();
	List<ContainerRelationShip> relations = new ArrayList<>();

	protected Container(Identifier id, System system) {
		super(id, system);
	}

	public Container technologies(Identifier ...technologyIdenifiers) {
		for (Identifier id: technologyIdenifiers) {
			technologies.add(this.system.systemContext.model.getTechnology(id));
		}
		return this;
	}
	
	public Container container(Identifier id) {
		return this.system.zoomIn().container(id);
	}

	public ContainerCallerRelationShipDefinition calledByPerson(Identifier caller) {
		return new ContainerCallerRelationShipDefinition(this,caller);
	}
	
	public ContainerDoesRelationShipDefinition does(String what) {
		return does(what, STTK.usage().isCalling());
	}
	
	public ContainerDoesRelationShipDefinition does(String what, UsageDefinition usage) {
		return new ContainerDoesRelationShipDefinition(what, this, usage);
	}
	

}
