package ru.geekbrains.utils;

public enum HttpResponseCodes {
	
	OK(200),
	NOT_FOUND(404),
	METHOD_NOT_ALLOWED(405);
	
	private final int code;
	
	HttpResponseCodes(int code) {
		this.code = code;
	}
	
	public String getStatus() {
		return name();
	}
	
	public int getCode() {
		return code;
	}
}
