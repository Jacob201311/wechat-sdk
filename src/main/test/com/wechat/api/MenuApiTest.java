package com.wechat.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.wechat.model.common.Authorization;
import com.wechat.model.menu.Button;
import com.wechat.model.menu.ButtonContainer;
import com.wechat.model.menu.ClickButton;
import com.wechat.model.menu.ViewButton;

public class MenuApiTest {
    Logger logger = Logger.getLogger(MenuApiTest.class);

    private Authorization authorization;
    private MenuApi api;
    private static final String EXPECTED_RESULT = "{\"errcode\":0,\"errmsg\":\"ok\"}";

    @Before
    public void initAuthorization() {
        this.authorization = new OAuthApi().requestAuthorization();
        api = new MenuApi(authorization);
    }

    @Test
    public void createMenuTest() {
        ClickButton clickButton = new ClickButton("click");
        ViewButton viewButton = new ViewButton("view", "http://www.baidu.com");
        ButtonContainer buttonContainer = new ButtonContainer();
        ClickButton clickButton1 = new ClickButton("click1");
        ViewButton viewButton1 = new ViewButton("view1", "http://www.baidu.com");
        buttonContainer.addSubButton(clickButton1);
        buttonContainer.addSubButton(viewButton1);
        List<Button> buttonList = new ArrayList<Button>();
        buttonList.add(clickButton);
        buttonList.add(viewButton);
        buttonList.add(buttonContainer);
        String result = api.createMenu(buttonList);
        assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void getMenuTest() {
        String result = api.getMenu();
        if (!result.contains("menu")) {
            fail();
        }
    }

    @Test
    public void deleteMenuTest() {
        String result = api.deleteMenu();
        assertEquals(EXPECTED_RESULT, result);
    }
}
