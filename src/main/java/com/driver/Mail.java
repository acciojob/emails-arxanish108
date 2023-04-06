package com.driver;

import java.util.Date;

public class Mail {
    private Date date;
    private String senderid;
    private String message;

    public Mail(Date date, String senderid, String message) {
        this.date = date;
        this.senderid = senderid;
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
