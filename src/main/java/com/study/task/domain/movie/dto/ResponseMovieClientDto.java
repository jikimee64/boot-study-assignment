package com.study.task.domain.movie.dto;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMovieClientDto implements Serializable {

    private String title;
    private String link;
    private float userRating;

}
