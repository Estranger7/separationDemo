package com.example.demo.db.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.example.demo.db.bean.DbEnum;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by michangtao in 2020/1/9 10:47
 */
@Configuration
public class MybatisConfig {

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;
    @Value("${mybatis.type-aliases-package}")
    private String typeAliasPackage;


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.db1")
    public DataSource db1(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.db2")
    public DataSource db2(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置动态datasource
        sqlSessionFactoryBean.setDataSource(dataSource());
        //设置bean包扫描路径
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
        //设置xml包扫描路径
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));
        return sqlSessionFactoryBean;
    }

    /**
     * 动态数据源配置
     */
    @Bean
    @Primary
    public DataSource dataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object,Object> targetDataSources = new HashMap();

        //
        System.out.println("db1创建成功："+db1());
        System.out.println("db2创建成功："+db2());

        //添加数据源
        targetDataSources.put(DbEnum.db1.getValue(),db1());
        targetDataSources.put(DbEnum.db2.getValue(),db2());
        dynamicDataSource.setTargetDataSources(targetDataSources);
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(db1());
        return dynamicDataSource;
    }

}
