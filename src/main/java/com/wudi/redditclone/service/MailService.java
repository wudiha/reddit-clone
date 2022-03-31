package com.wudi.redditclone.service;

import com.wudi.redditclone.exception.RedditException;
import com.wudi.redditclone.model.NotificationEmail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender javaMailSender;
    private final MailBuilder mailBuilder;

    public void sendMail(NotificationEmail notificationEmail){
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom("mysterypma@gmail.com");
            mimeMessageHelper.setTo(notificationEmail.getRecipient());
            mimeMessageHelper.setSubject(notificationEmail.getSubject());
            mimeMessageHelper.setText(mailBuilder.build(notificationEmail.getBody()));
        };
            try {
                javaMailSender.send(mimeMessagePreparator);
                log.info("Email Sent");
            }catch (MailException e){
                log.error(e.toString());
                throw new RedditException("Exception Occurred while sending email to: "+notificationEmail.getRecipient());
            }

    }

}
