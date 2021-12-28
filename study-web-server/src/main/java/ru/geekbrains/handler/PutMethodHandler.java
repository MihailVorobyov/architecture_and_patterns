package ru.geekbrains.handler;

import ru.geekbrains.FileReader;
import ru.geekbrains.ResponseSerializer;
import ru.geekbrains.SocketService;
import ru.geekbrains.config.Config;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.utils.HttpResponseCodes;

@Handler(order = 2, method = "PUT")
public class PutMethodHandler extends MethodHandler {
	
	private final FileReader reader = new FileReader();
	
	public PutMethodHandler(String method,
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
			.withBody("<h1>PUT method handler</h1>")
			.build();
	}
}
