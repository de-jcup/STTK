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
package de.jcup.sttk.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import de.jcup.sttk.model.c4.Person;
import de.jcup.sttk.model.c4.System;

class ExampleModel1Test {

	@Test
	void model_can_be_created_and_system_context_is_not_null() {
		ExampleModel1 model = new ExampleModel1();
		assertNotNull(model.getSystemContext(),"model systemcontext is not null!");
	}
	
	@Test
	void model_can_be_created_and_system_context_contains_people_and_systems() {
		ExampleModel1 model = new ExampleModel1();
		Collection<Person> people = model.getSystemContext().getPeople();
		assertNotNull(people,"people available");
		assertEquals(1, people.size(),"People size differs!");
		Person person = people.iterator().next();
		assertEquals(ExampleModel1.PERSONAL_BANKING_CUSTOMER, person.getIdentifier());
		
		Collection<System> systems = model.getSystemContext().getSystems();
		assertNotNull(systems,"systemsavailable");
		assertEquals(3,systems.size(),"System size not as expected!");
		
	}

}
