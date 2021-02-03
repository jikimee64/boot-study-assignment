package com.study.task.controller;

import com.study.task.domain.movie.dto.CashingMovieDto;
import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import com.study.task.exception.BadRequestQueryEmptyException;
import com.study.task.service.MovieService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
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

    @GetMapping("/movies")
    public List<ResponseMovieClientDto> getMoviesByQuery(@RequestParam(name = "q") String query) {
        if (StringUtils.isEmpty(query)) {
            log.info("========== 빈 쿼리값 ==========");
            throw new BadRequestQueryEmptyException();
        }
        return movieService.search(query);
    }

}
