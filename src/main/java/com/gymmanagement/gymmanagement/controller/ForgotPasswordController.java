package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.Utility;
import com.gymmanagement.gymmanagement.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class ForgotPasswordController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    UserService userService;

    @PostMapping("/api/user/forgot_password")
    public void processForgotPassword(HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        String username = request.getParameter("username");
        String token = RandomString.make(30);

        try {
            userService.updateResetPasswordToken(token, username);
            String resetPasswordLink = Utility.getSiteURL(request) + "/api/user/reset_password?token=" + token;
            sendEmail(username, resetPasswordLink);
        } catch (UsernameNotFoundException ex) {

        } catch (UnsupportedEncodingException | MessagingException e) {

        }
        }


    public void sendEmail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("zadora990605@gmail.com", "GymManagement Support");
        helper.setTo(recipientEmail);

        String subject = "Link to reset your password";

        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);

    }

//    @PostMapping("/api/user/reset_password")
//    public String processResetPassword() {
//
//    }
}
