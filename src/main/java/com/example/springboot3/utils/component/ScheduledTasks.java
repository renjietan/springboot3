package com.example.springboot3.utils.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    /**
     * 固定延时任务：每次执行后等待 5 秒再执行下一次
     * @Async 使该方法异步执行，不会阻塞调度线程
     */
    @Async
    @Scheduled(fixedDelay = 5000)
    public void task1() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        logger.info("Task1 线程: {}, 开始时间: {}", threadName, LocalDateTime.now());
        // 模拟耗时 3 秒的业务逻辑
        TimeUnit.SECONDS.sleep(3);
        logger.info("Task1 线程: {}, 结束时间：{}", threadName, LocalDateTime.now());
    }

    /**
     * 固定速率任务：每 5 秒执行一次，与上一次开始时间无关
     */
    @Async
    @Scheduled(fixedRate = 5000)
    public void task2() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        logger.info("Task2 线程: {}, 开始时间：{}", threadName, LocalDateTime.now());
        TimeUnit.SECONDS.sleep(2);
        logger.info("Task2 线程: {}, 结束时间：{}", threadName, LocalDateTime.now());
    }

    /**
     * Cron 表达式任务：每分钟的第 0、10、20、30、40、50 秒执行
     */
    @Async
    @Scheduled(cron = "0,10,20,30,40,50 * * * * ?")
    public void task3() {
        String threadName = Thread.currentThread().getName();
        logger.info("Task3 线程: {}, 执行于: {}", threadName, LocalDateTime.now());
    }
}