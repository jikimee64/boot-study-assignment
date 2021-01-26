package com.study.task.domain.movie.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CashingMovieDto {
    @JsonIgnore
    private String keyword;
    private String title;
    private String link;
    private float userRating;
}
