package ru.geekbrains.handler;

import ru.geekbrains.ResponseSerializer;
import ru.geekbrains.SocketService;
import ru.geekbrains.config.Config;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.utils.HttpResponseCodes;

@Handler(order = 1, method = "POST")
public class PostMethodHandler extends MethodHandler {
	
	public PostMethodHandler(String method,
	                         MethodHandler next,
	                         SocketService socketService,
	                         ResponseSerializer responseSerializer,
	                         Config config) {
		super(method, next, socketService, responseSerializer, config);
	}
	
	@Override
	protected HttpResponse handleInternal(HttpRequest request) {
		return HttpResponse.getBuilder()
			.withHttpResponseCode(HttpResponseCodes.OK)
			.build();
	}
}
