package com.study.task.repoisotry;

import com.study.task.config.NaverProperties;
import com.study.task.domain.book.dto.ResponseBookApiDto;
import com.study.task.domain.book.dto.ResponseBookClientDto;
import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final RestTemplate restTemplate;
    private final NaverProperties naverProperties;

    @Override
    public List<ResponseBookApiDto> findByQuery(String query) {

        WebClient webClient = WebClient.create(naverProperties.getBookUrl());

        List<ResponseBookApiDto> block = webClient.get()
            .uri("?query={query}", query)
            .headers(headers -> {
                headers.add("X-Naver-Client-Id", naverProperties.getClientId());
                headers.add("X-Naver-Client-Secret", naverProperties.getClientSecret());
                headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            })
            .retrieve()
            .bodyToFlux(ResponseBookApiDto.class)
            .collectList()
            .block();
        return block;
    }
}
