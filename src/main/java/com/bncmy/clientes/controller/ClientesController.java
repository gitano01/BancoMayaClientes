package com.bncmy.clientes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bncmy.clientes.model.ApiRequest;
import com.bncmy.clientes.model.dto.SwaggerDto.Error400;
import com.bncmy.clientes.model.dto.SwaggerDto.Error401;
import com.bncmy.clientes.model.dto.SwaggerDto.Error404;
import com.bncmy.clientes.model.dto.SwaggerDto.Error500;
import com.bncmy.clientes.service.ClientesService;
import com.bncmy.clientes.utils.ConstantesJwt;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping(value="/api")
public class ClientesController {

	@Autowired
	ClientesService serv;
	
	
	@ApiResponses(value= {
			
			@ApiResponse(code = ConstantesJwt.Codes.BAD_REQUEST, message = ConstantesJwt.Swagger.BAD_REQUEST,response=Error400.class),
			@ApiResponse(code = ConstantesJwt.Codes.UNAUTHORIZED, message = ConstantesJwt.Swagger.UNAUTHORIZED,response=Error401.class),
			@ApiResponse(code = ConstantesJwt.Codes.NOT_FOUND, message = ConstantesJwt.Swagger.NOT_FOUND,response=Error404.class),
			@ApiResponse(code = ConstantesJwt.Codes.INTERNAL_ERROR, message = ConstantesJwt.Swagger.INTERNAL_ERROR,response=Error500.class) 
	})
	@ApiOperation(value= ConstantesJwt.Swagger.CONTROLLER_DESCRIPTION, authorizations = { @Authorization(value="basicAuth") })
	@GetMapping("/clientes")
	public ResponseEntity<?> getClientes() throws Exception{
		return new ResponseEntity<>(serv.obtieneClientes(),HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			
			@ApiResponse(code = ConstantesJwt.Codes.BAD_REQUEST, message = ConstantesJwt.Swagger.BAD_REQUEST,response=Error400.class),
			@ApiResponse(code = ConstantesJwt.Codes.UNAUTHORIZED, message = ConstantesJwt.Swagger.UNAUTHORIZED,response=Error401.class),
			@ApiResponse(code = ConstantesJwt.Codes.NOT_FOUND, message = ConstantesJwt.Swagger.NOT_FOUND,response=Error404.class),
			@ApiResponse(code = ConstantesJwt.Codes.INTERNAL_ERROR, message = ConstantesJwt.Swagger.INTERNAL_ERROR,response=Error500.class) 
	})
	@ApiOperation(value= ConstantesJwt.Swagger.CONTROLLER_DESCRIPTION, authorizations = { @Authorization(value="basicAuth") })
	@GetMapping("/clientes/{id}")
    public ResponseEntity<?> getCliente(@PathVariable("id") String id) throws Exception{
		return new ResponseEntity<>(serv.obtieneCliente(Long.parseLong(id)),HttpStatus.OK);
	}

	@ApiResponses(value= {
			
			@ApiResponse(code = ConstantesJwt.Codes.BAD_REQUEST, message = ConstantesJwt.Swagger.BAD_REQUEST,response=Error400.class),
			@ApiResponse(code = ConstantesJwt.Codes.UNAUTHORIZED, message = ConstantesJwt.Swagger.UNAUTHORIZED,response=Error401.class),
			@ApiResponse(code = ConstantesJwt.Codes.NOT_FOUND, message = ConstantesJwt.Swagger.NOT_FOUND,response=Error404.class),
			@ApiResponse(code = ConstantesJwt.Codes.INTERNAL_ERROR, message = ConstantesJwt.Swagger.INTERNAL_ERROR,response=Error500.class) 
	})
	@ApiOperation(value= ConstantesJwt.Swagger.CONTROLLER_DESCRIPTION, authorizations = { @Authorization(value="basicAuth") })
	@PostMapping(value = "/clientes")
	public ResponseEntity<?> addClientes(@RequestBody ApiRequest request) throws Exception{
		return new ResponseEntity<>(serv.crearCliente(request),HttpStatus.OK);
	}


}
