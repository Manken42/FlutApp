/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flutapp;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author azubi02
 */
public class FlutMail {
    public static String nachname;

    public static void email(String recepient) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String email = "fkildan9292@gmail.com";
        String pw = "nadlik4002";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, pw);
            }
        });

        Message message = prepareMessage(session, email, recepient);

        Transport.send(message);
       //System.out.println("Ihre Email wurde erfolgreich versendet");
    }

    private static Message prepareMessage(Session session, String email, String recepient) throws MessagingException, IOException {
        
        createPDF pdff = new createPDF();
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Rechnung");

            // Container der die BodyParts enthält
            Multipart content = new MimeMultipart();

            MimeBodyPart bp = new MimeBodyPart();
            bp.setText("Sehr geehrte/r Frau/Herr" + " " + nachname +","+ '\n' + '\n' +
                    
                    "hiermit erhalten Sie Ihre Rechnung für die Flutopferspende");

            MimeBodyPart pdf = new MimeBodyPart();
            pdf.attachFile("/home/azubi02/NetBeansProjects/FlutApp/Rechnung.pdf");

            content.addBodyPart(bp);
            content.addBodyPart(pdf);

            message.setContent(content);

            return message;
       
        } catch (AddressException ex) {
            java.util.logging.Logger.getLogger(FlutMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    } 
    
    
}
