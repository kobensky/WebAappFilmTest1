package com.example.webaappfilmtest1.controller;

import com.example.webaappfilmtest1.api.FilmReq;
import com.example.webaappfilmtest1.response.Response;
import com.example.webaappfilmtest1.response.constants.Code;
import com.example.webaappfilmtest1.response.exception.CommonException;
import com.example.webaappfilmtest1.service.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("WebAappFilmTest1")
public class Controller {

    private final FilmService filmService;

    @GetMapping("/hello")
    public String hello() {
        String hello = "Hello. this is film service Version: 1.0.0";
        log.info(hello);
        return hello;
    }

    @GetMapping("/time_stats")
    public ResponseEntity<Response> allSpendTimeForFilms (@RequestBody final FilmReq req) throws CommonException {
        ResponseEntity<Response> response = null;
        try {
            response = filmService.allSpendTimeForFilms(req);
        } catch (IOException | CommonException e) {
            throw CommonException.builder()
                    .code(Code.UNKNOWN_CONNECTION)
                    .message("Ссылка не действительна")
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }
        return response;
    }
}
