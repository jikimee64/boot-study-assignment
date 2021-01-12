package com.study.task.repoisotry;

import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import java.util.List;

public interface MovieRepository {
    List<ResponseMovieClientDto> findByQuery(String query);
}
