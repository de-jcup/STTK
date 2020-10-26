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
package de.jcup.sttk.model;

import java.util.LinkedHashMap;
import java.util.Map;

import de.jcup.sttk.generator.NameToIdFactory;

public class Identifier {

	/* we use shared instance of factory to have one incrementing counter in ids */
	private static final NameToIdFactory SHARED_NAME_TO_ID_FACTORY = new NameToIdFactory();
	
	private static Map<String, Identifier> existigIdsMap = new LinkedHashMap<>();
	
	private String name;
	private String description;
	private String id;

	public Identifier(String name) {
		this(name, null);
	}
	public Identifier(String name, String description) {
		this(name,description,null);
	}

	public Identifier(String name, String description, String variant) {
		this.name = name;
		this.description = description;
		String potentialId=SHARED_NAME_TO_ID_FACTORY.create(name);
		if (variant!=null) {
			potentialId=potentialId+SHARED_NAME_TO_ID_FACTORY.create(variant);
		}
		
		if (existigIdsMap.containsKey(potentialId)) {
			throw new IllegalStateException("exists already id:"+potentialId);
		}
		this.id=potentialId;
	}

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	@Override
	public String toString() {
		return "Identifier [name=" + name + ", description=" + description + ", id=" + id + "]";
	}
}
