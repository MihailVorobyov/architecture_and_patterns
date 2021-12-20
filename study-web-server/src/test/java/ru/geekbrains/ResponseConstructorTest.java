package ru.geekbrains;

import org.junit.Assert;
import org.junit.Test;
import ru.geekbrains.domain.Cookie;
import ru.geekbrains.utils.HttpResponseCodes;

import java.util.ArrayList;
import java.util.List;

public class ResponseConstructorTest {
	
	List<Cookie> cookies = null;
	List<Cookie> cookies1 = new ArrayList<>();
	
	
	@Test
	public void shouldReturn404() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("HTTP/1.1 404 NOT_FOUND\n");
		sb.append("Content-Type: text/html; charset=utf-8\n");
		sb.append("\n");
		sb.append("<h1>Файл не найден!</h1>");
		
		HttpResponseCodes code = HttpResponseCodes.NOT_FOUND;
		Assert.assertEquals(sb.toString(), ResponseConstructor.constructResponse(code, cookies).toString());
	}
	
	@Test
	public void shouldReturn405() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("HTTP/1.1 405 METHOD_NOT_ALLOWED\n");
		sb.append("Content-Type: text/html; charset=utf-8\n");
		sb.append("\n");
		sb.append("<h1>Метод не поддерживается!</h1>");
		
		HttpResponseCodes code = HttpResponseCodes.METHOD_NOT_ALLOWED;
		Assert.assertEquals(sb.toString(), ResponseConstructor.constructResponse(code, cookies).toString());
	}
	
	@Test
	public void shouldReturn200() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("HTTP/1.1 200 OK\n");
		sb.append("Content-Type: text/html; charset=utf-8\n");
		sb.append("\n");
		
		HttpResponseCodes code = HttpResponseCodes.OK;
		Assert.assertEquals(sb.toString(), ResponseConstructor.constructResponse(code, cookies).toString());
	}
	
	@Test
	public void shouldPrintCookieWithNameTestCookie() {
		
		String cookieName = "test-cookie";
		String cookieValue = "123456!@#";
		
		cookies1.add(new Cookie.Builder()
			.withName(cookieName)
			.withValue(cookieValue)
			.build()
		);
		
		StringBuilder sb = new StringBuilder();
		sb.append("HTTP/1.1 200 OK\n");
		sb.append("Content-Type: text/html; charset=utf-8\n");
		sb.append("Set-Cookie: test-cookie=123456!@#\n");
		sb.append("\n");
		
		HttpResponseCodes code = HttpResponseCodes.OK;
		Assert.assertEquals(sb.toString(), ResponseConstructor.constructResponse(code, cookies1).toString());
	}

}
