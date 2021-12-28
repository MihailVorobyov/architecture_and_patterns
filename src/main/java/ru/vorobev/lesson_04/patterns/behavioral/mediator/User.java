package ru.vorobev.lesson_04.patterns.behavioral.mediator;

public class User {
	
	private String name;
	private ChatRoomMediator chatMediator;
	
	public User(String name, ChatRoomMediator chatMediator) {
		this.name = name;
		this.chatMediator = chatMediator;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void send(String message) {
		chatMediator.showMessage(this, message);
	}
}
