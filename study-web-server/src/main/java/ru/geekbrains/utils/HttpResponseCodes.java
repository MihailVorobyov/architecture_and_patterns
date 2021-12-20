package ru.geekbrains.utils;

public enum HttpResponseCodes {
	
	OK(200){
		@Override
		public String getStatus() {
			return OK.toString();
		}
	},
	NOT_FOUND(404){
		@Override
		public String getStatus() {
			return OK.toString();
		}
	},
	METHOD_NOT_ALLOWED(405){
		@Override
		public String getStatus() {
			return OK.toString();
		}
	};
	
	private final int code;
	
	HttpResponseCodes(int code) {
		this.code = code;
	}
	
	public abstract String getStatus();
	
	public int getCode() {
		return this.code;
	}
}
