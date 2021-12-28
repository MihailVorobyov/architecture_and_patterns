package ru.geekbrains.handler;

import ru.geekbrains.FileReader;
import ru.geekbrains.ResponseSerializer;
import ru.geekbrains.SocketService;
import ru.geekbrains.config.Config;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.utils.HttpResponseCodes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Handler(order = 0, method = "GET")
public class GetMethodHandler extends MethodHandler {
	
	private final FileReader reader = new FileReader();
	
	public GetMethodHandler(String method,
	                        MethodHandler next,
	                        SocketService socketService,
	                        ResponseSerializer responseSerializer,
	                        Config config) {
		super(method, next, socketService, responseSerializer, config);
	}
	
	@Override
	protected HttpResponse handleInternal(HttpRequest request) {
		Path path = Paths.get(config.getWwwHome(), request.getUrl());
		HttpResponse response;
		
		if (!Files.exists(path)) {
			return HttpResponse.getBuilder()
				.withHttpResponseCode(HttpResponseCodes.NOT_FOUND)
				.build();
		}
		
		return HttpResponse.getBuilder()
			.withHttpResponseCode(HttpResponseCodes.OK)
			.withBody(reader.readFile(path))
			.build();
	}
}
