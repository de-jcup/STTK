package de.jcup.sttk.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Node {
	private AbstractIdentifiable identifiable;
	private Map<Identifier, Node> children;
	
	private Node(AbstractIdentifiable identifiable) {
		this.identifiable = identifiable;
	}
	
	public static Node of(AbstractIdentifiable identifiable) {
		if (identifiable == null) {
			throw new IllegalArgumentException("The identifiable cannot be null!");
		}
		
		if (identifiable.getIdentifier() == null) {
			throw new IllegalArgumentException("The identifier of the identifier cannot be null!");
		}
		
		return new Node(identifiable);
	}
	
	public AbstractIdentifiable getIdentifiable() {
		return identifiable;
	}

	public Optional<Map<Identifier, Node>> getChildren() {
		return Optional.ofNullable(children);
	}
	
	public boolean addChild(Node child) {
		initializeChildren();

		return children.put(child.getIdentifiable().getIdentifier(), child) != null;
	}
	
	public boolean hasChildren() {
		boolean hasChildren = false;
		
		if (children != null && !children.isEmpty()) {
			hasChildren = true;
		}
		return hasChildren;
	}
	
	private void initializeChildren() {
		if (children == null) {
			children = new HashMap<>();
		}
	}
}
