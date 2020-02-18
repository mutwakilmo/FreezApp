package com.mutwakilmo.android.freezapp.Utils;

import android.content.Context;

import androidx.loader.content.AsyncTaskLoader;

/**
 * Created by Mutwakil Mo on dzzczecae
 */
public class MyAsyncTaskLoader extends AsyncTaskLoader<Long> {

    public MyAsyncTaskLoader(Context context) {
        super(context);
    }


    /*We put our lengthy task there in
    order to run it in a separate Thread*/
    @Override
    public Long loadInBackground() {
        return Utils.executeLongActionDuring5seconds();
    }


    /*
    It is re-declared in order to force the data to load,
     particularly after the loader is reinitialize
     */
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }


}