package com.example.springboot3.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.lang.reflect.Method;
import java.util.Arrays;


// @Async 方法不能是 private，否则异步代理无法生效。
// @Async 方法返回值必须是 void 或 Future，此处使用 void。
// 如果任务抛出异常，@Async 默认不会影响调度线程，但异常日志可能丢失，建议在方法内部处理或配置全局异步异常处理器。
// 此处主要用于 #####异步的定时任务#####
@Configuration
public class AsyncExceptionConfig implements AsyncConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(AsyncExceptionConfig.class);
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (Throwable ex, Method method, Object... params) -> {
            logger.error("异步方法 {} 执行异常，参数: {}", method.getName(), Arrays.toString(params), ex);
        };
    }
}
