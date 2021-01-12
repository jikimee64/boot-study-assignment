package com.study.task.domain.movie.dto;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Builder
@Getter
public class ResponseMovieClientDto implements Serializable {

    private String title;
    private String link;
    private float userRating;

}
