package ru.geekbrains;

import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.domain.HttpResponseHeader;
import ru.geekbrains.utils.HttpResponseCodes;

import java.util.List;

public class ResponseSerializerImpl implements ResponseSerializer {
	
	@Override
	public String serialize(HttpResponse httpResponse) {
		
		HttpResponseCodes code = httpResponse.getCode();
		List<HttpResponseHeader> headers = httpResponse.getHeaders();
		String body = httpResponse.getBody();
		
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("HTTP/1.1 %d %s\r\n", code.getCode(), code.getStatus()));
		builder.append("Content-Type: text/html; charset=utf-8\r\n");
		
		if(headers != null) {
			headers.forEach(header -> builder.append(String.format("%s\r\n", header.toString())));
		} else {
			builder.append("header: empty\r\n");
		}
		
		builder.append("\r\n"); // Separate body from headers
		
		if (body != null) {
			builder.append(String.format("%s\r\n", body));
		} else {
			builder.append(String.format("<h1>%s</h1>\r\n", code.getStatus()));
		}
		
		return builder.toString();
	}
}
