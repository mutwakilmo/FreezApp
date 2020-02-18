package com.mutwakilmo.android.freezapp.Utils;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.util.Log;

/**
 * Created by Mutwakil Mo on gbbf
 */
public class SyncJobService extends JobService implements MyAsyncTask.Listeners {
    private MyAsyncTask jobTask;
    private JobParameters jobParameters;

    @Override
    public boolean onStartJob(final JobParameters jobParameters) {
        Log.e(this.getClass().getSimpleName(), "SyncJob is started.");
        this.jobParameters = jobParameters;
        this.jobTask = new MyAsyncTask(this);
        this.jobTask.execute();
        return true;
    }

    @Override
    public boolean onStopJob(final JobParameters params) {
        Log.e(this.getClass().getSimpleName(), "SyncJob is stopped !");
        if (this.jobTask != null) this.jobTask.cancel(true);
        return false;
    }

    @Override
    public void onPreExecute() {  }

    @Override
    public void doInBackground() { }

    @Override
    public void onPostExecute(Long taskEnd) {
        Log.e("TAG", "Task ended at : "+taskEnd);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            jobFinished(jobParameters, false);
        }
    }
}
