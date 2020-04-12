package com.andro.myappyy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class faculty_options extends AppCompatActivity {

   // Toolbar toolbar;
    LinearLayout cd1,cd2;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_options);
        cd1=findViewById(R.id.cd_and);
        cd2=findViewById(R.id.cd2_and);
        //toolbar = (Toolbar) findViewById(R.id.toolbar_android);
     //   setSupportActionBar(toolbar);
        auth=FirebaseAuth.getInstance();
      //  getSupportActionBar().setTitle("MyAppy");









        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(faculty_options.this,Main3Activityand.class);
                startActivity(intent);
            }
        });
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(faculty_options.this,Main3Activityand_retrieve.class);
                startActivity(intent);
            }
        });
    }


}
