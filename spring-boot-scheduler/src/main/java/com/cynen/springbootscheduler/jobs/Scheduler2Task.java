package com.cynen.springbootscheduler.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 自定义的定时任务.
 * 需要交给Spring容器管理.
 */

/**
 * @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
 * @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
 * @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
 */
@Component
public class Scheduler2Task {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate=5000)  //出发了定时任务就开始倒计时
    private void process(){
        System.out.println("fixedRate 现在时间：" + dateFormat.format(new Date()));

        try {
            // 做一个延时任务.
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay=5000)  // 执行完成后,才开始倒计时
    private void process2(){
        System.out.println("fixedDelay 现在时间：" + dateFormat.format(new Date()));

        try {
            // 做一个延时任务.
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
