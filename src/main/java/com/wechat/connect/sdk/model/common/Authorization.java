package com.wechat.connect.sdk.model.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @property
 * accessToken: String<br/>
 * expiredTime: int <br/>
 * startTime: long, the record time when init the model<br/>
 */
public class Authorization implements Serializable {

    private static final long serialVersionUID = 3637977842545040092L;

    private final String accessToken;
    private final int expiredTime;
    private final long startTime;

    public Authorization(String accessToken, int expiredTime) {
        this.accessToken = accessToken;
        this.expiredTime = expiredTime;
        startTime = new Date().getTime();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public int getExpiredTime() {
        return expiredTime;
    }

    public long getStartTime() {
        return startTime;
    }

    /**
     * this remaing life time may not accurate, you should not refresh access token util the time become 0.
     * @return int (-∞, 7200]
     */
    public int remainigLife() {
        long now = new Date().getTime();
        Long diff = now - startTime;
        int life = expiredTime - diff.intValue() / 1000;
        return life;
    }

    public boolean isExpired() {
        return this.remainigLife() < 6000;
    }
}
