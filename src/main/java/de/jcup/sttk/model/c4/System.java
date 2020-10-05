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

import java.util.LinkedHashMap;
import java.util.Map;

import de.jcup.sttk.model.Identifier;

public class System extends SystemContextPart<System> {

	boolean external;
	private Map<Identifier,Container> container = new LinkedHashMap<>();
	
	public System(Identifier id, SystemContext systemContext) {
		super(id, systemContext);
	}
	
	public System markAsExternal() {
		external=true;
		return this;
	}

	public boolean isExternal() {
		return external;
	}
	
	public class SystemLevel2{
		
		public Container container(Identifier containerId) {
			return container.computeIfAbsent(containerId,this::createContainer);
		}
		
		public System zoomOut() {
			return System.this;
		}
		
		private Container createContainer(Identifier id) {
			return new Container(id, System.this);
		}
	}
	
	public SystemLevel2 zoomIn() {
		return new SystemLevel2();
	}


}
