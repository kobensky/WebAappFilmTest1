package com.example.webaappfilmtest1.service;

import com.example.webaappfilmtest1.api.FilmReq;
import com.example.webaappfilmtest1.response.Response;
import com.example.webaappfilmtest1.response.exception.CommonException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface FilmService {
    ResponseEntity<Response> allSpendTimeForFilms(FilmReq req) throws IOException, CommonException;
}
