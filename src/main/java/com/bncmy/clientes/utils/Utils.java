package com.bncmy.clientes.utils;

import java.util.Map;

import com.google.gson.JsonObject;

public class Utils {
	
	public static JsonObject getJsonObject(Map<String, Object> map) throws Exception {
	    JsonObject jsonObject = new JsonObject();
	    try {
	        for (Map.Entry<String, Object> entry : map.entrySet()) {
	            String key = entry.getKey().toLowerCase();
	            Object value = entry.getValue();

	            if (value instanceof Number) {
	                jsonObject.addProperty(key, (Number) value);
	            } else if (value instanceof String) {
	                jsonObject.addProperty(key, (String) value);
	            } else {
	                jsonObject.addProperty(key, value != null ? value.toString() : "");
	            }
	        }
	        return jsonObject;
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        throw new Exception(ex);
	    }
	}

}
