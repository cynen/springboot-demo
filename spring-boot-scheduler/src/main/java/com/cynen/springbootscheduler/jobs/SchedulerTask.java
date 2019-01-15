package com.cynen.springbootscheduler.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

/**
 * 自定义的定时任务.
 * 需要交给Spring容器管理.
 */

@Component
public class SchedulerTask {
    int count = 0;

    // @Scheduled(cron="*/5 * * * * *")  // 每5秒执行一次
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
    }
}
