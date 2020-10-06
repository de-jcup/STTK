package de.jcup.sttk.example;

import de.jcup.sttk.STTKModel;
import de.jcup.sttk.model.Identifier;
import de.jcup.sttk.model.c4.SystemContext;

public class ExampleModel2 extends STTKModel {
	final static Identifier DEVELOPER = new Identifier("Developer", "The SecHub Developer");
	final static Identifier ADMINISTRATOR = new Identifier("Administrator", "The system administrator");
	final static Identifier USER = new Identifier("User", "The SecHub user");
	final static Identifier SECHUB = new Identifier("SecHub", "The SecHub system");
	final static Identifier CI_CD_SERVER = new Identifier("CI/CD server", "The Continues Integration and Continues Deployment server");
	final static Identifier GIT_SERVER = new Identifier("Git server", "The git server with source code");
	final static Identifier LOGGING = new Identifier("Logging", "The log server");
	final static Identifier USER_SYSTEM = new Identifier("User System", "A user system or systems to scan");
	final static Identifier OBEJECT_STORAGE = new Identifier("Object Storage", "The object storage");
	final static Identifier CONTAINER_REGISTRY = new Identifier("Container Registry", "The container registry");
	
	/* @formatter:off */
	public ExampleModel2() {
		
		SystemContext sc = getSystemContext();
		
		sc.person(DEVELOPER)
		    .does("builds").system(CI_CD_SERVER)
		    .does("pushes code changes").system(GIT_SERVER);
		
		sc.person(ADMINISTRATOR)
		    .does("administrates").system(SECHUB)
		    .does("administrates").system(CI_CD_SERVER);
		
		sc.person(USER)
		    .markAsExternal()
		    .does("uses SecHub for security testing").system(SECHUB);
		
		sc.system(SECHUB)
		    .does("logs").system(LOGGING)
		    .does("stores source code").system(OBEJECT_STORAGE)
		    .does("scans user system/application").system(USER_SYSTEM)
		    .does("pulls containers").system(CONTAINER_REGISTRY);
		
		sc.system(CI_CD_SERVER)
		    .does("pushes container to registry").system(CONTAINER_REGISTRY)
		    .does("donloads source code").system(GIT_SERVER)
		    .does("deploys sechub").system(SECHUB);
		
		sc.system(GIT_SERVER).markAsExternal();
		sc.system(LOGGING).markAsExternal();
		sc.system(USER_SYSTEM).markAsExternal();
		sc.system(OBEJECT_STORAGE).markAsExternal();
		sc.system(CONTAINER_REGISTRY).markAsExternal();
	}
	/* @formatter:on */
}
