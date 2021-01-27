package com.study.task.util;

import com.study.task.controller.MovieController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ScheduleTask {

    //10분마다 실행
    @Scheduled(cron = "0 0/10 * * * *")
    public void cacheDataInit(){
        MovieController.memoryMovies.clear();
    }
}
