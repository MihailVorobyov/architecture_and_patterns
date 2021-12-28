package ru.geekbrains.handler;

import ru.geekbrains.RequestParser;
import ru.geekbrains.SocketService;
import ru.geekbrains.domain.HttpRequest;

import java.io.IOException;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;
    private final RequestParser requestParser;
    private MethodHandler methodHandler;
    
    public RequestHandler(SocketService socketService,
                          RequestParser requestParser,
                          MethodHandler methodHandler) {
        this.socketService = socketService;
        this.requestParser = requestParser;
        this.methodHandler = methodHandler;
    }

    @Override
    public void run() {

        // ========== Get a request ==========

        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parseRequest(rawRequest);

        // ========== Send a response ==========
        
        methodHandler.handle(httpRequest);
        
        try {
            socketService.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("Client disconnected!");
    }
}