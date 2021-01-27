package com.study.task.util;

import com.study.task.controller.MovieController;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Slf4j
@Component
public class ScheduleTask {

    //10분마다 실행
    @Scheduled(cron = "${cron.expression}")
    public void cacheDataInit(){
        MovieController.memoryMovies.clear();
    }
}
