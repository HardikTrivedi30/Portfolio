package service;

import DBO.MailDBO;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailService {
	
	public void sendEmail(MailDBO mailDBO){
        try {
            String[] recipients = {"sarthi2277@gmail.com"};

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("sarthi.merchant7@gmail.com", "SMerchant@2277");
                }
            });
            
            Message msg = new MimeMessage(session);
            
            InternetAddress addressFrom = new InternetAddress("sarthi.merchant7@gmail.com");
            msg.setFrom(addressFrom);

            InternetAddress[] addressTo = new InternetAddress[recipients.length];
            for (int i = 0; i < recipients.length; i++) {
                addressTo[i] = new InternetAddress(recipients[i]);
            }
            msg.setRecipients(Message.RecipientType.TO, addressTo);
            msg.addHeader("header", "New Inquery for freelancing. (header)");
            msg.setSubject("New inquery for freelancing.");
            String body  = "Hi, \n New inquery is comming for freelancing from portfolio project.\n Details : \n Name : " + mailDBO.getName() + " \n Email : " + mailDBO.getEmail() + " \n Contact : " + mailDBO.getPhone();  
            body = body + "\n\n Message : \n" + mailDBO.getMessageBody();
            msg.setContent(body.toString(), "text/plain");
            msg.saveChanges();
            
            Transport transport = session.getTransport("smtp");
            transport.connect(props.getProperty("mail.smtp.host"), "sarthi.merchant7@gmailcom", "SMerchant@2277");
            transport.send(msg);
            transport.close();
            
            System.out.println("Message sent successfully.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }		
	}

}
