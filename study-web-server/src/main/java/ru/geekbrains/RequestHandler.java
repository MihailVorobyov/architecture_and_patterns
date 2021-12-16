package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Deque;

import static ru.geekbrains.Config.WWW;

public class RequestHandler implements Runnable {

    private final SocketService socketService;
    private final RequestParser requestParser;
    private final FileReader reader = new FileReader();
    
    public RequestHandler(SocketService socketService, RequestParser requestParser) {
        this.socketService = socketService;
        this.requestParser = requestParser;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parseRequest(rawRequest);
    
        StringBuilder response;
        if (httpRequest.getMethod().equals("GET")) {
            Path path = Paths.get(WWW, httpRequest.getUrl());

            if (!Files.exists(path)) {
                response = ResponseConstructor.constructResponse(404, null);
                socketService.writeResponse(response.toString());
                return;
            }
    
            response = ResponseConstructor.constructResponse(200, null);
            response.append(reader.readFile(path));
            
            socketService.writeResponse(response.toString());
        } else {
            response = ResponseConstructor.constructResponse(405, null);
            socketService.writeResponse(response.toString());
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
