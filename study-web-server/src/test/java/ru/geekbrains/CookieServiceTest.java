package ru.geekbrains;

import org.junit.Assert;
import org.junit.Test;
import ru.geekbrains.domain.Cookie;
import ru.geekbrains.domain.HttpRequest;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mikhail Vorobev
 */

public class CookieServiceTest {
	
	String expected = "6735691016077048a4";
	
	String request = "POST yandex.ru http/1.1\n" +
		"accept: */*\n" +
		"accept-encoding: gzip, deflate, br\n" +
		"accept-language: en-US,en;q=0.9,ru;q=0.8\n" +
		"content-length: 1\n" +
		"content-type: text/plain;charset=UTF-8\n" +
		"cookie: _yasc=TcCBezrrIlXZI3M53vBEo5ET7/wSS9jn5J3LSd7MQCX0fd2U; yandexuid=6735691016077048a4; yuidss=673569101607704844; gdpr=ff; yabs-sid=1737141201626973107\n" +
		"viewport-width: 998\n\n";
	
	@Test
	public void getCookiesTest() {
		
		String[] strings = request.split("\n");
		
		Deque<String> requestDeque = new LinkedList<>(Arrays.asList(strings));
		
		HttpRequest httpRequest = new RequestParser().parseRequest(requestDeque);
		
		List<Cookie> cookies = CookiesService.getCookies(httpRequest);
		
		Assert.assertEquals(expected, cookies.get(1).getValue());
	}
	
	
	
	
}
