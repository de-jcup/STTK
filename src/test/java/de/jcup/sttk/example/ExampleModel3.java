package de.jcup.sttk.example;

import de.jcup.sttk.STTKModel;
import de.jcup.sttk.model.Identifier;
import de.jcup.sttk.model.c4.SystemContext;

public class ExampleModel3 extends STTKModel {
	final static Identifier PERSON_INTERNAL  = new Identifier("Person Internal", "Internal Person");
	final static Identifier PERSON_EXTERAL  = new Identifier("Person External", "External Person");
	final static Identifier SYSTEM_INTERNAL  = new Identifier("System Internal", "Internal System");
	final static Identifier BOUNDARY_COMPANY = new Identifier("Company", "The company boundary");
	
	public ExampleModel3() {
		SystemContext sc = getSystemContext();

		sc.person(PERSON_INTERNAL).inBoundary(BOUNDARY_COMPANY).does("uses").system(SYSTEM_INTERNAL);

		sc.system(SYSTEM_INTERNAL).inBoundary(BOUNDARY_COMPANY);

		sc.person(PERSON_EXTERAL).markAsExternal().does("uses").system(SYSTEM_INTERNAL);
	}
}
