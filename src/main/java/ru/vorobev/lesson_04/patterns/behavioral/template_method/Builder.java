package ru.vorobev.lesson_04.patterns.behavioral.template_method;

abstract class Builder {
	
	// Template method
	final public void build() {
		this.test();
		this.lint();
		this.assemble();
		this.deploy();
	}
	
	abstract public void test();
	
	abstract public void lint();
	
	abstract public void assemble();
	
	abstract public void deploy();
}
