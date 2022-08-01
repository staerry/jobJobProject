package com.jj.admin.model.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.jj.mtm.model.vo.Mtm;

public class SendMail {

	public void sendMail(String mtmAnswer, Mtm userEmail) {
//		SMTP 서버명
		String host = "smtp.naver.com"; 
		
//		발신자 이메일
		final String user = "gjswns21@naver.com";
		
//		발신자 비밀번호
		final String password = "네이버 비번";
		
//		수신자 이메일
		String to = userEmail.getUserNo();
		
		
//		세션 객체
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		
//		메일작성
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

//			메일 제목
			message.setSubject("[니JOB 내JOB] 운영자 답변 입니다.");

//			내용
			message.setText(mtmAnswer);


			Transport.send(message);
			
//			전송 확인용
			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
