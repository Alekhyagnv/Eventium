package com.example.myappyy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    CardView cd3,cd4,cd5,cd6,cd7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cd3=(CardView)findViewById(R.id.cd3);
        cd4=(CardView)findViewById(R.id.cd4);
        cd5=(CardView)findViewById(R.id.cd5);
        cd6=(CardView)findViewById(R.id.cd6);
        cd7=(CardView)findViewById(R.id.cd7);


        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,faculty_options.class);
                startActivity(intent);
            }
        });
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,Malai_options.class);
                startActivity(intent);
            }
        });
        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,Iot_options.class);
                startActivity(intent);
            }
        });
        cd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,Web_options.class);
                startActivity(intent);
            }
        });
        cd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,Dsc_options.class);
                startActivity(intent);
            }
        });
    }
}
