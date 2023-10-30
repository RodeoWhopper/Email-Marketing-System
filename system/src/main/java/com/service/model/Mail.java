package com.service.model;

public class Mail {

    private String receiverAddress;

    private String senderAddress;

    private String smtpServerAddress;

    private String smtpServerPort;

    private String mailContent;

    private String mailSubject;

    public Mail(String receiverAddress, String senderAddress, String smtpServerAddress, String mailContent, String mailSubject) {
        this.receiverAddress = receiverAddress;
        this.senderAddress = senderAddress;
        this.smtpServerAddress = smtpServerAddress; // domain.smtp.com --- 127.0.0.1:26615
        this.mailContent = mailContent;
        this.mailSubject = mailSubject;
    }

    public Mail(String receiverAddress, String senderAddress, String smtpServerAddress, String smtpServerPort, String mailContent, String mailSubject) {
        this.receiverAddress = receiverAddress;
        this.senderAddress = senderAddress;
        this.smtpServerAddress = smtpServerAddress;
        this.smtpServerPort = smtpServerPort;
        this.mailContent = mailContent;
        this.mailSubject = mailSubject;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSmtpServerAddress() {
        return smtpServerAddress;
    }

    public void setSmtpServerAddress(String smtpServerAddress) {
        this.smtpServerAddress = smtpServerAddress;
    }

    public String getSmtpServerPort() {
        return smtpServerPort;
    }

    public void setSmtpServerPort(String smtpServerPort) {
        this.smtpServerPort = smtpServerPort;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

}
