package com.example.myappyy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Chapters_student extends AppCompatActivity {

    CardView cd3,cd4,cd5,cd6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters_student);
        cd3=(CardView)findViewById(R.id.cdieee_stu);
        cd4=(CardView)findViewById(R.id.cdcsi_stu);
        cd5=(CardView)findViewById(R.id.cdiste_stu);
        cd6=(CardView)findViewById(R.id.cdacm_stu);



        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Chapters_student.this,Main3activityieee_retrieve_student.class);
                startActivity(intent);
            }
        });
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Chapters_student.this,Main3Activitycsi_retrieve_student.class);
                startActivity(intent);
            }
        });
        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Chapters_student.this,Main3activityiste_retrieve_student.class);
                startActivity(intent);
            }
        });
        cd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Chapters_student.this,Main3Activity_acm_retrieve_student.class);
                startActivity(intent);
            }
        });

    }
}
