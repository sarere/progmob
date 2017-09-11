package id.ac.ukdw.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnPindah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPindah = (Button) findViewById(R.id.btnPindah);

        btnPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pindahHal();
            }
        });
    }

    public void pindahHal(){
        Intent intent = new Intent(this, HalamanDuaActivity.class);
//        ngirim text
//        intent.putExtra("kode_user","rere");
//        intent.putExtra("id_user",1);
        startActivity(intent);
    }
}
