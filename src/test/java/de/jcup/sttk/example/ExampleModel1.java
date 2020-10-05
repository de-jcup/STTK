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

import static de.jcup.sttk.STTK.usage;

import de.jcup.sttk.STTKModel;
import de.jcup.sttk.model.Identifier;
import de.jcup.sttk.model.c4.SystemContext;

public class ExampleModel1 extends STTKModel{

	final static Identifier PERSONAL_BANKING_CUSTOMER = new Identifier("Personal Banking Customer", "A customer of the bank with personal bank accounts");
	final static Identifier INTERNET_BANKING_SYSTEM = new Identifier("Inernet Banking System");
	final static Identifier EMAIL_SYSTEM = new Identifier("Email System","The internal Microsoft Exchange e-mail system");
	final static Identifier MAINFRAME_BANKING_SYSTEM = new Identifier("Mainframe Banking System","Stores all of the core banking information about customers, accounts,transactions, etc.");
	final static Identifier BIG_BANK_PIC= new Identifier("Internet Banking System");
	
	final static Identifier WEB_APPLICATION= new Identifier("Web application");
	final static Identifier SINGLE_PAGE_APPLICATION= new Identifier("Single Page Application");
	final static Identifier API_APPLICATION= new Identifier("API Application","Provides Internet banking functionality via a JSON/HTTPS API");
	
	final static Identifier SPRING_BOOT= new Identifier("Spring Boot");
	final static Identifier JAVA= new Identifier("Java");
	

	public ExampleModel1() {
//		https://c4model.com/#CoreDiagrams
		getTechnology(SPRING_BOOT).setVersion("2.0.0");
		getTechnology(JAVA).setVersion("8");
		
		defineSystemContext();
		defineBankingSystemContainers();
		/* @formatter:on */
		
	}

	private void defineSystemContext() {
		SystemContext sc = getSystemContext();
		
		/* @formatter:off */
		sc.person(PERSONAL_BANKING_CUSTOMER).
			does("Uses").system(INTERNET_BANKING_SYSTEM);
	
		sc.system(INTERNET_BANKING_SYSTEM).
			inBoundary(BIG_BANK_PIC).
			does("Sends e-mail using").system(EMAIL_SYSTEM).
		    does("Uses").system(MAINFRAME_BANKING_SYSTEM);
		
		sc.system(EMAIL_SYSTEM).markAsExternal().
			inBoundary(BIG_BANK_PIC).
			does("Sends e-mails to").person(PERSONAL_BANKING_CUSTOMER);
		
		sc.system(MAINFRAME_BANKING_SYSTEM).
		    markAsExternal().
			inBoundary(BIG_BANK_PIC);
		
		
	}

	/* @formatter:off */
	private void defineBankingSystemContainers() {
		SystemContext sc = getSystemContext();
		// https://c4model.com/img/bigbankplc-Containers.png
		sc.system(INTERNET_BANKING_SYSTEM).zoomIn().
			
			container(WEB_APPLICATION).
			    technologies(SPRING_BOOT,JAVA).
				calledByPerson(PERSONAL_BANKING_CUSTOMER).doing("Visits bgbang.com/ib",usage().https()).
				does("Delivers to the customer's web browser").container(SINGLE_PAGE_APPLICATION).
		    
			container(SINGLE_PAGE_APPLICATION).
		    	does("Makes API calls to").container(API_APPLICATION);
		    	
		
	}
	/* @formatter:on */
}
