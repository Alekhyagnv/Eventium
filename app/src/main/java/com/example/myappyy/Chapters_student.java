package com.example.myappyy;

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

public class Chapters_student extends AppCompatActivity {

    CardView cd3,cd4,cd5,cd6;
    String type;
    FirebaseAuth auth;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters_student);
        cd3=(CardView)findViewById(R.id.cdieee_stu);
        cd4=(CardView)findViewById(R.id.cdcsi_stu);
        cd5=(CardView)findViewById(R.id.cdiste_stu);
        cd6=(CardView)findViewById(R.id.cdacm_stu);
        FirebaseAuth auth1=FirebaseAuth.getInstance();

        String uid= auth1.getCurrentUser().getUid();

        ref= FirebaseDatabase.getInstance().getReference().child("users");

        ref.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    type=dataSnapshot.child("type").getValue().toString();

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
                    Intent intent=new Intent(Chapters_student.this,Ieee_options.class);
                    startActivity(intent);
                }
                else{
                Intent intent=new Intent(Chapters_student.this,Main3activityieee_retrieve_student.class);
                startActivity(intent);}
            }
        });
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp="FACULTY";
                if(type.equals(temp))
                {
                    Intent intent=new Intent(Chapters_student.this,Csi_options.class);
                    startActivity(intent);
                }else{
                Intent intent=new Intent(Chapters_student.this,Main3Activitycsi_retrieve_student.class);
                startActivity(intent);}
            }
        });
        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp="FACULTY";
                if(type.equals(temp))
                {
                    Intent intent=new Intent(Chapters_student.this,Iste_options.class);
                    startActivity(intent);
                }else{
                Intent intent=new Intent(Chapters_student.this,Main3activityiste_retrieve_student.class);
                startActivity(intent);}
            }
        });
        cd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp="FACULTY";
                if(type.equals(temp))
                {
                    Intent intent=new Intent(Chapters_student.this,Acm_options.class);
                    startActivity(intent);
                }
                else{
                Intent intent=new Intent(Chapters_student.this,Main3Activity_acm_retrieve_student.class);
                startActivity(intent);}
            }
        });

    }
}
