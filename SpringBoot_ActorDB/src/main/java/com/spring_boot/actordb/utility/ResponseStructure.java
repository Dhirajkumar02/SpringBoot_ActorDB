package com.spring_boot.actordb.utility;

public class ResponseStructure<T> {
	private int status;
	private String message;
	private T data;
	
	
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public T getData() {
		return data;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(T data) {
		this.data = data;
	}



	public static <T> ResponseStructure<T> create(int status, String message, T data) {
		ResponseStructure<T> structure = new ResponseStructure<>();
		structure.setData(data);
		structure.setMessage(message);
		structure.setStatus(status);
		
		return structure;
		
	}
}
