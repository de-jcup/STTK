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

public class ContainerCallerRelationShipDefinition<T extends Container> {

	private Container container;
	private Identifier caller;


	public ContainerCallerRelationShipDefinition(Container container, Identifier caller) {
		this.container=container;
		this.caller=caller;
	}
	
	public Container doing(String what, UsageDefinition usage) {
		/* FIXME de-jcup : think about caller and direction here! I think we have to switch direction!*/
		ContainerRelationShip relationShip = new ContainerRelationShip(what,container.getIdentifier(), caller,usage.usage);
		container.relations.add(relationShip);
		return container;
	}
}
