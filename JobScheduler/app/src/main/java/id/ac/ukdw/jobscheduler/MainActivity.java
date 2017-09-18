package id.ac.ukdw.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnStart;
    private Button btnStop;
    private JobScheduler jobScheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button)findViewById(R.id.btnStart);
        btnStop = (Button)findViewById(R.id.btnStop);
        jobScheduler = (JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startJob();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopJob();
            }
        });
    }

    private void startJob() {
        JobInfo.Builder builder = new JobInfo.Builder(
                1,
                new ComponentName(getPackageName(), HelloService.class.getName())
        );
        builder.setPeriodic(5*1000);
        jobScheduler.schedule(builder.build());
    }

    private void stopJob() {
        jobScheduler.cancelAll();
    }
}
