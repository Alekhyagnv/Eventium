package com.example.myappyy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main3Activity_welcome extends AppCompatActivity {
Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_welcome);

        b1=findViewById(R.id.Login);
        b2=findViewById(R.id.Register);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main3Activity_welcome.this,Loginpage.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main3Activity_welcome.this,student_register.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth auth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=auth.getCurrentUser();
        if(firebaseUser!=null)
        {

            Intent intent=new Intent(Main3Activity_welcome.this,Loginpage.class);
            startActivity(intent);
            finish();
        }
    }
}