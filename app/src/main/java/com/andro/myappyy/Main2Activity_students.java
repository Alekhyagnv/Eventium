package com.andro.myappyy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity_students extends AppCompatActivity {
    CardView cd3,cd4,cd5,cd6,cd7;


    FirebaseAuth auth;
    DatabaseReference ref;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_students);
        cd3=(CardView)findViewById(R.id.cd3_stu);
        cd4=(CardView)findViewById(R.id.cd4_stu);
        cd5=(CardView)findViewById(R.id.cd5_stu);
        cd6=(CardView)findViewById(R.id.cd6_stu);
        cd7=(CardView)findViewById(R.id.cd7_stu);


        FirebaseAuth auth1=FirebaseAuth.getInstance();

        String uid= auth1.getCurrentUser().getUid();

        ref= FirebaseDatabase.getInstance().getReference().child("users");

        ref.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    if(dataSnapshot.hasChild("type"))
                    {
                        type=dataSnapshot.child("type").getValue().toString();
                    }


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String temp="FACULTY";
                if(type.equals(temp))
                {
                    Intent intent=new Intent(Main2Activity_students.this,faculty_options.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(Main2Activity_students.this,Main3activityand_retrieve_student.class);
                    startActivity(intent);

                }


            }
        });
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String temp="FACULTY";
                if(type.equals(temp))
                {
                    Intent intent=new Intent(Main2Activity_students.this,Malai_options.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(Main2Activity_students.this,Main3Activitymalai_retrieve_student.class);
                    startActivity(intent);
                }

            }
        });
        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String temp="FACULTY";
                if(type.equals(temp))
                {
                    Intent intent=new Intent(Main2Activity_students.this,Iot_options.class);
                    startActivity(intent);
                }
                else{
                Intent intent=new Intent(Main2Activity_students.this,Main3Activity_iot_retrieve_student.class);
                startActivity(intent);}
            }
        });
        cd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String temp="FACULTY";
                if(type.equals(temp))
                {
                    Intent intent=new Intent(Main2Activity_students.this,Web_options.class);
                    startActivity(intent);
                }
                else{
                Intent intent=new Intent(Main2Activity_students.this,Main3Activity_web_retrieve_student.class);

                startActivity(intent);}
            }
        });
        cd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String temp="FACULTY";
                if(type.equals(temp))
                {
                    Intent intent=new Intent(Main2Activity_students.this,Dsc_options.class);
                    startActivity(intent);
                }else{
                Intent intent=new Intent(Main2Activity_students.this,Main3Activity_dsc_retrieve_student.class);
                startActivity(intent);}
            }
        });
    }
}
