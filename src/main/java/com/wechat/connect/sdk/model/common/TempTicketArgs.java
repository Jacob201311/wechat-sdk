package com.augmentum.wechat.connect.sdk.model.common;

public class TempTicketArgs extends TicketArgs {

    private int expiredTime;

    private static final String TEMP_TICKET = "QR_SCENE";

    public TempTicketArgs() {
        this.actionName = TEMP_TICKET;
    }

    public TempTicketArgs(int sceneId, int expiredTime) {
        this.actionName = TEMP_TICKET;
        this.sceneId = sceneId;
        this.expiredTime = expiredTime % 1800 == 0 ? 1800 : expiredTime % 1800;
    }

    public int getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(int expiredTime) {
        this.expiredTime = expiredTime % 1799 + 1;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    private static final String ticketTemplate = 
            "{" + "\n" +
            "    \"expire_seconds\": %d," + "\n" +
            "    \"action_name\": \"%s\"," + "\n" +
            "    \"action_info\":" + "\n" +
            "        {" + "\n" +
            "            \"scene\":" + "\n" +
            "                {" + "\n" +
            "                    \"scene_id\": %d" + "\n" +
            "                }" + "\n" +
            "        }" + "\n" +
            "}";

    public String toString() {
        return String.format(ticketTemplate, this.expiredTime, this.actionName, this.sceneId);
    }
}
