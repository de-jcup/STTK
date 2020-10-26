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
import de.jcup.sttk.model.AbstractIdentifiable;
import de.jcup.sttk.model.Identifier;

public abstract class SystemContextPart<T extends SystemContextPart<?>> extends AbstractIdentifiable implements ContainerRelationPart<T>{

	final List<SystemContextRelationship> relations = new ArrayList<>();
	final SystemContext systemContext;
	private ContextBoundary boundary;
	
	protected SystemContextPart(Identifier id, SystemContext systemContext) {
		super(id);
		this.systemContext=systemContext;
	}
	
	public SystemContextRelationShipDefinition does(String what) {
		return does(what, STTK.usage().isCalling());
	}
	
	public SystemContextRelationShipDefinition does(String what, UsageDefinition usage) {
		return new SystemContextRelationShipDefinition(what, this, usage);
	}
	
	@SuppressWarnings("unchecked")
	public T inBoundary(Identifier boundaryId) {
		this.boundary=systemContext.boundary(boundaryId);
		this.boundary.addPart(this);
		systemContext.remove(this.getIdentifier(), this);
		return (T) this;
	}
	
//	ContextBoundary getBoundaryOrNull(){
//		return boundary;
//	}
	
	public List<SystemContextRelationship> getRelations() {
		return relations;
	}

}
