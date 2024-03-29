
package com.deepaliverma.jobscheduler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final int JOB_ID=123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void scheduleJob(View view){
        JobScheduler jobScheduler=(JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);
        JobInfo jobInfo=new JobInfo.Builder(JOB_ID,new ComponentName(this,DemoJob.class))
                .setPeriodic(120000,600000)
                .setPersisted(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setRequiresCharging(true)
                                   .build();
                jobScheduler.schedule(jobInfo);

    }
}