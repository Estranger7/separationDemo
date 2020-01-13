package com.example.demo.db.bean;

/**
 * Created by michangtao in 2020/1/9 14:47
 */
public class DbContextHolder {

    private static ThreadLocal<String> threadLocal = new ThreadLocal();

    /**
     * 设置数据源
     */
    public static void setDbType(String value){
        threadLocal.set(value);
    }

    /**
     * 取得数据源
     */
    public static String getDbType(){
        return threadLocal.get();
    }

    /**
     * 清除数据源
     */
    public static void clearDbType(){
        threadLocal.remove();
    }
}
