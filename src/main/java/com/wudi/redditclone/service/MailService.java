package com.wudi.redditclone.service;

import com.wudi.redditclone.model.NotificationEmail;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {

    public void sendMail(NotificationEmail notificationEmail){
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {

        };
    }

}
