/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package provaenviaremails.provaenviaremails;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ernes
 */
public class ProvaEnviarEmails {

    public static void main(String[] args) {

        enviarMail("ernestvilacasas@gmail.com", "ernest.vila@cirvianum.cat", "bgnnzryptihspnbk", "Subjecte de Prova", "Cos del missatge");
    }

    private static void enviarMail(String mailFrom, String mailTo, String appPasswd, String subject, String body) {
        // Recipient's email ID needs to be mentioned.
        String to = mailTo;

        // Sender's email ID needs to be mentioned
        String from = mailFrom;

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(mailFrom, appPasswd);

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(body);

            System.out.println("Enviant...");
            // Send message
            Transport.send(message);
            System.out.println("Missatge enviat correctament...");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
