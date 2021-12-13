package ru.geekbrains;

import org.junit.Assert;
import org.junit.Test;

public class ResponseConstructorTest {
	
	@Test
	public void shouldReturn404() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("HTTP/1.1 404 NOT_FOUND\n");
		sb.append("Content-Type: text/html; charset=utf-8\n");
		sb.append("\n");
		sb.append("<h1>Файл не найден!</h1>");
		
		int code = 404;
		Assert.assertEquals(sb.toString(), ResponseConstructor.constructResponse(code).toString());
	}
	
	@Test
	public void shouldReturn405() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("HTTP/1.1 405 METHOD_NOT_ALLOWED\n");
		sb.append("Content-Type: text/html; charset=utf-8\n");
		sb.append("\n");
		sb.append("<h1>Метод не поддерживается!</h1>");
		
		int code = 405;
		Assert.assertEquals(sb.toString(), ResponseConstructor.constructResponse(code).toString());
	}
	
	@Test
	public void shouldReturn200() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("HTTP/1.1 200 OK\n");
		sb.append("Content-Type: text/html; charset=utf-8\n");
		sb.append("\n");
		
		int code = 200;
		Assert.assertEquals(sb.toString(), ResponseConstructor.constructResponse(code).toString());
	}

}
