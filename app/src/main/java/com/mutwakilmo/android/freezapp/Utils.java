package com.mutwakilmo.android.freezapp;

import android.util.Log;

/**
 * Created by Mutwakil Mo on 2222222
 */
public class Utils {

    public static Long executeLongActionDuring5seconds(){

        Log.e("TAG", "Long action is starting...");
        Long endTime = System.currentTimeMillis() + 7000;
        while (System.currentTimeMillis() <  endTime) {
            //Loop during 7 secs hehehe...
        }
        Log.e("TAG", "Long action is finished !");

        return endTime;
    }
}
