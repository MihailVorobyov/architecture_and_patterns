package ru.vorobev.lesson_04.patterns.behavioral.state;

class LowerCase implements WritingState {
	public void write(String words) {
		System.out.println(words.toLowerCase());
	}
}
