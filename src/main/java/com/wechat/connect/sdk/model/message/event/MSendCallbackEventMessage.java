package com.wechat.connect.sdk.model.message.event;

import org.w3c.dom.Document;

import com.wechat.connect.sdk.common.constant.Constants;
import com.wechat.connect.sdk.util.XMLUtil;

public class MSendCallbackEventMessage extends EventMessage {

    private static final long serialVersionUID = -3035855923613146122L;

    private String status;
    private int totalCount;
    private int filterCount;
    private int sentCount;
    private int ErrorCount;

    public MSendCallbackEventMessage() {}

    public MSendCallbackEventMessage(Document document) {
        super(document);
        status = XMLUtil.getNodeContent(document, Constants.TEMPLATE_EVENT_STATUS);
        totalCount = Integer.parseInt(XMLUtil.getNodeContent(document, Constants.TEMPLATE_EVENT_TOTALCOUNT));
        filterCount = Integer.parseInt(XMLUtil.getNodeContent(document, Constants.TEMPLATE_EVENT_FILTERCOUNT));
        sentCount = Integer.parseInt(XMLUtil.getNodeContent(document, Constants.TEMPLATE_EVENT_SENTCOUNT));
        ErrorCount = Integer.parseInt(XMLUtil.getNodeContent(document, Constants.TEMPLATE_EVENT_ERRORCOUNT));
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(int filterCount) {
        this.filterCount = filterCount;
    }

    public int getSentCount() {
        return sentCount;
    }

    public void setSentCount(int sentCount) {
        this.sentCount = sentCount;
    }

    public int getErrorCount() {
        return ErrorCount;
    }

    public void setErrorCount(int errorCount) {
        ErrorCount = errorCount;
    }

}
