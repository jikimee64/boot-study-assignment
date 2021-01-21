package com.study.task.domain.movie;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;

import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import com.study.task.repoisotry.MovieRepository;
import com.study.task.service.MovieService;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MovieGroupTest {

    //MovieRepository를 Mock 객체로 만들어줌
    @Mock
    private MovieRepository movieRepository;

    List<ResponseMovieClientDto> list;

    //@BeforeEach
    void beforeEach() {
        list = List.of(
            ResponseMovieClientDto.builder().title("영화1").link("링크1").userRating(9.5f).build(),
            ResponseMovieClientDto.builder().title("영화2").link("링크2").userRating(9.7f).build(),
            ResponseMovieClientDto.builder().title("영화3").link("링크3").userRating(9.4f).build()
        );
    }

    //@Test
    @DisplayName("평점 내림차순")
    void orderRating(){
        MovieGroup movieGroup = new MovieGroup(list);
        List<ResponseMovieClientDto> listOrderRating = movieGroup.getListOrderRating();

        Float aFloat = listOrderRating.stream()
            .map(ResponseMovieClientDto::getUserRating)
            .max(Float::compareTo)
            .orElseThrow(NoSuchElementException::new);

        assertThat(aFloat).isEqualTo(9.7f);
    }






}