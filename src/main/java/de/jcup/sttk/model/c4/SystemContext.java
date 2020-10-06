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

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import de.jcup.sttk.STTKModel;
import de.jcup.sttk.model.Identifier;

public class SystemContext {
	
	private Map<Identifier, System> systems = new HashMap<>();
	private Map<Identifier, Person> people = new HashMap<>();
	private Map<Identifier, SystemContextBoundary> boundary = new LinkedHashMap<>();

	STTKModel model;

	public SystemContext(STTKModel model) {
		this.model=model;
	}

	public System system(Identifier id) {
		return systems.computeIfAbsent(id, this::createSystem);
	}
	
	private System createSystem(Identifier id) {
		return new System(id,this);
	}
	
	public Person person(Identifier id) {
		return people.computeIfAbsent(id, this::createPerson);
	}
	
	private Person createPerson(Identifier id) {
		return new Person(id,this);
	}

	public SystemContextBoundary boundary(Identifier id) {
		return boundary.computeIfAbsent(id, this::createBoundary);
	}
	
	private SystemContextBoundary createBoundary(Identifier id) {
		return new SystemContextBoundary(id,this);
	}
	
//	public Optional<Person> getPerson(Identifier id) {
//		return Optional.ofNullable(people.get(id));
//	}
//	
//	public Optional<System> getSystem(Identifier id) {
//		return Optional.ofNullable(systems.get(id));
//	}

	public Collection<Person> getPeople() {
		return people.values();
	}
	
	public Collection<System> getSystems() {
		return systems.values();
	}
}
