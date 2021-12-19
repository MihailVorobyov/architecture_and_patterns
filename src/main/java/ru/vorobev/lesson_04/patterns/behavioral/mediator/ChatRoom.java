package ru.vorobev.lesson_04.patterns.behavioral.mediator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatRoom implements ChatRoomMediator {
	
	@Override
	public void showMessage(User user, String message) {
		String time = DateTimeFormatter.ofPattern("M d, y H:m").format(LocalDateTime.now());
		String sender = user.getName();
		
		System.out.printf("%s [%s]: %s \n", time, sender, message);
	}
}
