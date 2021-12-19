package ru.vorobev.lesson_04.patterns.behavioral.memento;

public class EditorMemento {
	
	private  String content;
	
	public EditorMemento(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return this.content;
	}
}
