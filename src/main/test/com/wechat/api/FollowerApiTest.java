package com.wechat.api;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.wechat.common.exception.WechatSDKException;
import com.wechat.model.common.Authorization;
import com.wechat.model.common.Follower;
import com.wechat.model.common.FollowerContainer;

public class FollowerApiTest {

    Logger logger = Logger.getLogger(FollowerApiTest.class);

    private Authorization authorization;
    private FollowerApi api;

    @Before
    public void initAuthorization() {
//        this.authorization = new OAuthApi().requestAuthorization();
            this.authorization = new Authorization("68zOFbBRF3jcxpFi1wt3bXCfFme38B8Mz3cqbpJaYLSqJcMgY1b1olPnDd_cdc_fDNSw_qEm0UWQ_PmYgdNzY6LZJEhBKB74NFa08ltBxhsX0K311ZgW0pv3jpxHUu4YvRq6JNnJ29toMiWEGf-7RQ", 7200);
            api = new FollowerApi(authorization);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void getFollowerListTest() {
        FollowerContainer container = null;
        try {
            container = api.getFollowerList();
        } catch (WechatSDKException e) {
            e.printStackTrace();
        }
        assertNotNull(container);
        for (String openId : ((List<String>) container.getData().get("openid"))) {
            logger.info(openId);
        }
    }

    @Test
    public void getFollowerInfoTest() {
        Follower follower = null;
        String openId = "oGyeWjr92EJfynsJgH6mTzx0JLFI";
        try {
            follower = api.getFollowerInfo(openId);
        } catch (WechatSDKException e) {
            e.printStackTrace();
        }
        assertNotNull(follower);
        logger.info(follower.getOpenId() + " " + follower.getNickName() + " " + follower.getGender());
    }
}
