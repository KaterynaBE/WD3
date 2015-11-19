package com.epam.auto.patterns.staticfactorymethod;

/**
 * Created by ekaterinabut on 11/18/15.
 */
public class Email {

    private String to;
    private String subject;
    private String emailBody;

    public Email(String to, String subject, String emailBody) {
        this.to = to;
        this.subject = subject;
        this.emailBody = emailBody;
    }

    public Email() {
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmailBody() {
        return emailBody;
    }
}
