package com.study.task.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RecodeAspectAop {

    @Around("@annotation(com.study.task.util.PerformanceTimeRecord)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");

        return proceed;
    }

}
