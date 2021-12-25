package ru.geekbrains.handler;

import ru.geekbrains.ResponseSerializer;
import ru.geekbrains.SocketService;
import ru.geekbrains.config.Config;

public class MethodHandlerFactory {
	
	public static MethodHandler create(SocketService socketService, ResponseSerializer responseSerializer, Config config) {
		PutMethodHandler putHandler = new PutMethodHandler("PUT", null, socketService, responseSerializer, config);
		PostMethodHandler postHandler = new PostMethodHandler("POST", putHandler, socketService, responseSerializer, config);
		return new GetMethodHandler("GET", postHandler, socketService, responseSerializer, config);
	}
}
