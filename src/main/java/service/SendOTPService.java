package service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendOTPService {

    public static void sendOTP(String email, String genOTP) {

        String from = "bhavaniputtaraj12@gmail.com";
        String password = "yqmtguorrhrxwgap"; // Replace with your Gmail password

        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

            // Set the sender address
            message.setFrom(new InternetAddress(from));

            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

            // Set the email subject
            message.setSubject("Your OTP Code");

            // Set the email content
            message.setText("Your OTP code is: " + genOTP);

            // Send the email
            Transport.send(message);

            System.out.println("OTP sent successfully to " + email);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Error sending OTP: " + e.getMessage());
        }
    }
}
