package id.ac.ukdw.intent;

import android.app.NotificationManager;
import android.icu.text.Normalizer;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mahasiswa on 9/11/17.
 */

public class HalamanDuaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_dua);

        NotificationManager nManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nManager.cancel(1);
    }
}
