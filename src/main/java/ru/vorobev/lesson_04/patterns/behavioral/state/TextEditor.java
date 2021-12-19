package ru.vorobev.lesson_04.patterns.behavioral.state;

class TextEditor {
	private WritingState state;
	
	public TextEditor(WritingState state) {
		this.state = state;
	}
	
	public void setState(WritingState state) {
		this.state = state;
	}
	
	public void type(String words) {
		this.state.write(words);
	}
}
