package com.tomise.meigang.sendargs;

import java.io.Serializable;

/**
 * Created by meigang on 16/9/5.
 */
public class User implements Serializable{
    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public User(String name,int age){
        this.name = name;
        this.age = age;
    }
}
