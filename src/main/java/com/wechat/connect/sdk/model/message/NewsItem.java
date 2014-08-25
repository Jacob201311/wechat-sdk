package com.wechat.connect.sdk.model.message;

import java.io.Serializable;

import com.wechat.connect.sdk.util.CommonUtil;

public class NewsItem implements Serializable {

    private static final long serialVersionUID = -3367358359010821125L;

    private String title;
    private String description;
    private String picUrl;
    private String url;

    private static final String EMPTY_STR = "";

    public NewsItem() {}

    public NewsItem(String title, String description, String picUrl, String url) {
        this.title = title;
        this.description = null == description ? EMPTY_STR : description;
        this.picUrl = null == picUrl ? EMPTY_STR : picUrl;
        this.url = url;
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
        this.description = null == description ? EMPTY_STR : description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = null == picUrl ? EMPTY_STR : picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private static final String XMLTemplate =
            "<item>" + "\n" +
            "<Title><![CDATA[%s]]></Title>" + "\n" +
            "<Description><![CDATA[%s]]></Description>" + "\n" +
            "<PicUrl><![CDATA[%s]]></PicUrl>" + "\n" +
            "<Url><![CDATA[%s]]></Url>" + "\n" +
            "</item>";
    private static final String JSONTemplate =
            "{" + "\n" +
            "\"title\":\"%s\"," + "\n" +
            "\"description\":\"%s\"," + "\n" +
            "\"picurl\":\"%s\"," + "\n" +
            "\"url\":\"%s\"" + "\n" +
            "}" + "\n";

    public String toXML() {
        return String.format(XMLTemplate, title, description, picUrl, url);
    }

    public String toJSON() {
        return String.format(JSONTemplate, CommonUtil.escapeStr(title), CommonUtil.escapeStr(description), picUrl, url);
    }
}
