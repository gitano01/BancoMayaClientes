package com.bncmy.clientes.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import io.fusionauth.jwt.Verifier;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACVerifier;

@Component
public class InterceptorJwtIO implements HandlerInterceptor {
	
	 @Value("${secretKey}")
	    private  String secretKey;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean validate = false;
		String uri = request.getRequestURI();

		System.out.println("Ruta entrante: " + uri);
		// Permitir acceso a Swagger
		if (uri.startsWith("/v2/api-docs") 	|| uri.equals("/swagger-ui.html")) {
			return true; // Permitir acceso sin autenticación
		}

		// Validar si la ruta es una de las protegidas
		if (!validate && request.getHeader("Authorization")!=null && !request.getHeader("Authorization").isEmpty()) {
			String token = request.getHeader("Authorization").toString();

			if (token != null && !token.isEmpty()) {
				// Validar el token (suponiendo que el formato es "Bearer <token>")
				String encodedToken = token.replace("Bearer ", "");
				System.out.println("token ==== >" + encodedToken);
				try {
					
					System.out.println(secretKey);
					validate = !validateToken(encodedToken, secretKey); // Cambia "tu_secret_key" por tu clave
																				// real
				} catch (Exception e) {
					e.printStackTrace();
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido");
					return false;
				}
			} else {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token requerido");
				return false;
			}
		}

		if (!validate) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return validate;
	}

	public boolean validateToken(String encode, String secretKey) throws Exception {
		JWT jwt = jwt(encode, secretKey);
		return jwt.isExpired();
	}

	private JWT jwt(String encodedJWT, String secretKey) throws Exception {
		Verifier verifier = HMACVerifier.newVerifier(secretKey);
		JWT jwt = JWT.getDecoder().decode(encodedJWT, verifier);
		return jwt;
	}
}
