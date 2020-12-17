package de.jcup.sttk.model;

public enum NodeType {
	PERSON,
	SYSTEM,
	CONTAINER;
	
	public static NodeType valueOfIgnoreCase(String value) {
		value = value.toUpperCase();
		
		return NodeType.valueOf(value);
	}
}
