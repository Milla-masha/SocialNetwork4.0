package sjc.app.service.impl;

import org.springframework.stereotype.Controller;
import sjc.app.service.MailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static sjc.app.constant.Constant.*;

/**
 * Created by psycl on 22.08.2016.
 */
@Controller
public class MailServiceImpl implements MailService
{

 /*       private Properties props;

        public MailServiceImpl() {

            props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
        }
*/


    @Override
    public void sendPasswordToEmail(String subject, String passwordToSend, String toEmail)
    {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(LOGIN_EMAIL, PASSWORD_EMAIL);
                    }
                });


        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(LOGIN_EMAIL));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText("Ale, yoba eto ti???,"
                    + "\n\n"+passwordToSend);

            Transport.send(message);

            System.out.println("Done");
        } catch (MessagingException mex)
        {
            mex.printStackTrace();
        }

    }

}

