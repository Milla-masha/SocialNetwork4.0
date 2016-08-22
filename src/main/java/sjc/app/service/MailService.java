package sjc.app.service;

/**
 * Created by psycl on 22.08.2016.
 */
public interface MailService
{
    void sendPasswordToEmail(String subject, String password, String toEmail);
}
