package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.exception.MailException;
import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.service.MailService;
import com.solvd.laba.sinder.service.property.MailProperty;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final Configuration configuration;
    private final JavaMailSender javaMailSender;
    private final MailProperty mailProperty;

    @Override
    public void sendMail(User user, String template, String subject, String link) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setSubject(subject);
            helper.setFrom(mailProperty.getUsername());
            helper.setTo(user.getEmail());
            String emailContent = getEmailContent(user, template, link);
            helper.setText(emailContent, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException | IOException | TemplateException e) {
            throw new MailException("Unable to send mail, try again!");
        }
    }

    String getEmailContent(User user, String template, String link) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        model.put("link", link);
        configuration.getTemplate(template).process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }

}
