package ru.geekbrains;

import ru.geekbrains.config.Config;
import ru.geekbrains.config.ConfigFactory;
import ru.geekbrains.handler.MethodHandlerFactory;
import ru.geekbrains.handler.RequestHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) {
    
        Config config = ConfigFactory.create(args);
        
        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            System.out.println("Server started!");
            RequestParser requestParser = RequestParserFactory.createRequestParser();

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");
    
                SocketService socketService = SocketServiceFactory.createSocketService(socket);
                ResponseSerializer responseSerializer = ResponseSerializerFactory.createResponseSerializer();
                
                new Thread(new RequestHandler(
                    socketService,
                    requestParser,
                    MethodHandlerFactory.create(socketService, responseSerializer, config))
                ).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
