package com.delaroystudios.alarmreminder.reminder;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.delaroystudios.alarmreminder.Gallery.ActivityRicordo;
import com.delaroystudios.alarmreminder.MainActivity;
import com.delaroystudios.alarmreminder.R;



/**
 * Created by franc on 12/02/2018.
 */

public class ActivityPrincipale  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.menu_scelta);

        Button btn = (Button)findViewById(R.id.button_eventi);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(ActivityPrincipale.this, MainActivity.class);
                ActivityPrincipale.this.startActivity(myIntent);
            }
        });

        Button btn1   = (Button) findViewById(R.id.button_ricordi);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(ActivityPrincipale.this, ActivityRicordo.class);
                ActivityPrincipale.this.startActivity(myIntent);
            }
        });
    }
}