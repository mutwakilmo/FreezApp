package com.mutwakilmo.android.freezapp;

import android.content.Context;

import androidx.loader.content.AsyncTaskLoader;

/**
 * Created by Mutwakil Mo on dzzczecae
 */
public class MyAsyncTaskLoader extends AsyncTaskLoader<Long> {

    public MyAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public Long loadInBackground() {
        return Utils.executeLongActionDuring5seconds();
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }


}