package com.carrywei.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class JsoupMain {
    public static void main(String[] args) throws IOException {
        File htmlFile = new File("test.html");
        System.out.println(htmlFile.getAbsolutePath());
        System.out.println(htmlFile.exists());
        Document document = Jsoup.parse(htmlFile, "utf-8");
        System.out.println(document.select("body").text());
        System.out.println(document.select("div").attr("class"));

    }
}
