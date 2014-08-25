package com.augmentum.wechat.connect.sdk.model.common;

import org.codehaus.jackson.annotate.JsonProperty;

public class Ticket {

    private String ticket;
    @JsonProperty(value = "expire_seconds")
    private int expiredTime;
    private String url;

    public Ticket() {
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(int expiredTime) {
        this.expiredTime = expiredTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
