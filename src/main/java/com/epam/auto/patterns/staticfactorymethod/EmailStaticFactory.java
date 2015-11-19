package com.epam.auto.patterns.staticfactorymethod;

/**
 * Created by ekaterinabut on 11/19/15.
 */
public class EmailStaticFactory {

    public static Email createSimpleEmail(String to, String subject, String emailBody) {
        Email email = new Email();
        email.setTo(to);
        email.setSubject(subject);
        email.setEmailBody(emailBody);
        return email;
    }

    public static Email createEmptyEmail(String to, String subject) {
        Email email = new Email();
        email.setTo(to);
        email.setSubject(subject);
        return email;
    }
}