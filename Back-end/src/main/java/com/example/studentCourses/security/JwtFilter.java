package com.example.studentCourses.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain) throws ServletException,IOException{
		String authHeader = request.getHeader("Authorization");
		String token = null;
		try {
			if(authHeader != null && authHeader.startsWith("Bearer ")) {
				token = authHeader.substring(7);
				Claims claims = jwtUtil.extractAllClaims(token);
				
				request.setAttribute("role", claims.get("role", String.class));
				request.setAttribute("email",claims.get("email", String.class));
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid or expired JWT Token");
            return;
		}
		
		filterChain.doFilter(request, response);
	}
	
}
