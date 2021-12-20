package ru.geekbrains;

import ru.geekbrains.domain.Cookie;
import ru.geekbrains.utils.HttpResponseCodes;

import java.util.List;

public class ResponseConstructor {
	
	private static StringBuilder response;
	
	public static StringBuilder constructResponse(HttpResponseCodes code, List<Cookie> cookies) {
		
		response = new StringBuilder();
		
		response.append(String.format("HTTP/1.1 %d %s\n", code.getCode(), code));
		response.append("Content-Type: text/html; charset=utf-8\n");
		
		if (cookies != null) {
			response.append(CookiesService.addCookies(cookies));
		}
		
		response.append("\n");
		
		switch (code) {
			case NOT_FOUND -> {
				response.append("<h1>Файл не найден!</h1>");
			}
			case OK -> {
			
			}
			case METHOD_NOT_ALLOWED -> {
				response.append("<h1>Метод не поддерживается!</h1>");
			}
		}
		return response;
	}
}
