package com.study.task.domain.movie;

import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MovieGroup {

    private final List<ResponseMovieClientDto> list;
    private final static int AVERAGE_USER_RATING_TOP_NUM = 2;

    //내림차순 정렬
    public List<ResponseMovieClientDto> getListOrderRating(){
        return list.stream()
            .filter(b -> !((Float)b.getUserRating()).equals(0.0f)) //평점이 0인 데이터 제거
            .sorted((a,b) -> a.getUserRating() > b.getUserRating() ? -1 : 1)
            .collect(Collectors.toList());
    }


}
