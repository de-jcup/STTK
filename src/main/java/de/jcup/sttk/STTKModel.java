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
package de.jcup.sttk;

import java.util.LinkedHashMap;
import java.util.Map;

import de.jcup.sttk.model.Identifier;
import de.jcup.sttk.model.Technology;
import de.jcup.sttk.model.c4.SystemContext;

public class STTKModel {

	private SystemContext systemContext;
	private Map<Identifier, Technology> technologies = new LinkedHashMap<>();
	
	public STTKModel() {
		systemContext=new SystemContext(this);
	}
	
	public SystemContext getSystemContext() {
		return systemContext;
	}
	
	public Technology getTechnology(Identifier technologyId) {
		return technologies.computeIfAbsent(technologyId, this::createTechnology);
	}
	
	private Technology createTechnology(Identifier id) {
		return new Technology(id);
	}

}
