package com.tomise.meigang.learnapplication;

import android.app.Application;

/**
 * Created by meigang on 16/9/7.
 */
public class App extends Application{
    private String data = "default";

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
