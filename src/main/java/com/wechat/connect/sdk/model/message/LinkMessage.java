package com.wechat.connect.sdk.model.message;

import org.w3c.dom.Document;

import com.wechat.connect.sdk.common.constant.Constants;
import com.wechat.connect.sdk.util.XMLUtil;

public class LinkMessage extends Message {

    private static final long serialVersionUID = -3296090259320957299L;

    private String title;
    private String description;
    private String url;

    public LinkMessage() {
        this.setMessageType(Constants.MESSAGE_TYPE_LINK);
    }

    public LinkMessage(Document document) {
        super(document);
        title = XMLUtil.getNodeContent(document, Constants.TEMPLATE_LINK_TITLE);
        description = XMLUtil.getNodeContent(document, Constants.TEMPLATE_LINK_DESCRIPTION);
        url = XMLUtil.getNodeContent(document, Constants.TEMPLATE_LINK_URL);
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
