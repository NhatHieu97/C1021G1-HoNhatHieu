package com.codegym.dao;

import com.codegym.model.EmailObj;

public interface IEmailService {
    void sendEmail(EmailObj email);
}
