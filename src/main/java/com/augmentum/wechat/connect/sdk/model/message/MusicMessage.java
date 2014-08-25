package com.augmentum.wechat.connect.sdk.model.message;

import com.augmentum.wechat.connect.sdk.common.constant.Constants;

public class MusicMessage extends Message {

    private static final long serialVersionUID = 9139390899614402820L;

    private String title;
    private String description;
    private String musicUrl;
    private String hQMusicUrl;
    private String thumbMediaId;

    public MusicMessage() {
        this.setMessageType(Constants.MESSAGE_TYPE_MUSIC);
    }

    public MusicMessage(Message receivedMessage) {
        super(receivedMessage);
        this.setMessageType(Constants.MESSAGE_TYPE_MUSIC);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String gethQMusicUrl() {
        return hQMusicUrl;
    }

    public void sethQMusicUrl(String hQMusicUrl) {
        this.hQMusicUrl = hQMusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    private static final String XMLTemplate = "<Music><Title><![CDATA[%s]]></Title><Description><![CDATA[%s]]></Description><MusicUrl><![CDATA[%s]]></MusicUrl><HQMusicUrl><![CDATA[%s]]></HQMusicUrl><ThumbMediaId><![CDATA[%s]]></ThumbMediaId></Music>";
    private static final String JSONTemplate = "\"title\":\"%s\", \"description\":\"%s\", \"musicurl\":\"%s\", \"hqmusicurl\":\"%s\", \"thumb_media_id\":\"%s\"";

    @Override
    public String toXML() {
        String baseTemplate = super.toXML();
        String data = String.format(XMLTemplate, title, description, musicUrl, hQMusicUrl, thumbMediaId);
        return baseTemplate.replace(Constants.TEMPLATE_REEPLACE_STR, data);
    }

    @Override
    public String toJSON() {
        String baseTemplate = super.toJSON();
        String data = String.format(JSONTemplate, title, description, musicUrl, hQMusicUrl, thumbMediaId);
        return baseTemplate.replace(Constants.TEMPLATE_REEPLACE_STR, data);
    }
}
