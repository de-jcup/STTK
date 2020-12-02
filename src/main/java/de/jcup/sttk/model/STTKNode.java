package de.jcup.sttk.model;

import java.util.List;

public interface STTKNode {

	public List<STTKNode> getChildren();
	
	public STTKNodeType getType();
}
