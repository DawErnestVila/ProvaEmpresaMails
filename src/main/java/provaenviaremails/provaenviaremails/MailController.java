/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author ernest
 */
public class MailController {

    public static void selectUsr(int opcio, String[][] persones) {
        String[] idEnviar = {};
        int continuar, id;
        boolean seguir;
        for (int i = 0; i < persones.length; i++) {
            System.out.printf("%3s.   %-20s\n", persones[i][0], persones[i][1]);
        }
        seguir = false;
        while (!seguir) {
            idEnviar = UtilArrays.ferCreixerArray(idEnviar);
            id = UtilArrays.getPositionbyId(persones);
            idEnviar[idEnviar.length - 1] = String.valueOf(id);
            continuar = ComprovacioInput.llegirInt("Vols seleccionar algun altre destinetari? (1.Si - 0.No)");
            switch (continuar) {
                case 0: //No
                    seguir = true;
                    break;
                case 1: //Si
                    seguir = false;
                    break;
                default:
                    System.out.println("Només pots entrar 1 o 0");
                    seguir = false;
                    break;
            }
        }
        recorrerEnviar(idEnviar, persones, opcio);
    }

    private static void recorrerEnviar(String[] idEnviar, String[][] persones, int opcio) {
        String mailfrom = "ernestvilacasas@gmail.com", appPasswd = "bgnnzryptihspnbk";
        String body = ComprovacioInput.llegirString("Quin és el cos del correu");
        String subjecte = ComprovacioInput.llegirString("Quin és el subjecte del correu");
        for (int i = 0; i < idEnviar.length; i++) {
            enviarMail(mailfrom, persones[Integer.parseInt(idEnviar[i])][2], appPasswd, subjecte, body);
//            System.out.println("MailFrom: " + mailfrom);
//            System.out.println("AppPasswd: " + appPasswd);
//            System.out.println("MailTo: " + persones[Integer.parseInt(idEnviar[i])][2]);
//            System.out.println("Subject: " + subjecte);
//            System.out.println("Body: " + body);
//            System.out.println("\n");
        }
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
