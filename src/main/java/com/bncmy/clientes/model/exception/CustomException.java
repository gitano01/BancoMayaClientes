package com.bncmy.clientes.model.exception;

import java.io.Serializable;


public class CustomException extends Exception implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	 private String path;
	    private String message;
	    private String timestamp;

	    public CustomException(String path, String message, String timestamp) {
	        super(message);
	        this.path = path;
	        this.message = message;
	        this.timestamp = timestamp;
	    }

	    public String getPath() {
	        return path;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public String getTimestamp() {
	        return timestamp;
	    }
	
}
