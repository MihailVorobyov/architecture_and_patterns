package ru.geekbrains;

import ru.geekbrains.config.Config;
import ru.geekbrains.domain.Cookie;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.utils.HttpResponseCodes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;
    private final RequestParser requestParser;
    private final Config config;
    private final FileReader reader = new FileReader();
    
    public RequestHandler(SocketService socketService, RequestParser requestParser, Config config) {
        this.socketService = socketService;
        this.requestParser = requestParser;
        this.config = config;
    }

    @Override
    public void run() {
        
        // ========== Get a request ==========
        
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parseRequest(rawRequest);
    
        // ========== Send a response ==========
        
        HttpResponse response;
        String body = "";
        if(httpRequest.getHeaders().containsKey("cookie") && httpRequest.getHeaders().get("cookie").contains("session=")) {
        
        }
        Cookie session = Cookie.getBuilder()
                .withName("session")
                .withValue("QWERTY123")
                .withPath(httpRequest.getUrl())
                .withExpires(0, 1, 0, 0, 0, 0)
                .withHttpOnly()
                .build();
        
        if (httpRequest.getMethod().equals("GET")) {
            Path path = Paths.get(config.getWwwHome(), httpRequest.getUrl());

            if (!Files.exists(path)) {
                response = HttpResponse.getBuilder()
                    .withHttpResponseCode(HttpResponseCodes.NOT_FOUND)
                    .withHeader(session)
                    .build();
                socketService.writeResponse(response);
                return;
            }
    
            response = HttpResponse.getBuilder()
                .withHttpResponseCode(HttpResponseCodes.OK)
                .withBody(reader.readFile(path))
                .build();
            socketService.writeResponse(response);
        } else {
            response = HttpResponse.getBuilder()
                .withHttpResponseCode(HttpResponseCodes.METHOD_NOT_ALLOWED)
                .build();
            socketService.writeResponse(response);
            return;
        }
        try {
            socketService.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("Client disconnected!");
    }
}