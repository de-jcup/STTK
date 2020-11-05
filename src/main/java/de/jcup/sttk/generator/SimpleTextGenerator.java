package de.jcup.sttk.generator;

import java.util.Map;

import de.jcup.sttk.STTKModel;
import de.jcup.sttk.model.Identifier;
import de.jcup.sttk.model.c4.ContextBoundary;
import de.jcup.sttk.model.c4.Person;
import de.jcup.sttk.model.c4.System;
import de.jcup.sttk.model.c4.SystemContextPart;

public class SimpleTextGenerator {
	
	public String generate(STTKModel model) {
		SourceBuilder sb = new SourceBuilder();
		
		sb.add("== Text ==");
		
		Map<Identifier, SystemContextPart<?>> elements = model.getSystemContext().getParts();

		for (Map.Entry<Identifier,SystemContextPart<?>> entry : elements.entrySet()) {
			SystemContextPart<?> part = entry.getValue();
			
			if (!part.isInBoundary()) {
				if (part.getClass() == Person.class) {
					sb.add(part.toString());
				} else if (part.getClass() == System.class) {
					sb.add(part.toString());
				} else if (part.getClass() == ContextBoundary.class) {
					sb.add(part.toString());
					sb.add("start");
					
					ContextBoundary context = (ContextBoundary) part;
					
					for (Map.Entry<Identifier,SystemContextPart<?>> contextEntry : context.getParts().entrySet()) {
						SystemContextPart<?> contextPart = contextEntry.getValue();
						
						if (contextPart.getClass() == Person.class) {
							sb.add("\t" + contextPart.toString());
						} else if (contextPart.getClass() == System.class) {
							sb.add("\t" + contextPart.toString());
						}
					}
					
					sb.add("end");
					
				}
			}
		}
		
		return sb.toString();
	}
}
