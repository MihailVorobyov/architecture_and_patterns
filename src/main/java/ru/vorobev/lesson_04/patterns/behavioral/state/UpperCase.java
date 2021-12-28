package ru.vorobev.lesson_04.patterns.behavioral.state;

class UpperCase implements WritingState {
	public void write(String words) {
		System.out.println(words.toUpperCase());
	}
}
