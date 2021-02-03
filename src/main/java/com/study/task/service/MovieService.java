package com.study.task.service;

import com.study.task.domain.movie.MovieGroup;
import com.study.task.domain.movie.dto.ResponseMovieApiDto;
import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import com.study.task.repoisotry.MovieRepository;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Cacheable(value = "cache::movie::query")
    public List<ResponseMovieClientDto> search(final String query){
        log.info("MovieService search 메소드 실행");
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getListOrderRating();
    }



}
