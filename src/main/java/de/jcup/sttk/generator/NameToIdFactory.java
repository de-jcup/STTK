package de.jcup.sttk.generator;

public class NameToIdFactory {
	
	private int count;
	
	/**
	 * Creates with defeault name "id"
	 * @return identifier - e.g. "id_0"
	 */
	public String create() {
		return create("id");
	}

	/**
	 * Creates identifier for given name
	 * @param name
	 * @return identifier - e.g. "myname_0"
	 */
	public String create(String name) {
		StringBuilder nameTranformed = new StringBuilder(); 
		if (name!=null) {
			for (char c : name.toCharArray()) {
				if (Character.isLetterOrDigit(c)) {
					nameTranformed.append(c);
				}else {
					nameTranformed.append('_');
				}
			}
		}
		String result = nameTranformed.toString().toLowerCase()+"_"+count;
		
		count++;
		
		return result;
	}

}
