package id.ac.ukdw.intent;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotif = (Button) findViewById(R.id.btnNotif);

        btnNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification();
            }
        });
    }

    public void notification(){
        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this);
        nBuilder.setSmallIcon(R.mipmap.ic_launcher_round,5);
        nBuilder.setContentTitle("My GF");
        nBuilder.setContentText("Hi what are you doing now?");

        Intent intent = new Intent(this,HalamanDuaActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        nBuilder.setContentIntent(pendingIntent);
        NotificationManager nManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        nManager.notify(1,nBuilder.build());
    }
}