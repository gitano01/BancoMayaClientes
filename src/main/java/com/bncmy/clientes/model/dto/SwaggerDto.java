package com.bncmy.clientes.model.dto;



import com.bncmy.clientes.utils.ConstantesJwt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class SwaggerDto {
	
	@ApiModel(description="Resultado del cliente")
	public class ClienteDto {
		 private String apellido_mat;
		    private String cod_postal;
		    private int domicilioid;
		    private String fecha_mod;
		    private String pais;
		    private String apellido_pat;
		    private String estado;
		    private int clienteid;
		    private String fecha_crea;
		    private String nombre;
		    private String calle;
		    private String delegacion;
		    private boolean estatus;
		    private String colonia;
		    private String ciudad;
		    private int datospersonales_id;
	}
	
	@ApiModel(description="Resultado presentado al usuario en caso de generarse un error de validación")
	public class Error400{
		@ApiModelProperty(notes="Estado de la operación", example="400")
		public int codigo;
		@ApiModelProperty(notes="Mensaje de la operación", example=ConstantesJwt.ApiResponses.FAILURE)
		public String mensaje;
		@ApiModelProperty(notes="Detalle de error en la operación", example= "Describe el valor de error de validación" )
		public String detalle;		
	}
	
	@ApiModel(description="Resultado presentado al usuario en caso de generarse un error de autorización")
	public class Error401{
		@ApiModelProperty(notes="Estado de la operación", example="401")
		public int codigo;
		@ApiModelProperty(notes="Mensaje de la operación", example=ConstantesJwt.ApiResponses.FAILURE)
		public String mensaje;
		@ApiModelProperty(notes="Detalle de error en la operación", example= ConstantesJwt.Swagger.UNAUTHORIZED )
		public String detalle;		
	}
	
	@ApiModel(description="Resultado presentado al usuario en caso de generarse un error sobre el recurso")
	public class Error404{
		@ApiModelProperty(notes="Estado de la operación", example="404")
		public int codigo;
		@ApiModelProperty(notes="Mensaje de la operación", example=ConstantesJwt.ApiResponses.FAILURE)
		public String mensaje;
		@ApiModelProperty(notes="Detalle de error en la operación", example= ConstantesJwt.Swagger.NOT_FOUND )
		public String error;		
	}
	
	@ApiModel(description="Resultado presentado al usuario en caso de generarse un error de validación")
	public class Error500{
		@ApiModelProperty(notes="Estado de la operación", example="500")
		public int codigo;
		@ApiModelProperty(notes="Mensaje de la operación", example=ConstantesJwt.ApiResponses.FAILURE)
		public String mensaje;
		@ApiModelProperty(notes="Detalle de error en la operación", example= ConstantesJwt.Swagger.INTERNAL_ERROR )
		public String detalle;		
	}
}
