package ru.geekbrains.handler;

import ru.geekbrains.ResponseSerializer;
import ru.geekbrains.SocketService;
import ru.geekbrains.config.Config;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.utils.HttpResponseCodes;

public abstract class MethodHandler {
	
	private final String method;
	private final MethodHandler next;
	protected final ResponseSerializer responseSerializer;
	protected final SocketService socketService;
	protected final Config config;
	
	public MethodHandler(String method,
	                     MethodHandler next,
	                     SocketService socketService,
	                     ResponseSerializer responseSerializer,
	                     Config config) {
		this.method = method;
		this.next = next;
		this.responseSerializer = responseSerializer;
		this.socketService = socketService;
		this.config = config;
	}
	
	public void handle(HttpRequest request) {
		HttpResponse response;
		
		if (method.equals(request.getMethod())) {
			response = handleInternal(request);
		} else if (next != null) {
			next.handle(request);
			return;
		} else {
			response = HttpResponse.getBuilder()
				.withHttpResponseCode(HttpResponseCodes.NOT_FOUND)
				.build();
		}
		String rawResponse = responseSerializer.serialize(response);
		socketService.writeResponse(rawResponse);
	}
	
	protected abstract HttpResponse handleInternal(HttpRequest request);
}
