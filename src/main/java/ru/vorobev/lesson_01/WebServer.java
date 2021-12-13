package ru.vorobev.lesson_01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	
	private static final int PORT = 8080;
	
	public static void main(String[] args) {
		WebServer webServer = new WebServer();
		webServer.start();
	}
	
	private void start() {
		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("Server started!");
			
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("New client connected!");
				RequestHandler requestHandler = new RequestHandler(socket);
				new Thread(requestHandler).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}