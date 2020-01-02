package jack.helloworld.email.sendingemail20191001;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Sender {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.163.com");
        props.put("mail.smtp.auth", "true"); //需要
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("zzd16000@163.com", "zzd1600");// password 为 163邮箱授权码
            }
        });
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("zzd16000@163.com"));
            msg.addRecipients(Message.RecipientType.TO, "1600084359@qq.com,jack.zhou@d1m.cn");
            msg.setSubject("第一封来自 JavaMail的邮件");
            msg.setText("Hello Zhengde,\n\nThis is your first mail sent from JavaMail.\n\nBest,\nZhengde");
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    

}

