package de.jcup.sttk.example;

import java.nio.file.Files;
import java.nio.file.Path;

import de.jcup.sttk.STTK;

public class GenerateExample2 {
	public static void main(String[] args) throws Exception{
		Path targetPath  = Files.createTempDirectory("sttk");
		new GenerateExample2().generate(targetPath);
		
	}

	void generate(Path targetPath) throws Exception{
		
		ExampleModel2 model = new ExampleModel2();
		STTK.generator().build().generate(model,targetPath);
	}
}
