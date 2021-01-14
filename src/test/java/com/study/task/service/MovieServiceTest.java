package com.study.task.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.study.task.config.NaverProperties;
import com.study.task.domain.movie.dto.ResponseMovieApiDto;
import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;


@SpringBootTest(properties = "spring.config.location=" +
    "classpath:/application.yml" +
    ",classpath:/application-secret.yml")
class MovieServiceTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NaverProperties naverProperties;

    @Autowired
    private MovieService movieService;

    @Test
    @DisplayName("API 응답 데이터 검증")
    void findAllApiRes() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-CLient-Id", naverProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverProperties.getClientSecret());

        String query = "반지의 제왕";

        String url = naverProperties.getMovieUrl() + "?query=반지의제왕";

        ResponseMovieApiDto body = restTemplate
            .exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders),
                ResponseMovieApiDto.class)
            .getBody();

        assertNotNull(body.getDisplay());
        assertNotNull(body.getItems());
        assertNotNull(body.getStart());
        assertNotNull(body.getLastBuildDate());
        assertNotNull(body.getTotal());
    }

    @Test
    @DisplayName("Client 응답 데이터 검증")
    void search() {

        String query = "반지의 제왕";

        List<ResponseMovieClientDto> search = movieService.search(query);

        search.forEach( s ->
            assertAll(
                () -> assertNotNull(s.getTitle()),
                () -> assertNotNull(s.getLink()),
                () -> assertNotNull(s.getUserRating())
            )
        );

    }
}