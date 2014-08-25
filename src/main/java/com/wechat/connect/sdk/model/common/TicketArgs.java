package com.wechat.connect.sdk.model.common;

public class TicketArgs {

    protected String actionName;
    protected int sceneId;

    private static final String PERMANENT_TICKET = "QR_LIMIT_SCENE";

    public TicketArgs() {
        this.actionName = PERMANENT_TICKET;
    }

    public TicketArgs(int sceneId) {
        this.actionName = PERMANENT_TICKET;
        this.sceneId = sceneId % 100000 == 0 ? 100000 : sceneId % 100000;
    }

    public String getActionName() {
        return actionName;
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId % 99999 + 1;
    }

    private static final String ticketTemplate = 
        "{" + "\n" +
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
        return String.format(ticketTemplate, this.actionName, this.sceneId);
    }
}
