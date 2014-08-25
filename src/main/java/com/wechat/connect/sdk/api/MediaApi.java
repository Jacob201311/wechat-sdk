package com.wechat.connect.sdk.api;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;

import com.wechat.connect.sdk.common.constant.Constants;
import com.wechat.connect.sdk.common.exception.WechatSDKException;
import com.wechat.connect.sdk.model.common.Authorization;
import com.wechat.connect.sdk.model.common.Media;
import com.wechat.connect.sdk.model.common.MimeType;
import com.wechat.connect.sdk.model.massivemsg.MpNews;
import com.wechat.connect.sdk.util.PropertiesUtil;
import com.wechat.connect.sdk.util.RequestUtil;

public class MediaApi extends BaseApi{

    private Logger logger = Logger.getLogger(MediaApi.class);
    private static final String FORM_DATA_NAME = "media";

    /**
     * image: 128K JPF <br/>
     * voice: 256K AMR length < 60s <br/>
     * video: 1MB MP4 <br/>
     * thumb: 64K JPG <br/>
     * Tip: all media life cycle is 3 days
     * @throws WechatSDKException
     */
    public Media uploadMediaMaterial(Authorization authorization, File file, MimeType mimeType)
            throws WechatSDKException {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        params.put(Constants.ARG_MEDIA_TYPE, mimeType.toString());
        String uploadMediaApi = PropertiesUtil.getAPI(Constants.API_MEDIA_UPLOAD);
        String result = RequestUtil.uploadMaterial(uploadMediaApi, params, FORM_DATA_NAME, file);
        Media media = this.wrapModel(result, Media.class);
        return media;
    }

    /**
     * the image page
     * @param mediaId
     * @return HttpResponse
     */
    public HttpResponse downloadMeidaMaterial(Authorization authorization, String mediaId) {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        params.put(Constants.ARG_MEDIA_ID, mediaId);
        String downloadMediaApi = PropertiesUtil.getAPI(Constants.API_MEDIA_DOWNLOAD);
        HttpResponse response = RequestUtil.doGetResource(downloadMediaApi, params);
        return response;
    }

    /**
     * create mpNews
     * @param authorization
     * @param mpNews
     * @return
     * @throws WechatSDKException
     */
    public Media createMpNews(Authorization authorization, MpNews mpNews) throws WechatSDKException {
        String createMpNewsAPI = PropertiesUtil.getAPI(Constants.API_MPNEWS_CREATE);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        logger.info("=======" + mpNews.toJSON() + "=======");
        String result = RequestUtil.doPost(createMpNewsAPI, params, mpNews.toJSON());
        Media media = this.wrapModel(result, Media.class);
        return media;
    }

}
