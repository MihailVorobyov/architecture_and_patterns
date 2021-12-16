package ru.geekbrains;

import ru.geekbrains.domain.Cookie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseConstructor {
	
	private static StringBuilder response;
	private static final Map<Integer, String> responseCodes;
	
	static {
		responseCodes = new HashMap<>();
		responseCodes.put(200, "OK");
		responseCodes.put(404, "NOT_FOUND");
		responseCodes.put(405, "METHOD_NOT_ALLOWED");
	}
	
	public static StringBuilder constructResponse(int code, List<Cookie> cookies) {
		
		response = new StringBuilder();
		
		response.append(String.format("HTTP/1.1 %d %s\n", code, responseCodes.get(code)));
		response.append("Content-Type: text/html; charset=utf-8\n");
		
		if (cookies != null) {
			response.append(CookiesService.addCookies(cookies));
		}
		
		response.append("\n");

		
		switch (code) {
			case 404 -> {
				response.append("<h1>Файл не найден!</h1>");
			}
			case 200 -> {
			}
			case 405 -> {
				response.append("<h1>Метод не поддерживается!</h1>");
			}
		}
		return response;
	}
}
