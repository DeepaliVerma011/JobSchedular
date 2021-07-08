package com.deepaliverma.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class DemoJob extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        Toast.makeText(this,"Hello I m a scheduled job",Toast.LENGTH_SHORT).show();
        //Async Job
        // jobFinished(params,false);
        return false; //this true means there is work still going on so don't finish this service just yet
    }

    @Override
    public boolean onStopJob(JobParameters params) {
//false means you don't want to reschedule tha task
        return false;
    }
}
