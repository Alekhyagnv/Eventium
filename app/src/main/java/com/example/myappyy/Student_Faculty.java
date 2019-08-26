package com.example.myappyy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Student_Faculty extends AppCompatActivity {
    Toolbar toolbar;
    Button c1,c2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__faculty);
        c1=(Button) findViewById(R.id.c1);
        c2=(Button) findViewById(R.id.c2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MyAppy");

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Student_Faculty.this,student_login.class);
                startActivity(intent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Student_Faculty.this,student_login.class);
                startActivity(intent);
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
            String uid=firebaseUser.getUid();

            DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Users").child(uid);

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists())
                    {
                        if(dataSnapshot.hasChild("type"))
                        {
                            String temp=dataSnapshot.child("type").getValue().toString();
                            String t1="STUDENT";
                            if(temp.equals(t1))
                            {
                                Intent intent=new Intent(Student_Faculty.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                        else
                        {
                            Intent intent=new Intent(Student_Faculty.this,MainActivity_faculty.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });





        }
    }


}
