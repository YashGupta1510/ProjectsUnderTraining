package com.nagarro.exittestapi.model;

public class Response {


	private Object data;
	private String message;
	private boolean success;
	
	public Response() {
		this.data = null;
		this.message = "Failed";
		this.success = false;
	}

	public Object getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public boolean isSuccess() {
		return success;
	}

	public Response(Object data) {
		super();
		this.data = data;
		this.message = "Success";
		this.success = true;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
