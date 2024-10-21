package com.kh.iclinic.common.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginItercepter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getSession().getAttribute("user") != null) {
			return true;
		} else {
			response.sendRedirect(request.getContextPath());
			return false;
		}
	}
	
	
	
}
