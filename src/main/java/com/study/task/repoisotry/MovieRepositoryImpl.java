package com.study.task.repoisotry;


import com.study.task.config.NaverProperties;
import com.study.task.domain.movie.dto.ResponseMovieApiDto;
import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import com.study.task.exception.BadRequestQueryEmptyException;
import com.study.task.exception.NaverApiUnauthorizedException;
import com.study.task.exception.NavereApiErrorException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {

    private final RestTemplate restTemplate;
    private final NaverProperties naverProperties;

    @Override
    public List<ResponseMovieClientDto> findByQuery(String query) {

        HttpHeaders httpHeaders = naverProperties.getHttpHeaders();

        List<ResponseMovieClientDto> collect = null;

        try {
            String url = naverProperties.getMovieUrl() + "?query=" + query;

            collect = restTemplate
                .exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders),
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
        }catch(HttpClientErrorException e){
            log.info("========== 네이버 오픈 API 인증 실패 에러 ==========");
            throw new NaverApiUnauthorizedException();
        }catch(Exception e){
            log.info("========== 네이버 오픈 API 통신 알수 없는 에러 ==========");
            throw new NavereApiErrorException();
        }

        return collect;

    }

}
