package com.example.springboot3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableScheduling   // 启用定时任务
@EnableAsync        // 启用异步执行
public class SchedulerConfig {

    /**
     * 定时任务调度器线程池
     * 用于执行 @Scheduled 注解的任务
     */
    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(5);                     // 线程池大小，默认为1
        scheduler.setThreadNamePrefix("scheduler-");  // 线程名前缀
        scheduler.setAwaitTerminationSeconds(60);     // 关闭时等待任务完成的时间
        scheduler.setWaitForTasksToCompleteOnShutdown(true); // 关闭时等待正在执行的任务完成
        return scheduler;
    }

    /**
     * 异步执行线程池
     * 用于执行 @Async 注解的方法
     */
    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);                  // 核心线程数
        executor.setMaxPoolSize(10);                  // 最大线程数
        executor.setQueueCapacity(100);               // 队列容量
        executor.setKeepAliveSeconds(60);             // 空闲线程存活时间
        executor.setThreadNamePrefix("async-");       // 线程名前缀
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); // 拒绝策略
        executor.initialize();
        return executor;
    }
}
