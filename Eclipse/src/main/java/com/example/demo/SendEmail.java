package com.example.demo;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class SendEmail {
	 public static void sendemail() {

	        final String username = "rllshivani@gmail.com";
	        final String password = "shivani@rll";
	        Properties prop = new Properties();
	        prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("boojaamurugeshkumar@gmail.com"));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse("boojaamurugeshkumar@gmail.com, bidhusha7@gmail.com")
	            );
	            message.setSubject("ORDER PLACED");
	            message.setText("your order is,"
	                    + "\n\n Successfully placed...!");

	            Transport.send(message);

	            System.out.println("Done");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	           
	   }
	    }
	    
	    public static void sendemail1() {

	        final String username = "rllshivani@gmail.com";
	        final String password = "shivani@rll";
	        Properties prop = new Properties();
	        prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("boojaamurugeshkumar@gmail.com"));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse("boojaamurugeshkumar@gmail.com, bidhusha7@gmail.com")
	            );
	            message.setSubject("ACCOUNT CREATED");
	            message.setText("Account is created succesfully,"
	                    + "\n\n login to ur account to place your first order...!");

	            Transport.send(message);

	            System.out.println("Done");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	           
	   }
	    }
	    public static void sendemail2() {

	        final String username = "rllshivani@gmail.com";
	        final String password = "shivani@rll";
	        Properties prop = new Properties();
	        prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("boojaamurugeshkumar@gmail.com"));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse("boojaamurugeshkumar@gmail.com, bidhusha7@gmail.com")
	            );
	            message.setSubject("ACCOUNT CREATED");
	            message.setText("Account is created succesfully,"
	                    + "\n\n login to ur account to deliver your first order...!");

	            Transport.send(message);

	            System.out.println("Done");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	           
	   }
	    }
}
