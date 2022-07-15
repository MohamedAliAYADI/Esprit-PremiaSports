//
//package edu.esprit.utils;
//
//import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
//
//
//public class SMS {
//    
//    public static final String ACCOUNT_SID = "";
//    public static final String AUTH_TOKEN = "";
//
//    public static void SMS(int num,String mess) {
//    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        
//        Message message;
//        message= Message
//                .creator(new PhoneNumber("+216"+num), new PhoneNumber("+"), mess).create();
//                
//    }
//
//    
//}
//
