package de.jcup.sttk.model;

import java.util.HashSet;
import java.util.Set;

public class Node {
	AbstractIdentifiable identifiable;
	Set<Node> children = new HashSet<>();
	
	public Node(AbstractIdentifiable identifiable) {
		this.identifiable = identifiable;
	}
	
	public AbstractIdentifiable getIdentifiable() {
		return identifiable;
	}

	public Set<Node> getChildren() {
		return children;
	}
	
	public boolean addChild(Node child) {
		return children.add(child);
	}
	
	public boolean hasChildren() {	
		return !children.isEmpty();
	}
	
	/*public NodeType getType() {
		return null;
	}*/
}
