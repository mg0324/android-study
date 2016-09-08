package com.mg.android.utils;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by meigang on 16/9/8.
 */
public class MGUtils {
    /**
     * 吐司显示
     * @param c
     * @param msg
     */
    public static void showToast(Context c,String msg){
        Looper.prepare();
        Toast.makeText(c,msg,Toast.LENGTH_LONG).show();
        Looper.loop();
    }
}
