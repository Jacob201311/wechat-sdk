package com.wechat.connect.sdk.model.massivemsg;

import java.util.ArrayList;
import java.util.List;

public class MpNews {

    private List<MpNewsItem> articles = new ArrayList<MpNewsItem>();

    public MpNews() {}

    public MpNews(List<MpNewsItem> articles) {
        this.articles = articles;
    }

    public List<MpNewsItem> getArticles() {
        return articles;
    }

    public void setArticles(List<MpNewsItem> articles) {
        this.articles = articles;
    }

    public void addAtricle(MpNewsItem item) {
        articles.add(item);
    }

    private static final String JSONTemplate = 
            "{\n" +
                    "\"articles\": [" + "\n" +
                        "%s" + "\n" +
                    "]" + "\n" +
            "}";

    public String toJSON() {
        StringBuilder articlesData = new StringBuilder();
        for (MpNewsItem item : articles) {
            articlesData.append(item.toJSON()).append(",");
        }
        articlesData.deleteCharAt(articlesData.length() - 1);
        return String.format(JSONTemplate, articlesData.toString());
    }
}
