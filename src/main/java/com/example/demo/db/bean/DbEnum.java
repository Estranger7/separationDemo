package com.example.demo.db.bean;

/**
 * Created by michangtao in 2020/1/9 14:37
 */
public enum DbEnum {

    db1("db1"),db2("db2");

    private String value;

    public String getValue() {
        return value;
    }

    DbEnum(String value){
        this.value = value;
    }

}
