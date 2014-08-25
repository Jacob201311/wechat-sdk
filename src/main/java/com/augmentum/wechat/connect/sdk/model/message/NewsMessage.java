package com.augmentum.wechat.connect.sdk.model.message;

import java.util.ArrayList;
import java.util.List;

import com.augmentum.wechat.connect.sdk.common.constant.Constants;

public class NewsMessage extends Message {

    private static final long serialVersionUID = -939389188080773918L;

    private int articleCount;
    private List<NewsItem> articles = new ArrayList<NewsItem>();

    public NewsMessage() {
        super.setMessageType(Constants.MESSAGE_TYPE_NEWS);
    }

    public NewsMessage(Message receivedMessage) {
        super(receivedMessage);
        super.setMessageType(Constants.MESSAGE_TYPE_NEWS);
    }

    public int getArticleCount() {
        return articleCount;
    }

    public List<NewsItem> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsItem> articles) {
        this.articles = articles;
    }

    public void addAtricle(NewsItem item) {
        articles.add(item);
        articleCount++;
    }

    private static final String XMLTemplate =
        "<ArticleCount>%s</ArticleCount>" + "\n" +
        "<Articles>%s</Articles>" + "\n";
    private static final String JSONTemplate =
        "\"articles\": [" + "\n" +
        "%s" + "\n" +
        "]" + "\n";

    @Override
    public String toXML() {
        String baseTemplate = super.toXML();
        StringBuilder articlesData = new StringBuilder();
        for (NewsItem item : articles) {
            articlesData.append(item.toXML());
        }
        String data = String.format(XMLTemplate, articleCount, articlesData.toString());
        return baseTemplate.replace(Constants.TEMPLATE_REEPLACE_STR, data);
    }

    @Override
    public String toJSON() {
        String baseTemplate = super.toJSON();
        StringBuilder articlesData = new StringBuilder();
        for (NewsItem item : articles) {
            articlesData.append(item.toJSON()).append(",");
        }
        articlesData.deleteCharAt(articlesData.length() - 1);
        String data = String.format(JSONTemplate, articlesData.toString());
        return baseTemplate.replace(Constants.TEMPLATE_REEPLACE_STR, data);
    }
}
