package ru.geekbrains.domain;

import ru.geekbrains.utils.SameSite;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Class responds <a href="https://datatracker.ietf.org/doc/html/rfc6265">RFC 6265</a>
 *
 * @author Mikhail Vorobev
 *
 */

public class Cookie implements HttpResponseHeader {
	
	private String name;
	
	private String value;
	
	private String expires;
	
	private Long maxAge;
	
	private String domain;
	
	private String path;
	
	private boolean secure;
	
	private boolean httpOnly;
	
	private String sameSite;
	
	private Cookie() {
	
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getExpires() {
		return expires;
	}
	
	public Long getMaxAge() {
		return maxAge;
	}
	
	public String getDomain() {
		return domain;
	}
	
	public String getPath() {
		return path;
	}
	
	public boolean getSecure() {
		return secure;
	}
	
	public boolean getHttpOnly() {
		return httpOnly;
	}
	
	public String getSameSite() {
		return sameSite;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Set-Cookie: ");
		sb.append(name + "=" + value);
		
		if (domain != null) {
			sb.append( "; Domain=" + domain);
		}
		if (path != null) {
			sb.append("; Path=" + path);
		}
		if (expires != null) {
			sb.append("; Expires=" + expires);
		}
		if (secure) {
			sb.append("; Secure");
		}
		if (maxAge != null) {
			sb.append("; Max-Age=" + maxAge);
		}
		if (httpOnly) {
			sb.append("; HttpOnly");
		}
		if (sameSite != null) {
			sb.append("; SameSite=" + sameSite);
		}
			
		return sb.toString();
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
	
	public static class Builder {
		
		private final Cookie cookie;
		
		Builder() {
			this.cookie = new Cookie();
		}
		
		public Builder withName(String cookieName) {
			cookie.name = cookieName;
			return this;
		}
		
		public Builder withValue(String cookieValue) {
			cookie.value = cookieValue;
			return this;
		}
		
		public Builder withExpires(int years, int months, int days, int hours, int minutes, int seconds) {
			
			Calendar expires = new GregorianCalendar();
			
			expires.add(Calendar.YEAR, years);
			expires.add(Calendar.MONTH, months);
			expires.add(Calendar.DAY_OF_MONTH, days);
			expires.add(Calendar.HOUR_OF_DAY, hours);
			expires.add(Calendar.MINUTE, minutes);
			expires.add(Calendar.SECOND, seconds);
			
			SimpleDateFormat f = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
			cookie.expires = f.format(expires.getTime());
			return this;
		}
		
		public Builder withMaxAge(long maxAge) {
			cookie.maxAge = maxAge;
			return this;
		}
		
		public Builder withDomain(String domain) {
			cookie.domain = domain;
			return this;
		}
		
		public Builder withPath(String path) {
			cookie.path = path;
			return this;
		}
		
		public Builder withSecure() {
			cookie.secure = true;
			return this;
		}
		
		public Builder withHttpOnly() {
			cookie.httpOnly = true;
			return this;
		}
		
		public Builder withSameSite(SameSite value) {
			cookie.sameSite = value.toString().toLowerCase(Locale.ROOT);
			return this;
		}

		public Cookie build() {
			//TODO release fields validation (new class with patterns)
			
			if (cookie.name == null || cookie.name.isEmpty()) {
				throw new IllegalStateException("Wrong cookie's name!");
			} else  if (cookie.value == null || cookie.value.isEmpty()) {
				throw new IllegalStateException("Wrong cookie's value!");
			}
			
			return cookie;
		}
	}
}