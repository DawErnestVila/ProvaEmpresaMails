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
        boolean seguir, enviar = true, seleccionat = false;
        //Mostrem les persones que hagi seleccionat
        PersonesController.mostrarPersones(persones);
        seguir = false;
        //Comencem el bucle per demanar-li les persones per enviar el correu
        while (!seguir) {
            //Comprovem si l'array on hi han les persones per enviar el correu és més petita que la de persones
            if (idEnviar.length < persones.length) {
                //Si és aixi li demanem que seleccioni una persona
                id = PersonesController.getPositionbyId(persones);
                //Comprovem si aquesta persona ja l'havia seleccionat
                seleccionat = PersonesController.comprovarSeleccionat(idEnviar, id, seleccionat);
                //Comprovem si la id és diferent a -1 (Cancel·lar) i ha seleccionat una persona diferent
                if (id != -1 && !seleccionat) {
                    //Si és aixi fem créixer l'array per enviar els correus
                    idEnviar = UtilArrays.ferCreixerArray(idEnviar);
                    //Li coloquem a la ultima posició la id de la persona seleccionada
                    idEnviar[idEnviar.length - 1] = String.valueOf(id);
                    //Li preguntem si vol afegir alguna altre persona
                    continuar = ComprovacioInput.llegirInt("Vols seleccionar algun altre destinetari? (1.Si - 0.No)");
                    switch (continuar) {
                        case 0: //No
                            seguir = true;
                            enviar = true;
                            break;
                        case 1: //Si
                            seguir = false;
                            break;
                        default:
                            System.out.println("Només pots entrar 1 o 0");
                            seguir = false;
                    }
                } else if (seleccionat) {
                    //Si la id no és -1 pero la persona que ha seleccionat ja està a l'array li diem que ja estava seleccionada
                    System.out.println("\nJa has seleccionat aquesta persona!");
                } else {
                    //Si no és que ha cancel·lat
                    System.out.println("Cancel·lat");
                    enviar = false;
                    break;
                }
            } else {
                //Si arribem aquí és perque ja s'han seleccionat totes les persones
                System.out.println("\nNo pots afegir més persones perquè no en queden més");
                break;
            }
        }
        //Comprovem si el bool per enviar és cert
        if (enviar) {
            //Si ho és cridem a la funció per enviar el correu
            recorrerEnviar(idEnviar, persones);
        }
    }

    private static void recorrerEnviar(String[] idEnviar, String[][] persones) {
        String mailfrom = "emailfrom@gmail.com", appPasswd = "xxxxxxxxxxxxxxxxxxxxxx";
        //Li demanem el cos del correu a l'usuari
        String body = ComprovacioInput.llegirString("Quin és el cos del correu");
        //LI demanem el subjecte del correu a l'usuari
        String subjecte = ComprovacioInput.llegirString("Quin és el subjecte del correu");
        //Fem un bucle recorrent l'array on hi han les id per enviar els correus
        for (int i = 0; i < idEnviar.length; i++) {
            //Cridem a la funció per enviar el correu de la persona amb la id corresponent dins el bucle
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
