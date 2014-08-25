package com.augmentum.wechat.connect.sdk.model.massivemsg;

import java.util.Iterator;
import java.util.List;

public class MassiveSendArg {

    private int groupId;
    private List<String> openIds;
    private String mediaIdOrContent;
    private MassiveMsgType msgType;

    public MassiveSendArg() {}

    public MassiveSendArg(int groupId, String mediaId, MassiveMsgType msgType) {
        this.groupId = groupId;
        this.mediaIdOrContent = mediaId;
        this.msgType = msgType;
    }

    public MassiveSendArg(List<String> openIds, String mediaId, MassiveMsgType msgType) {
        this.openIds = openIds;
        this.mediaIdOrContent = mediaId;
        this.msgType = msgType;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<String> getOpenIds() {
        return openIds;
    }

    public void setOpenIds(List<String> openIds) {
        this.openIds = openIds;
    }

    public String getMediaIdOrContent() {
        return mediaIdOrContent;
    }

    public void setMediaIdOrContent(String mediaIdOrContent) {
        this.mediaIdOrContent = mediaIdOrContent;
    }

    public MassiveMsgType getMsgType() {
        return msgType;
    }

    public void setMsgType(MassiveMsgType msgType) {
        this.msgType = msgType;
    }

    private static final String JSON_GROUP_TEMPLATE = 
            "{\n" +
               "\"filter\":{\n" +
                  "\"group_id\":\"%d\"\n" +
               "},\n" +
               "\"%s\":{\n" +
                  "\"%s\":\"%s\"\n" +
               "},\n" +
                "\"msgtype\":\"%s\"\n" +
            "}";

    private static final String JSON_OIDS_TEMPLATE = 
            "{\n" +
                "\"touser\":\n" +
                      "%s,\n" +
                "\"%s\":{\n" +
                   "\"%s\": \"%s\"\n" +
                "},\n" +
                 "\"msgtype\":\"%s\"\n" +
            "}";

    public String toGroupJSON() {
        return String.format(JSON_GROUP_TEMPLATE, groupId, msgType.getTypeStringValue(), MassiveMsgType.TEXT.equals(msgType) ? "content" : "media_id", mediaIdOrContent, msgType.getTypeStringValue());
    }

    public String toOidsJSON() {
        String result = null;
        Iterator<String> it = openIds.iterator();
        if (!it.hasNext()) {
            result = "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[\"");
            String e = null;
            while (null != (e = it.next())) {
                sb.append(e);
                if (!it.hasNext()) {
                    result = sb.append("\"]").toString();
                    break;
                } else {
                    sb.append("\",\"");
                }
            }
        }
        return String.format(JSON_OIDS_TEMPLATE, result, msgType.getTypeStringValue(), MassiveMsgType.TEXT.equals(msgType) ? "content" : "media_id", mediaIdOrContent, msgType.getTypeStringValue());
    }
}
