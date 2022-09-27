package service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
	
public class service {
	
		public void sendMail(String emailid,int num){
			final String username  = "avnidhi4332@gmail.com";
			final String password   = "04042702";
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });
			try 
			{
				Message m= new MimeMessage(session);
				m.setFrom(new InternetAddress(username));
				m.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailid));
				m.setSubject("Forget Password");
				m.setText("enter this OTP to your page : "+num);

				Transport.send(m);
	 
				System.out.println("Done");
	 
			} 
			catch (MessagingException e) 
			{
				throw new RuntimeException(e);
			}		
		}
	}



