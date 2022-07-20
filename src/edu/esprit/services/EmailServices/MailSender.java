/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services.EmailServices;

import edu.esprit.entities.User;
import edu.esprit.services.UserService;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;



/**
 *
 * @author Slimen OUNI
 */
public class MailSender {

    public static String us;
       
    public static void SendVerifMail(String recep, String us) throws MessagingException{
      
        System.out.println("Preparing to send email");
    
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true") ;
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "slimen.ouni@esprit.tn";
        String password = Password.PASSWORD;
        
      Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication (myAccountEmail, password);
            }
            });
        
     Message message = prepareWelcomeMessage(session , myAccountEmail, recep , us);
        Transport.send(message);
        System.out.println("Welcome Email sent successfully");
}
    
    private static Message prepareWelcomeMessage(Session session,String myAccountEmail, String Recep, String us) throws MessagingException{
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(Recep));
            message.setSubject("Welcome to Premia Sports");
            message.setText("Bonjour "+us+",\n" +
"Vous avez créé votre compte avec succès.");
            return message;
        } catch (AddressException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }
    
        public static void SendRandCodeEmail(String recep, String us, User u) throws MessagingException{
            String code;
          
            System.out.println("preparin rand code");      
        RandomCodeGen rcg = new RandomCodeGen();
        code =  rcg.genRandomCode();
        UserService uss = new UserService();
        u.setRandCode(code);
        uss.updateUserCodeAuth(u);
        System.out.println(" rand code is " + code);  
        us = u.getEmail();
        
        System.out.println("Preparing to send email");
    
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true") ;
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "slimen.ouni@esprit.tn";
        String password = Password.PASSWORD;
        
      Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication (myAccountEmail, password);
            }
            });
        
     Message message = RandCodeGenEmail(session , myAccountEmail, recep , us,code );
        Transport.send(message);
        System.out.println("SOS Email sent successfully");
}

    private static Message RandCodeGenEmail(Session session, String myAccountEmail, String Recep, String us, String code) throws MessagingException {
    
        
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(Recep));
            message.setSubject("Premia Sports Password Reset");
            message.setText("Bonjour "+us+",\n" +
"Vous avez demandé la réinitialisation de votre mot de passe, "
                    + "voici votre code de sécutité : "+code
                    + " et vous êtes le bienvenu");
            return message;
        } catch (AddressException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null; 
    }
}
