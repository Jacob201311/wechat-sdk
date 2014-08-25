package com.wechat.connect.sdk.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLUtil {

    private static DocumentBuilderFactory docFactory;

    private static DocumentBuilderFactory getInstance() {
        if (null == docFactory) {
            docFactory = DocumentBuilderFactory.newInstance();
        }
        return docFactory;
    }

    public static Document getDocument(InputStream xmlIs) {
        docFactory = getInstance();
        Document document = null;
        try {
            DocumentBuilder builder = docFactory.newDocumentBuilder(); 
            document = builder.parse(xmlIs);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static Document getDocument(String xmlStr) {
        docFactory = getInstance();
        Document document = null;
        try {
            DocumentBuilder builder = docFactory.newDocumentBuilder(); 
            document = builder.parse(new ByteArrayInputStream(xmlStr.getBytes()));
            document.getDocumentElement().normalize();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static String getNodeContent(Document document, String nodeName) {
        NodeList nl = document.getElementsByTagName(nodeName);
        if (0 == nl.getLength()) {
            return "";
        } else {
            return nl.item(0).getTextContent();
        }
    }
}
