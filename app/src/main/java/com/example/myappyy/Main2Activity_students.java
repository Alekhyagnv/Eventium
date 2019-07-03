package com.example.myappyy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Main2Activity_students extends AppCompatActivity {
    CardView cd3,cd4,cd5,cd6,cd7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_students);
        cd3=(CardView)findViewById(R.id.cd3_stu);
        cd4=(CardView)findViewById(R.id.cd4_stu);
        cd5=(CardView)findViewById(R.id.cd5_stu);
        cd6=(CardView)findViewById(R.id.cd6_stu);
        cd7=(CardView)findViewById(R.id.cd7_stu);


        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity_students.this,Main3activityand_retrieve_student.class);
                startActivity(intent);
            }
        });
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity_students.this,Main3Activitymalai_retrieve_student.class);
                startActivity(intent);
            }
        });
        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity_students.this,Main3Activity_iot_retrieve_student.class);
                startActivity(intent);
            }
        });
        cd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity_students.this,Main3Activity_web_retrieve_student.class);

                startActivity(intent);
            }
        });
        cd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity_students.this,Main3Activity_dsc_retrieve_student.class);
                startActivity(intent);
            }
        });
    }
}
