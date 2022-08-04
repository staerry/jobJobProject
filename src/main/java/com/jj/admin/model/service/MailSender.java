package com.jj.admin.model.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.jj.mtm.model.vo.Mtm;

public class MailSender {
	public void sendMail(String mtmAnswer, Mtm userEmail) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("gjswns21@gmail.com", "xundsjwmtjoedbos");
			}
		});
		
		String receiver = userEmail.getUserNo(); // 메일 받을 주소
		String title = "니잡내잡 운영자 답변입니다.";
		String content = "<h2 style='color:blue'>" + mtmAnswer + "</h2>";
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("gjswns21@gmail.com", "니잡내잡", "utf-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html; charset=utf-8");

			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}