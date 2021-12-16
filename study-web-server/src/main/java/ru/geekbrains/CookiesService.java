package ru.geekbrains;

import ru.geekbrains.domain.Cookie;
import ru.geekbrains.domain.HttpRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikhail Vorobev
 */

public class CookiesService {
	
	public static List<Cookie> getCookies(HttpRequest httpRequest) {

		String cookiesInRequest = httpRequest.getHeaders().get("cookie");

		String[] cookies = cookiesInRequest.split("; ");

		List<Cookie> result = new ArrayList<>();

		for (String s : cookies) {

			String[] nameValuePair = s.split("=");
			result.add(new Cookie.Builder()
					.withName(nameValuePair[0])
					.withValue(nameValuePair[1])
					.build()
				);
		}
		
		return result;
	}
	
	public static String addCookies(List<Cookie> cookies) {
		
		StringBuilder builder = new StringBuilder();
		
		cookies.forEach(cookie -> {
			builder.append("Set-Cookie: " + cookie + "\n");
		});
		
		return builder.toString();
	}
}
