package com.example.springboot;

public class ErrorMessage {

	private String errorMessage;
	private String requestedURI;
	
	
	
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(String errorMessage, String requestedURI) {
		super();
		this.errorMessage = errorMessage;
		this.requestedURI = requestedURI;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getRequestedURI() {
		return requestedURI;
	}
	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}

	public void callerURL(final String requestedURI) {
		this.requestedURI = requestedURI;
	}
	
	
}
