package com.wechat.api;

import static org.junit.Assert.*;

import org.junit.Test;

import com.wechat.model.common.Authorization;

public class OAuthApiTest {

    @Test
    public void requestAuthorationTest() {
        OAuthApi api = new OAuthApi();
        Authorization authorization = api.requestAuthorization();
        assertNotNull(authorization);
    }

}
