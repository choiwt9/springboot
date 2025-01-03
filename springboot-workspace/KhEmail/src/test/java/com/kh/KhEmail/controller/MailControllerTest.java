package com.kh.KhEmail.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.kh.KhEmail.service.MailService;

//@WebMvcTest : 테스트 시 사용되는 어노테이션
@WebMvcTest(MailController.class)
public class MailControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	//=> Spring MVC 컨트롤러 테스트를 위한 클래스 (http 요청 시뮬/응답 검증)
    @MockBean
    private MailService mService;
    //=> 테스트용으로 만들어서 사용. 실제로 동작되지는 않고 동작되는 것처럼 처리됨
    
    @Test  //테스트용 메소드
    void authMailTest() throws Exception {
    	
    	mockMvc.perform(
    			post("/mail")
    			.contentType(MediaType.APPLICATION_JSON)
    			.content("{\"email\":\"wontak9@gmail.com\"}")
    			)
    	.andExpect(status().isOk());
    }
    @Test
    void codeCheckTest() throws Exception {
    	mockMvc.perform(
    			post("/check")
    			.contentType(MediaType.APPLICATION_JSON)
    			.content("{\"email\":\"wontak9@gmail.com\", \"code\": \"1q2w3e\"}")
    			)
    	        .andExpect(status().isOk());
    }
    
    
}
