package com.wechat.connect.sdk.model.menu;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ButtonContainer extends Button {

    @JsonProperty(value = "sub_button")
    private List<Button> subButtons;

    public ButtonContainer(String name) {
        setName(name);
        this.subButtons = new ArrayList<Button>();
    }

    public void addSubButton(Button button) {
        this.subButtons.add(button);
    }

    public List<Button> getSubButtons() {
        return subButtons;
    }

}
