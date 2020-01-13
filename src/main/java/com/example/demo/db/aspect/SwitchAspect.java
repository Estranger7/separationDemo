package com.example.demo.db.aspect;

import com.example.demo.db.bean.DbContextHolder;
import com.example.demo.db.bean.DbEnum;
import com.example.demo.db.config.SwitchDs;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by michangtao in 2020/1/9 15:01
 */
@Component
@Aspect
@Order(value = -10)
public class SwitchAspect {

   @Pointcut("@annotation(com.example.demo.db.config.SwitchDs)")
    public void dsPointCut(){

   }

   @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint joinPoint){
       MethodSignature signature = (MethodSignature) joinPoint.getSignature();
       Method method = signature.getMethod();
       SwitchDs annotation = method.getAnnotation(SwitchDs.class);

       if(annotation == null){//说明未加注解，就默认db1，本项目这层判断不会进
           DbContextHolder.setDbType(DbEnum.db1.getValue());
       }else{//加了注解，就取注解上定义的db
           DbContextHolder.setDbType(annotation.name().getValue());
       }
       Object proceed = null;
       try {
           proceed = joinPoint.proceed();
       } catch (Throwable throwable) {
           throwable.printStackTrace();
       }finally {
           DbContextHolder.clearDbType();//清除数据源
       }
       return proceed;
   }


}
