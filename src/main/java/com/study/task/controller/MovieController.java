package com.study.task.controller;

import com.study.task.domain.movie.dto.CashingMovieDto;
import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import com.study.task.exception.BadRequestQueryEmptyException;
import com.study.task.service.MovieService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/search")
public class MovieController {

    private final MovieService movieService;

    //캐싱 역할
    public static final List<CashingMovieDto> memoryMovies = new ArrayList<>();

    @GetMapping("/movies")
    public List<ResponseMovieClientDto> getMoviesByQuery(@RequestParam(name = "q") String query) {
        if (StringUtils.isEmpty(query)) {
            log.info("========== 빈 쿼리값 ==========");
            throw new BadRequestQueryEmptyException();
        }

        //캐싱 꺼낸후...
        List<CashingMovieDto> cashingPull = cashingDataSearch(query);

        //캐싱이 비어있지 않다면
        if (!cashingPull.isEmpty()) {
            log.info("========== 영화 검색 결과 캐싱값 반환 ==========");
            List<ResponseMovieClientDto> list = new ArrayList<>();

            cashingPull.stream()
                .forEach(s -> {
                    list.add(ResponseMovieClientDto.builder()
                        .title(s.getTitle())
                        .link(s.getLink())
                        .userRating(s.getUserRating())
                        .build());
                });
            return list;
        }

        //movieService.search 가는 순간 API 호출
        List<ResponseMovieClientDto> movieDtoList = movieService.search(query);
        cashingDataSave(query, movieDtoList);

        return movieDtoList;
    }

    //네이버 API 검색결과 캐싱에 저장
    public static void cashingDataSave(String query, List<ResponseMovieClientDto> movieDtoList) {
        log.info("========== 영화 검색 API 결과 반환 후 캐싱에 저장 ==========");
        for (ResponseMovieClientDto dto : movieDtoList) {
            memoryMovies.add(
                CashingMovieDto.builder()
                    .keyword(query) //검색 키워드도 함께 저장
                    .title(dto.getTitle())
                    .link(dto.getLink())
                    .userRating(dto.getUserRating())
                    .build()
            );
        }
    }

    //캐싱에서 특정 키워드를 검색 후 해당 데이터 반환
    private List<CashingMovieDto> cashingDataSearch(String query) {
        return memoryMovies.stream()
            .filter(s -> s.getKeyword().equals(query))
            .collect(Collectors.toCollection(ArrayList::new));
    }

}
