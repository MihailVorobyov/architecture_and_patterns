package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;

public interface RequestParser {
	
	HttpRequest parseRequest(Deque<String> rawRequest);
}
