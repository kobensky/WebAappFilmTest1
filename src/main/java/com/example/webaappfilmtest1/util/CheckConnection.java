package com.example.webaappfilmtest1.util;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class CheckConnection {
    public Document checkConnection (String url) {
        Document doc = null;

        try {
            return doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
