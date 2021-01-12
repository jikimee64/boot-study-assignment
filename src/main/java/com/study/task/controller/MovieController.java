package com.study.task.controller;

import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import com.study.task.service.MovieService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/search")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies")
    public List<ResponseMovieClientDto> getMoviesByQuery(@RequestParam(name = "q") String query){
        return movieService.search(query);
    }

}
