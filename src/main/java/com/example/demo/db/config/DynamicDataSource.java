package com.example.demo.db.config;

import com.example.demo.db.bean.DbContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by michangtao in 2020/1/9 13:49
 * 动态数据源决策器
 *     由于我只在自定义注解(SwitchDs)上加了切点，切面监听到时会在上下文中塞入对应的数据源，此时DynamicDataSource才能从上下文中取到
 *     而正常的写库，使用的数据源是config创建dataSource时给定的默认数据源，并没有存放在上下文中，所以此处取不到
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        String dbType = DbContextHolder.getDbType();
        logger.info("当前所使用的数据源为：" + dbType);
        return dbType;
    }
}
