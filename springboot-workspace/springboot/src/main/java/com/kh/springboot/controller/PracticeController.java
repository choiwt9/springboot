package com.kh.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class PracticeController {
		
		//practice
		@GetMapping("/practice")
		public String PracticePage(Model m, HttpSession session) {
			
			//request scope에 데이터 저장 => Model
			
			m.addAttribute("name", "최원탁");
			m.addAttribute("gender", "남");
			m.addAttribute("title", "<h3>Hello, thymeleaf</h3>");
			
			//seesion scope 에 데이터 저장 => HttpSession
			
			session.setAttribute("age", 20);
			
			return "practice"; // template/ practice.html
		}
		
		//요청 주소
		@GetMapping("test")
		public String testPage() {
			return "main"; // template/ main.html
		}
	}


