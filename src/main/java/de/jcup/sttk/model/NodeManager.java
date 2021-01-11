package de.jcup.sttk.model;

import java.util.HashMap;
import java.util.Map;

/*
 * TODO implement an unbalanced acyclic graph -> tree
 * 
 * - The tree can have a higher cost, because the tree will have 1000s of nodes.
 * - It is not a problem to search through the entire tree on every insert or delete, because the depth of the tree is not very high.
 * 
 * 
 * rootNodes  
 *  - contextBoundary
 *    - system
 *      - container
 *        - component
 *          - class
 *          - class
 *        - component 2
 *        - component 3
 *          - class
 *      - container 2
 *      - container 3
 *    - person
 *  - system
 */
public class NodeManager {
	private Map<Identifier, Node> rootNodes = new HashMap<>();
	
	public NodeManager() {
		
	}
	
	public void insert(Node node) {
		this.insert(node, null);
	}
	
	public void insert(Node node, Node parent) {
		rootNodes.put(node.getIdentifiable().getIdentifier(), node);
	}
	
	public Map<Identifier, Node> getNodes() {
		return rootNodes;
	}
}
