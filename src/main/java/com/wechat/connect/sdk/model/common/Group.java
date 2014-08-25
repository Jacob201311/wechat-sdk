package com.augmentum.wechat.connect.sdk.model.common;

public class Group {

    private int id;
    private String name;
    private int count;

    public Group() {}

    public Group(String name) {
        this.name = name;
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private static final String groupCreateTemplate = 
        "{" + "\n" +
        "    \"group\": {" + "\n" +
        "        \"name\": \"%s\"" + "\n" +
        "    }" + "\n" +
        "}";

    public String toCreateString() {
        return String.format(groupCreateTemplate, this.name);
    }

    private static final String groupUpdateTemplate = 
            "{" + "\n" +
            "    \"group\": {" + "\n" +
            "        \"id\": %s," + "\n" +
            "        \"name\": \"%s\"" + "\n" +
            "    }" + "\n" +
            "}";

    public String toUpdateString() {
        return String.format(groupUpdateTemplate, this.id, this.name);
    }
}
