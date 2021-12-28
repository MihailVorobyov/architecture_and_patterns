package ru.vorobev.lesson_04.patterns.behavioral.template_method;

public class Main
{
	public static void main(String[] args) {
		
		Builder androidBuilder = new AndroidBuilder();
		androidBuilder.build();
		
		// Output:
		// Running android tests
		// Linting the android code
		// Assembling the android build
		// Deploying android build to server
		
		Builder iosBuilder = new IosBuilder();
		iosBuilder.build();
		
		// Output:
		// Running ios tests
		// Linting the ios code
		// Assembling the ios build
		// Deploying ios build to server
	}
}

