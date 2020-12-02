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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.jcup.sttk.model.AbstractIdentifiable;
import de.jcup.sttk.model.Identifier;

//TODO this class needs to be worked on
//Their can be a container boundary as well, it probably needs a general boundary class
public class ContextBoundary extends SystemContextPart<ContextBoundary> {

	private Map<Identifier, SystemContextPart<?>> partsIn Boundary = new HashMap<>();

	protected ContextBoundary(Identifier id, SystemContext systemContext) {
		super(id, systemContext);
	}
	
	//TODO is this really a good idea?
	protected SystemContextPart<?> addPart(SystemContextPart<?> part) {
		return partsInBoundary.putIfAbsent(part.getIdentifier(), part);
	}

	public Map<Identifier, SystemContextPart<?>> getParts() {
		return partsInBoundary;
	}
	
	public boolean containsElements() {
		return !partsInBoundary.isEmpty();
	}

	@Override
	public String toString() {
		return "ContextBoundary [" + this.getIdentifier().getName() + "]";
	}
}
