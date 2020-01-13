package com.example.demo.db.config;

import com.example.demo.db.bean.DbEnum;

import java.lang.annotation.*;

/**
 * Created by michangtao in 2020/1/9 14:28
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SwitchDs {

//    String name() default "";

    DbEnum name();

}
