/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.utils;


import co.edu.sena.adsi.jpa.entities.EmailApp;
import co.edu.sena.adsi.jpa.entities.Users;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;




/**
 *
 * @author Cliente Pc
 */
public class SendEmail {
      /**
     * Envia email al usuario en el momento del registro
     * @param configEmail
     * @param users
     * @param passwordAsignada 
     */
    public void sendEmailRegistroUsuario(EmailApp configEmail, Users users, String passwordAsignada) {
 try {

            HtmlEmail email = new HtmlEmail();
            email.setHostName(configEmail.getHostnameEmailApp());
            email.setSmtpPort(configEmail.getSmtpPort());
            email.setAuthenticator(new DefaultAuthenticator(configEmail.getEmailApp(), configEmail.getPasswordEmailApp()));
            if (configEmail.getIsAutentication()) {
                email.setAuthentication(configEmail.getEmailApp(), configEmail.getPasswordEmailApp());
            }
            //email.setSSLOnConnect(configEmail.getIsSsl());
            email.setSSL(configEmail.getIsSsl());
           
            email.setFrom(configEmail.getEmailApp());
            email.setCharset("UTF-8");
            email.setSubject("ACTIVACION DE CUENTA DESARROLLO SGEDI.");

            StringBuilder sb = new StringBuilder();
           /* sb.append("<div style='background:#0079bf;'><h1 style='text-align:center;background:cyan;'>Bienvenido(a) a DESARROLLO SGEDI</h1>");
            sb.append("<h3 style='display:inline-block'>Email: </h3>");
            sb.append(users.getEmail());
            sb.append("    <h3 style='display:inline-block'>Password: </h3>");
            sb.append(passwordAsignada);
            sb.append(" <h3 style='display:inline-block'>Número de Identificación: </h3>");
            sb.append(users.getNumdocument());
            sb.append("    <h3 style='display:inline-block'>Nombres: </h3>");
            sb.append(users.getName());
            sb.append("    <h3 style='display:inline-block'>Apellidos: </h3>");
            sb.append(users.getLastName());
            sb.append("<p>Agradecemos su registro.</p>");*/
           sb.append("<table border=0 cellpadding=0 cellspacing=0 width=100; style=''>");
           sb.append("<tr><td style='padding: 10px 0 30px 0';>");  
           sb.append("<table align=center border=0 cellpadding=0 cellspacing=0 width=600 style='border: 1px solid #cccc; border-collapse: collapse;'>"); 
           sb.append("<tr><td align=center bgcolor=#70bbd9 style='padding: 40px 0 30px 0; color: #153643; font-size: 28px; font-weight: bold; font-family: Arial, sans-serif;'>");  
           sb.append("<img src='images/logotipo.png' alt=Desarrollo SGEDI width=300 height=230 style='display: block;'/>"); 
           sb.append("</td>");
           sb.append("</tr>");
           sb.append("<tr>");
           sb.append("<td bgcolor=#ffffff style='padding: 40px 30px 40px 30px;'>");
           sb.append("<table border= 0 cellpadding= 0 cellspacing= 0 width=100%>");
           sb.append("<tr>");
           sb.append("<td style='color: #153643; font-family: Arial, sans-serif; font-size: 24px; text-align: center;'>");
           sb.append("<b>BIENVENIDO A DESARROLLO SGEDI</b>");
           sb.append("</tr>");
           sb.append("<tr>");
           sb.append("<td style='padding: 20px 0 30px 0; color: #153643; font-family: Arial, sans-serif; font-size: 16px; line-height: 20px;'>SUS DOCUMENTOS EN LAS MEJORES MANOS </td>");
           sb.append("</tr>");
           email.setHtmlMsg(sb.toString());

            email.addTo(users.getEmail());
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
