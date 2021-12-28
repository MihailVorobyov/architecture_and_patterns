package ru.geekbrains.domain;

import ru.geekbrains.utils.HttpResponseCodes;

import java.util.ArrayList;
import java.util.List;

public class HttpResponse {
	
	private final String HTTP_VERSION = "HTTP/1.1";
	private HttpResponseCodes code;
	private final List<HttpResponseHeader> headers;
	private String body;
	
	private HttpResponse() {
		this.headers = new ArrayList<>();
	}
	
	public String getHttpVersion() {
		return HTTP_VERSION;
	}
	
	public HttpResponseCodes getCode() {
		return code;
	}
	
	public List<HttpResponseHeader> getHeaders() {
		return headers;
	}
	
	public String getBody() {
		return body;
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
	
	public static class Builder {
		
		private final HttpResponse httpResponse;
		
		private Builder() {
			httpResponse = new HttpResponse();
		}
		
		public Builder withHttpResponseCode(HttpResponseCodes code) {
			this.httpResponse.code = code;
			return this;
		}
		
		public Builder withHeader(HttpResponseHeader header) {
			this.httpResponse.headers.add(header);
			return this;
		}
		
		public Builder withBody(String body) {
			this.httpResponse.body = body;
			return this;
		}
		
		public HttpResponse build() {
			if (this.httpResponse.code == null) {
				throw new IllegalStateException("Wrong HttpResponse parameters!");
			}
			return this.httpResponse;
		}
	}
}
