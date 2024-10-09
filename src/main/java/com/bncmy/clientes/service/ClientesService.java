package com.bncmy.clientes.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bncmy.clientes.model.ApiRequest;
import com.bncmy.clientes.model.dto.ClienteDto;
import com.bncmy.clientes.repository.ClientesRepositoryInterface;
import com.bncmy.clientes.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service
public class ClientesService {

	
	@Autowired
	private ClientesRepositoryInterface repo_Clientes;
	
	public Object obtieneCliente(Long id) throws Exception {
				
		 
		try {
			Map<String, Object> mapita = repo_Clientes.findClienteById(id);
			if(mapita.size() > 0) {				
				JsonObject jo = Utils.getJsonObject(mapita);				
				ClienteDto cliente = new Gson().fromJson(jo.toString(), ClienteDto.class);	
				return cliente;				
			}else{
				Map<String,Object> mapJson = new HashMap<String,Object>();
				mapJson.put("mensaje","No se encontraron registros");
				return mapJson;
			}

		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}		
	}
	
	public Object obtieneClientes() throws Exception {
		
		try {
		List<Map<String,Object>> list = repo_Clientes.findClientes(); 
		List<ClienteDto> data = new ArrayList<ClienteDto>();
		if(list.size()>0) {
				
			for(Map<String ,Object > p : list) {
				JsonObject jo = Utils.getJsonObject(p);
				ClienteDto cliente = new Gson().fromJson(jo.toString(), ClienteDto.class);
				data.add(cliente);
			}			
			return data;
			
		}else{
			Map<String,Object> mapJson = new HashMap<String,Object>();
			mapJson.put("mensaje","No se encontraron registros");
			return mapJson;
		}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}	

	public String crearCliente(ApiRequest request) throws Exception{
		try {
		JsonObject json = new Gson().toJsonTree(request).getAsJsonObject();
		System.out.println("linea 33: " + json.toString());
		return repo_Clientes.createCliente(json.toString());
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
}
