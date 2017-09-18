package id.ac.ukdw.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

/**
 * Created by mahasiswa on 9/18/17.
 */

public class HelloService extends JobService {
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            Toast.makeText(getApplicationContext(), "Hello Word", Toast.LENGTH_SHORT).show();

            jobFinished((JobParameters)message.obj,false);
            return true;
        }
    });
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        handler.sendMessage(Message.obtain(handler,1,jobParameters));
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        handler.removeMessages(1);
        return false;
    }
}
