package com.bncmy.clientes.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ApiResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object resp;

	public ApiResponse(Object resp){
		this.resp=resp;
	}
}
