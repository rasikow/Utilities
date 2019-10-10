
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.Properties;

public class SendEmailSSL {

    public static void main(String[] args) {

        final String username = "xxxxxxx";
        final String password = "xxxxxxx";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("xxxxx"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("xxxxx")
                    
            );
            
           
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Dear CEO,"
    	            + "\n\n I have  invested in xxxxx"
    	            + "\n\n I have requested payment request on March 21, 28th and April 4 th , it got approved but still amount is not receiced in my bank."
    	            + "\n\n You promised in Tirunelveli meeting that you will reply for personal mail.Please do needful and consider this as high priority."
    	            + "\n\n Here are my ids and Pending Payment Request Details:"
    	            + "\n\n xxxx"
    	            + "\n\n xxxx"
    	            + "\n\n "
    	            + "\n\n Let me know when shall i get back the old Payment Request nd if i withdraw the capital, when i will get back the amount? "
    	            + "\n\n "
    	            + "\n\n Regards"
    	            + "\n\n xxxx");
            
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            
            messageBodyPart = new MimeBodyPart();
            
            // To Attach file
            String filename = "C:\\Users\\rasik\\Desktop\\PaymentRequest.JPG";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("Payment Request Screenshot");
            multipart.addBodyPart(messageBodyPart);
            
          for(int i=0;i<=500;i++) {
	            message.setSubject("From Invester : Pending 3 Payment Request - xxxx & xxxx  ");
	           
	           
	            
	            message.setContent(multipart);
	            
	            
	           
	            Transport.send(message);
	
	            System.out.println("Done");
            }

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}