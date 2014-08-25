package com.augmentum.wechat.connect.sdk.model.menu;

public class ViewButton extends Button {

    private String type;
    private String url;

    public ViewButton() {
        this.type = "view";
    }

    public ViewButton(String name, String url) {
        super.setName(name);
        this.type = "view";
        this.url = url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }

}
