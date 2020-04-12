package com.andro.myappyy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Main3Activitychapters extends AppCompatActivity {

    CardView cd3,cd4,cd5,cd6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_activitychapters);
        cd3=(CardView)findViewById(R.id.cdieee);
        cd4=(CardView)findViewById(R.id.cdcsi);
        cd5=(CardView)findViewById(R.id.cdiste);
        cd6=(CardView)findViewById(R.id.cdacm);



        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main3Activitychapters.this,Ieee_options.class);
                startActivity(intent);
            }
        });
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main3Activitychapters.this,Csi_options.class);
                startActivity(intent);
            }
        });
        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main3Activitychapters.this,Iste_options.class);
                startActivity(intent);
            }
        });
        cd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main3Activitychapters.this,Acm_options.class);
                startActivity(intent);
            }
        });

    }
}
