package com.andro.myappyy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class Cloud_options extends AppCompatActivity {
    LinearLayout cc1,cc2;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud_options);
        cc1 = findViewById(R.id.cc_anim);
        cc2 = findViewById(R.id.cc2_anim);
        auth=FirebaseAuth.getInstance();
        cc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Cloud_options.this,Main3Activitycloud.class);
                startActivity(intent);
            }
        });
        cc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Cloud_options.this,Main3Activitycloud_retrieve.class);
                startActivity(intent);
            }
        });
    }
}
