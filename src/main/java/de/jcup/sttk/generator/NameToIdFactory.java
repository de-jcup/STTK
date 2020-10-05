package de.jcup.sttk.generator;

public class NameToIdFactory {
	
	/**
	 * Creates identifier for given name
	 * @param name
	 * @return identifier - e.g. "myname_0". when name is <code>null</code> a "null" is returned
	 */
	public String create(String name) {
		if (name==null) {
			return "null";
		}
		StringBuilder nameTransformed = new StringBuilder(); 
		if (name!=null) {
			for (char c : name.toCharArray()) {
				if (Character.isLetterOrDigit(c)) {
					nameTransformed.append(c);
				}else {
					nameTransformed.append('_');
				}
			}
		}
		String result = nameTransformed.toString().toLowerCase();
		
		return result;
	}

}
