package ru.geekbrains;

public class ResponseSerializerFactory {
	
	public static ResponseSerializer createResponseSerializer() {
		return new ResponseSerializerImpl();
	}
}