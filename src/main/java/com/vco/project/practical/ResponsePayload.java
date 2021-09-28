package com.vco.project.practical;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePayload {
	
	private int statusCode;
	public ResponsePayload(int statusCode, String message, Object obj) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.obj = obj;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	private String message;
	private Object obj;
}
