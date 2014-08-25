package com.wechat.api;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.wechat.common.exception.WechatSDKException;
import com.wechat.model.common.Authorization;
import com.wechat.model.common.Group;
import com.wechat.model.common.GroupContainer;

public class GroupApiTest {

    Logger logger = Logger.getLogger(GroupApiTest.class);

    private Authorization authorization;
    private GroupApi api;
    private static final String EXPECTED_RESULT = "{\"errcode\":0,\"errmsg\":\"ok\"}";

    @Before
    public void initAuthorization() {
//        this.authorization = new OAuthApi().requestAuthorization();
            this.authorization = new Authorization("Ly02aV9aopp1gpcrYMPry3PXYOxWkEUtsD9LSuLTymQLxur_yskNFWWt7TWiqI25CydbllFZ9zvToba8fl0txZbx7I3aPzeTGH6zOZyqVRgN8BowmHgISB2KfYnawj73PjwNNH1fTT4wl-3dx5-PrQ", 7200);
            api = new GroupApi(authorization);
    }

    @Test
    public void createGroupTest() {
        Group group = new Group("New_Test111");
        try {
            group = api.createGroup(group);
        } catch (WechatSDKException e) {
            e.printStackTrace();
        }
        assertNotNull(group);
    }

    @Test
    public void getGroupInfoTest() {
        GroupContainer groupContainer = null;
        try {
            groupContainer = api.getGroup();
        } catch (WechatSDKException e) {
            e.printStackTrace();
        }
        assertNotNull(groupContainer);
      logger.info(groupContainer.getGroups().get(3));
    }

    @Test
    public void renameGroupTest() {
        Group group = new Group(102, "TEST1234");
        String result = api.renameGroup(group);
        assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void removeUserToTest() {
        String result = api.moveUserTo("oGyeWjr92EJfynsJgH6mTzx0JLFI", 102);
        api.moveUserTo("oGyeWjr92EJfynsJgH6mTzx0JLFI", 100);
        assertEquals(EXPECTED_RESULT, result);
    }
}
