package ru.vorobev.lesson_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RequestHandler implements Runnable{
	
	private static String WWW = "src/main/resources/html";
	private Socket socket;
	
	public RequestHandler(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try (BufferedReader input = new BufferedReader(
			new InputStreamReader(
				socket.getInputStream(), StandardCharsets.UTF_8));
		     PrintWriter output = new PrintWriter(socket.getOutputStream())
		) {
			while (!input.ready());
			
			String firstLine = input.readLine();
			String[] parts = firstLine.split(" ");
			System.out.println(firstLine);
			while (input.ready()) {
				System.out.println(input.readLine());
			}
			
			Path path = Paths.get(WWW, parts[1]);
			printDocument(output, path);
			
			System.out.println("Client disconnected!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printDocument(PrintWriter output, Path path) throws IOException {
		if (!Files.exists(path)) {
			output.println("HTTP/1.1 404 NOT_FOUND");
			output.println("Content-Type: text/html; charset=utf-8");
			output.println();
			output.println("<h1>Файл не найден!</h1>");
			output.flush();
			return;
		}
		
		output.println("HTTP/1.1 200 OK");
		output.println("Content-Type: text/html; charset=utf-8");
		output.println();
		
		Files.newBufferedReader(path).transferTo(output);
	}
}
