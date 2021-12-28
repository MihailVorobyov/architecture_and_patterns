package ru.vorobev.lesson_04.patterns.behavioral.template_method;

class AndroidBuilder extends Builder {
	
	public void test() {
		System.out.println("Running android tests");
	}
	
	public void lint() {
		System.out.println("Linting the android code");
	}
	
	public void assemble() {
		System.out.println("Assembling the android build");
	}
	
	public void deploy() {
		System.out.println("Deploying android build to server");
	}
}
