package de.jcup.sttk.example;

import de.jcup.sttk.generator.SimpleTextGenerator;

public class GenerateExample3 {
	public static void main(String[] args) {
		new GenerateExample3().generate();
	}

	void generate() {
		
		ExampleModel3 model = new ExampleModel3();
		SimpleTextGenerator stg = new SimpleTextGenerator();
		System.out.print(stg.generate(model));
	}
}
