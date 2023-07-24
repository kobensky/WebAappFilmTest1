package com.example.webaappfilmtest1.service.impl;

import com.example.webaappfilmtest1.api.FilmReq;
import com.example.webaappfilmtest1.api.TimeSpendResp;
import com.example.webaappfilmtest1.response.Response;

import com.example.webaappfilmtest1.response.success.SuccessResponse;
import com.example.webaappfilmtest1.service.FilmService;
import com.example.webaappfilmtest1.util.CheckConnection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Slf4j
@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    @Autowired
    private CheckConnection checkConnection;
    @Override
    public ResponseEntity<Response> allSpendTimeForFilms(FilmReq req) {
        int timeSpendForFilms = 0;
        long filmsCount = 0;
        String url = req.getFilmsUrl();
        Document doc = checkConnection.checkConnection(url);
        Elements elem = doc.getElementsByClass("item");
        filmsCount = elem.stream().filter(e-> !e.getElementsByClass("nameRus").text().contains("сериал"))
                .filter(e-> e.getElementsByClass("rating").text().contains("мин"))
                .map(element->Long.parseLong(element.getElementsByClass("rating").text()
                        .substring(
                                element.getElementsByClass("rating").text().indexOf(") ") + 2,
                                element.getElementsByClass("rating").text().indexOf(" м")))).count();
        timeSpendForFilms = elem.stream().filter(e-> !e.getElementsByClass("nameRus").text().contains("сериал"))
                .filter(e-> e.getElementsByClass("rating").text().contains("мин"))
                .map(element->Integer.parseInt(element.getElementsByClass("rating").text()
                                                .substring(
                                                element.getElementsByClass("rating").text().indexOf(") ") + 2,
                                                element.getElementsByClass("rating").text().indexOf(" м"))))
            .reduce(0, Integer::sum);

        return new ResponseEntity<>(SuccessResponse.builder().data(TimeSpendResp.builder().filmCount(filmsCount).spendingTime(timeSpendForFilms).build()).build(), HttpStatus.OK);
    }
}

