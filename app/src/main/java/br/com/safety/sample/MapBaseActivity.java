package br.com.safety.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MapBaseActivity extends AppCompatActivity {

    private Button buttonLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//

        buttonLocation = (Button) findViewById(R.id.btn_location);

        buttonLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* locationTracker = new LocationTracker("my.action")
                        .setInterval(1000)
                        .setGps(true)
                        .setNetWork(false)
                        .start(getBaseContext());*/
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
