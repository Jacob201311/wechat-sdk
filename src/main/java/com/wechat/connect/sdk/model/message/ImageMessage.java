package com.wechat.connect.sdk.model.message;

import org.w3c.dom.Document;

import com.wechat.connect.sdk.common.constant.Constants;
import com.wechat.connect.sdk.util.XMLUtil;

public class ImageMessage extends Message {

    private static final long serialVersionUID = 1032921858876745237L;

    private String picUrl;
    private String mediaId;

    public ImageMessage() {
        this.setMessageType(Constants.MESSAGE_TYPE_IMAGE);
    }

    public ImageMessage(Document document) {
        super(document);
        picUrl = XMLUtil.getNodeContent(document, Constants.TEMPLATE_IMAGE_PICTURE_URL);
        mediaId = XMLUtil.getNodeContent(document, Constants.TEMPLATE_MEDIA_ID);
    }

    public ImageMessage(String mediaId) {
        this.mediaId = mediaId;
        this.setMessageType(Constants.MESSAGE_TYPE_IMAGE);
    }

    public ImageMessage(Message receivedMessage) {
        super(receivedMessage);
        this.setMessageType(Constants.MESSAGE_TYPE_IMAGE);
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    private static final String XMLTemplate = "<Image><MediaId><![CDATA[%s]]></MediaId></Image>";
    private static final String JSONTemplate = "\"media_id\": \"%s\"";

    @Override
    public String toXML() {
        String baseTemplate = super.toXML();
        String data = String.format(XMLTemplate, mediaId);
        return baseTemplate.replace(Constants.TEMPLATE_REEPLACE_STR, data);
    }

    @Override
    public String toJSON() {
        String baseTemplate = super.toJSON();
        String data = String.format(JSONTemplate, mediaId);
        return baseTemplate.replace(Constants.TEMPLATE_REEPLACE_STR, data);
    }
}
