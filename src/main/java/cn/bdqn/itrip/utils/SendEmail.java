package cn.bdqn.itrip.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * 发送邮箱
 */
public class SendEmail {
    public static String send(String to,String context,JavaMailSender jms){
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom("cjiada@sina.com");
        //接收者
        mainMessage.setTo(to);
        //发送的标题
        mainMessage.setSubject("爱旅行账号激活");
        //发送的内容
        mainMessage.setText("亲爱的 "+to+" 用户，您的激活码为："+context);
        jms.send(mainMessage);
        return "1";
    }
}
