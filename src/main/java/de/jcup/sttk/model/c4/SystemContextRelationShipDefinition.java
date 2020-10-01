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

import de.jcup.sttk.model.Identifier;

public class SystemContextRelationShipDefinition<T extends SystemContextPart<?>> {

	private SystemContextPart<T > part1;

	SystemContextRelationShipDefinition(SystemContextPart<T> part1) {
		this.part1=part1;
	}

	
	@SuppressWarnings("unchecked")
	public T system(Identifier id) {
		SystemContextRelationship relationShip = new SystemContextRelationship(part1, part1.systemContext.system(id));
		part1.relations.add(relationShip);
		return (T) part1;
	}

	@SuppressWarnings("unchecked")
	public T person(Identifier id) {
		SystemContextRelationship relationShip = new SystemContextRelationship(part1, part1.systemContext.person(id));
		part1.relations.add(relationShip);
		return (T) part1;
	}
}
