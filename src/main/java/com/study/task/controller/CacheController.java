package com.study.task.controller;

import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import com.study.task.dto.CommonResponse;
import com.study.task.exception.ErrorCode;
import com.study.task.service.MovieService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cache")
public class CacheController {

    private final MovieService movieService;


    @PutMapping("/update")
    public ResponseEntity<CommonResponse> getMoviesByQuery(@RequestParam(name = "q") String query) {

        List<ResponseMovieClientDto> list = movieService.search(query);

        if(!StringUtils.isEmpty(list)){
            MovieController.cashingDataSave(query, list);
            return new ResponseEntity<>(
                CommonResponse.builder()
                    .code("200")
                    .message("캐싱 업데이트 완료")
                    .build(),
                HttpStatus.OK);
        }else{
            return new ResponseEntity<>(
                CommonResponse.builder()
                    .code("424")
                    .message("검색된 영화가 없어 캐싱하지 않았습니다.")
                    .build(),
                HttpStatus.EXPECTATION_FAILED);
        }







    }

}
