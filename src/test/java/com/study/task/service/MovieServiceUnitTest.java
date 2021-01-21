package com.study.task.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import com.study.task.repoisotry.MovieRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Repository;

@ExtendWith(MockitoExtension.class)
public class MovieServiceUnitTest {

    @Mock
    private MovieRepository movieRepository;

    @Test
    @DisplayName("평점 내림차순")
    void shouldSortedInOrderOfGrade() {

        String query = "테스트 쿼리";
        String expectedUserRanking = "영화2"; //평점이 제일 높을 것으로 예상되는 영화명

        /**
         * 실제 findByQuery 메소드를 호출하는 것은 아니다.
         * findByQuery 메소드를 호출할 때 willReturn() 메서드 안에 있는 객체를 리턴한다는 뜻
         * 리턴하는 값도 가짜 객체이다. 왜냐하면 처음부터 실제객체를 사용한 적이 없기 때문이다.
         */
        given(movieRepository.findByQuery(anyString())).willReturn(getStubMovies());
        MovieService movieService = new MovieService(movieRepository);

        List<ResponseMovieClientDto> actualList = movieService.search(query);

        assertThat(expectedUserRanking)
            .isEqualTo(actualList.stream().findFirst().get().getTitle());

    }

    @Test
    @DisplayName("평점이 0인 데이터를 제외")
    void user_ratings_exclude_zero(){

        String query = "테스트 쿼리";
        int expectedMovieSize = 3;

        given(movieRepository.findByQuery(anyString())).willReturn(getStubMovies());
        MovieService movieService = new MovieService(movieRepository);

        List<ResponseMovieClientDto> actualList = movieService.search(query);

        assertThat(expectedMovieSize).isEqualTo(actualList.size());

    }

    List<ResponseMovieClientDto> getStubMovies() {
        return List.of(
            ResponseMovieClientDto.builder().title("영화1").link("링크1").userRating(9.5f).build(),
            ResponseMovieClientDto.builder().title("영화2").link("링크2").userRating(9.7f).build(),
            ResponseMovieClientDto.builder().title("영화3").link("링크3").userRating(9.4f).build(),
            ResponseMovieClientDto.builder().title("영화4").link("링크4").userRating(0.0f).build(),
            ResponseMovieClientDto.builder().title("영화5").link("링크5").userRating(0.0f).build()
        );
    }
}
