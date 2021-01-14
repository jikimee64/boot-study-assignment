package com.study.task.repoisotry;

import com.study.task.domain.book.dto.ResponseBookApiDto;
import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository {
    List<ResponseBookApiDto> findByQuery(String query);
}
