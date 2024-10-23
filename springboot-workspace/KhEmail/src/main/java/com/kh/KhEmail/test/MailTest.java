package com.kh.KhEmail.test;

import java.io.File;
import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public class MailTest {

	/*
	 * 이메일 관련 프로토콜
	 * 
	 * *SMTP
	 * : 이메일 전송시 사용되는 프로토콜
	 * 
	 * *POP
	 * :이메일 서버에 도착한 메일을 클라이언트로 가지고 올때ㅔ 사용되는 프로토콜
	 * 
	 *  *IMAP
	 *  :이메일 서버에 직접 접속하여 메일을 확인할 때 사용되는 프로토콜
	 *  =>Gmail 서버(smtp) 사용 시 활성화 필요  
	 */
	
	public static void main(String[] args) throws Exception {
		System.out.println("-------------------------");
		//JavaMailSenderImpl 객체 사용 => org.springframework.mail(boot start mail 의존성 추가)
		
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		// 메일 서버 관련 설정
		
		sender.setHost("smtp.gmail.com");           //-smtp 서버 주소
		sender.setPort(587);                        //-포트
	    sender.setUsername("wontak9@gmail.com");	//-인증받은 사용자 이메일
		sender.setPassword("");                     //-앱 인증번호
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);            //smtp 서버 연결 시 사용자 인증 설정
		prop.put("mail.smtp.starttls.enable", true); //smtp연결 시 tls 암호화 설정
		sender.setJavaMailProperties(prop);          //부가적인 설정들
		//------------------------------------
		
		//메일 전송 준비
		MimeMessage mm = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mm, true, "UTF-8");
		                          //MimeMessageHelper 객체,  MULTIPART(첨부파일)포함유무, 인코딩

	   helper.setSubject("[KH] 메일 테스트");        //메일 제목
	   helper.setText("메일이 전송이 될까 안될까");     // 메일 내용
	   helper.setFrom("wontak9@gmail.com", "[KH] 메일 전송"); // 발신자(이메일, 별칭) 
	   helper.setTo("wontak9@gmail.com");//수신자
	
	   //파일첨부
	   File f = new File(MailTest.class.getResource("/static/image/test.jpg").getPath());
	   helper.addAttachment("test.jpg", f);
	
	   sender.send(mm);
	   
	   System.out.println("--------------------end---------------------");
	}
	   //메일 전송
	
}












