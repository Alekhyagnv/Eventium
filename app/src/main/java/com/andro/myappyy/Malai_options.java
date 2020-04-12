package com.andro.myappyy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class Malai_options extends AppCompatActivity {

    LinearLayout cd1,cd2;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malai_options);
        cd1=findViewById(R.id.cd_malai);
        cd2=findViewById(R.id.cd2_malai);

        auth=FirebaseAuth.getInstance();









        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Malai_options.this,Main3Activitymalai.class);
                startActivity(intent);
            }
        });
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Malai_options.this,Main3Activitymalai_retrieve.class);
                startActivity(intent);
            }
        });
    }


}
