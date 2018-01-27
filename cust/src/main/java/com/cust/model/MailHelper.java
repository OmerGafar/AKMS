package com.cust.model;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/*import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;*/
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

import com.cust.config.ApplicationConfig;
import com.cust.service.MailService;

public class MailHelper 
{
/*    @Async
public static void test() 
{
    Mail mail = new Mail();
    mail.setMailFrom("omergafar110@gmail.com");
    mail.setMailTo("omergaffer110@gmail.com");
    mail.setMailSubject("New Activation Key Notfiy - (AK-MS)");

    Map < String, Object > model = new HashMap < String, Object > ();
    model.put("name", "Yashwant");
    model.put("activationKey", "key");

    mail.setModel(model);

    AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    MailService mailService = (MailService) context.getBean("mailService");
    mailService.sendEmail(mail);
    context.close();
}

*/
//private final static  MailService mailService = (MailService) new AnnotationConfigApplicationContext(ApplicationConfig.class).getBean("mailService");
//@Scheduled(fixedDelay=60*1000)
public  static void sendkey(Customer cust,String  activationKey) 
{
    Mail mail = new Mail();
    mail.setMailFrom("omergafar110@gmail.com");
    mail.setMailTo(cust.getEmail());
    mail.setMailSubject("New Activation Key Notfiy - (AK-MS)");

    Map < String, Object > model = new HashMap < String, Object > ();
    model.put("name", cust.getName());
    model.put("activationKey",activationKey );
    mail.setModel(model);
    
    AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    MailService mailService = (MailService) context.getBean("mailService");
    mailService.sendEmail(mail);
    context.close();

}


}


