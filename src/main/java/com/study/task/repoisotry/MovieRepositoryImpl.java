package com.study.task.repoisotry;

import com.study.task.config.NaverProperties;
import com.study.task.domain.movie.dto.ResponseMovieApiDto;
import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {

    private final RestTemplate restTemplate;
    private final NaverProperties naverProperties;

    @Override
    public List<ResponseMovieClientDto> findByQuery(String query) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-CLient-Id", naverProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverProperties.getClientSecret());

        String url = naverProperties.getMovieUrl() + "?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders),
            ResponseMovieApiDto.class)
            .getBody()
            .getItems()
            .stream()
            .map(m -> ResponseMovieClientDto.builder()
                .title(m.getTitle())
                .link(m.getLink())
                .userRating(m.getUserRating())
                .build())
            .collect(Collectors.toList());
    }


}
