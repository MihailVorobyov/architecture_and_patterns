package ru.geekbrains.domain;

import org.junit.Assert;
import org.junit.Test;
import ru.geekbrains.utils.SameSite;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Mikhail Vorobev
 */

public class CookieTest {
	
	Cookie correctCookie = new Cookie.Builder()
		.withName("cookieName55")
		.withValue("0123456789abcACB!#$%&'()*+-./:<=>?@[]^_`{|}~")
		.withExpires(0, 0, 0, 0, 30, 0)
		.withDomain("test.ru")
		.withSecure()
		.withHttpOnly()
		.withSameSite(SameSite.NONE)
		.build();
	
	@Test
	public void shouldReturnCorrectCookieName() {
		
		System.out.println(correctCookie);
		Assert.assertEquals("cookieName55", correctCookie.getName());
	}
	
	@Test
	public void shouldReturnCorrectCookieValue() {
		
		Assert.assertEquals("0123456789abcACB!#$%&'()*+-./:<=>?@[]^_`{|}~", correctCookie.getValue());
	}
	
	@Test
	public void shouldReturnCorrectCookieExpires() {
		
		SimpleDateFormat f = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
		
		String time = f.format(System.currentTimeMillis());
		System.out.println(time);
		
		Assert.assertTrue(correctCookie.getExpires().startsWith(time.substring(0,15)));
	}
	
	@Test
	public void shouldReturnCorrectCookieDomain() {

		Assert.assertEquals("test.ru", correctCookie.getDomain());
	}
	
	@Test
	public void shouldReturnTrueWhenSecureIsSet() {
		
		Assert.assertTrue(correctCookie.getSecure());
	}
	
	@Test
	public void shouldReturnTrueWhenHttpOnlyIsSet() {
		
		Assert.assertTrue(correctCookie.getHttpOnly());
	}
}
