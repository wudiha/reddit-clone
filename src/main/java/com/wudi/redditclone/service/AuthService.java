package com.wudi.redditclone.service;


import com.wudi.redditclone.dto.RegisterDTO;
import com.wudi.redditclone.model.NotificationEmail;
import com.wudi.redditclone.model.User;
import com.wudi.redditclone.model.VerificationToken;
import com.wudi.redditclone.repo.UserRepo;
import com.wudi.redditclone.repo.VerificationTokenRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;


@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepo verificationTokenRepo;
    private final MailService mailService;


    @Transactional
    public void register(RegisterDTO registerDTO){
        User user = new User();
        user.setEmail((registerDTO.getEmail()));
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setUsername(registerDTO.getUsername());
        user.setCreated(Instant.now());
        user.setEnabled(false);
        userRepo.save(user);

        String token = generateToken(user);
        mailService.sendMail(new NotificationEmail("Account Activation",user.getEmail(),"Please click on the link to activate your account:" +
                "http://localhost:8080/api/auth/accountVerification/"+token));
    }

    private String generateToken(User user){
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepo.save(verificationToken);
        return token;
    }
}
