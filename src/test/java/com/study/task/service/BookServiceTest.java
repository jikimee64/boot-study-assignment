package com.study.task.service;

import static org.junit.jupiter.api.Assertions.*;

import com.study.task.config.NaverProperties;
import com.study.task.domain.book.dto.ResponseBookClientDto;
import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(properties = "spring.config.location=" +
    "classpath:/application.yml" +
    ",classpath:/application-secret.yml")
class BookServiceTest {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NaverProperties naverProperties;

    @Autowired
    private BookService bookService;

    @Test
    @DisplayName("Client 응답 데이터 검증")
    void search() {

        String query = "자바의 정석";

        List<ResponseBookClientDto> search = bookService.search(query);

        search.forEach( s ->
            assertAll(
                () -> assertNotNull(s.getTitle()),
                () -> assertNotNull(s.getLink()),
                () -> assertNotNull(s.getAuthor()),
                () -> assertNotNull(s.getDiscount()),
                () -> assertNotNull(s.getPrice())
            )
        );

    }
}