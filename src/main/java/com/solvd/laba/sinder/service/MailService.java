package com.solvd.laba.sinder.service;

import com.solvd.laba.sinder.domain.user.User;

public interface MailService {

    void sendMail(User user, String template, String subject, String link);

}
