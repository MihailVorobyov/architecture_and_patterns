package ru.vorobev.lesson_04.patterns.behavioral.walker;

// Visitor
interface AnimalOperation {
	void visitMonkey(Monkey monkey);
	
	void visitLion(Lion lion);
	
	void visitDolphin(Dolphin dolphin);
}
