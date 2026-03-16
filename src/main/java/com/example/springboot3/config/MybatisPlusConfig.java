package com.example.springboot3.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MybatisPlusConfig {

    /**
     * 配置 MyBatis-Plus 插件主体
     * 这里演示了多种常用插件的配置方法
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {

        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        // 1. 分页插件 (必须配置)
        // 由于引入了 mybatis-plus-jsqlparser，分页插件可以正常工作
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL); // 请替换为实际的数据库类型
        // 设置单页最大条数，-1 为不受限制
        paginationInnerInterceptor.setMaxLimit(1000L);
        // 当页数超出范围时是否自动回滚到第一页，true 为是
        paginationInnerInterceptor.setOverflow(false);
        interceptor.addInnerInterceptor(paginationInnerInterceptor);

        // 2. 乐观锁插件 (可选)
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());

        // 3. 防止全表更新/删除插件 (可选，强烈推荐)
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());

        // 4. 动态表名插件 (可选)
        // DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();
        // dynamicTableNameInnerInterceptor.setTableNameHandler((sql, tableName) -> {
        //     // 处理表名逻辑
        //     return tableName;
        // });
        // interceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);

        // 5. SQL 性能规范插件 (可选，用于输出不规范SQL的警告日志)
        // interceptor.addInnerInterceptor(new IllegalSQLInnerInterceptor());

        return interceptor;
    }


    @Bean
    public MybatisSqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        // 其他配置...
        return sessionFactory;
    }
    // 如果有需要，也可以在这里配置其他的 Bean，如 IdentifierGenerator 等

}
