package id.ac.ukdw.intent;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

/**
 * Created by mahasiswa on 9/11/17.
 */

public class WifiCheckerReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent i) {
        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(context);
        nBuilder.setSmallIcon(R.mipmap.ic_launcher_round,5);
        nBuilder.setContentTitle("Warning");
        nBuilder.setContentText("Your Connection Changing");

        Intent intent = new Intent(context,HalamanDuaActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                1,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        nBuilder.setContentIntent(pendingIntent);
        NotificationManager nManager = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);

        nManager.notify(1,nBuilder.build());
    }
}
