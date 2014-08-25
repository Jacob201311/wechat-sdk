package com.wechat.connect.sdk.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wechat.connect.sdk.common.constant.Constants;
import com.wechat.connect.sdk.common.exception.WechatSDKException;
import com.wechat.connect.sdk.model.common.Authorization;
import com.wechat.connect.sdk.model.menu.Button;
import com.wechat.connect.sdk.util.JSONUtil;
import com.wechat.connect.sdk.util.PropertiesUtil;
import com.wechat.connect.sdk.util.RequestUtil;

public class MenuApi extends BaseApi {

    /**
     *
     * @param buttonList
     * @param accessToken
     * @return {"errcode":0,"errmsg":"ok"}, {"errcode":40018,"errmsg":"invalid button name size"}
     */
    public String createMenu(Authorization authorization, List<Button> buttonList) {
        Map<String, Object> menu = new HashMap<String, Object>();
        menu.put(Constants.ARG_MENU_BUTTON, buttonList);
        String menuJson = JSONUtil.Map2JsonStr(menu);
        String createMenuApi = PropertiesUtil.getAPI(Constants.API_MENU_CREATE);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(createMenuApi, params, menuJson);
        return result;
    }

    /**
     * get memu json info
     * @return
     */
    public String getMenu(Authorization authorization) throws WechatSDKException {
        String getMenuApi = PropertiesUtil.getAPI(Constants.API_MENU_GET);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String menuJson = RequestUtil.doGet(getMenuApi, params);
        return menuJson;
    }

    /**
     *
     * @param accessToken
     * @return {"errcode":0,"errmsg":"ok"}
     */
    public String deleteMenu(Authorization authorization) {
        String getMenuApi = PropertiesUtil.getAPI(Constants.API_MENU_DELETE);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doGet(getMenuApi, params);
        return result;
    }
}
