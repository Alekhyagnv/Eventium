package com.example.myappyy;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Android_details_student extends AppCompatActivity {

    TextView t1,t2,t3,t4;
    ImageView i1;
    Button b1;

    String s1,s2,s3,s4,s5,s6,s7;

    DatabaseReference database;

    FirebaseAuth auth;
    String uid;

    Button edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_details_student);
        final View parentLayout = findViewById(android.R.id.content);
        auth=FirebaseAuth.getInstance();
        uid=auth.getCurrentUser().getUid();
        database=FirebaseDatabase.getInstance().getReference().child("attendance");



        s1=getIntent().getStringExtra("a1");
        s2=getIntent().getStringExtra("a2");
        s3=getIntent().getStringExtra("a3");
        s4=getIntent().getStringExtra("a4");
        s5=getIntent().getStringExtra("a5");
        s6=getIntent().getStringExtra("a6");

        b1=findViewById(R.id.attendance_btn);

        edit=findViewById(R.id.edit_post);

        if(uid.equals(s6))
        {
            edit.setVisibility(View.VISIBLE);
        }


        t1=(TextView)findViewById(R.id.as11);
        t2=(TextView)findViewById(R.id.as21);
        t3=(TextView)findViewById(R.id.as31);
        t4=(TextView)findViewById(R.id.as41);
        i1=(ImageView)findViewById(R.id.as51);

        database.child(s1).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                {
                    int count= (int) dataSnapshot.getChildrenCount();
                    String s1=String.valueOf(count);
                   Snackbar.make(parentLayout,"No of students registered "+s1,Snackbar.LENGTH_LONG).setAction("Action",null).show();
                    //Toast.makeText(Android_details_student.this,"No of students registered "+s1,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

       /* edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"edit clicked",Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
        });*/



       /* Toast.makeText(Android_details.this,s1,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s2,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s3,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s4,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s5,Toast.LENGTH_LONG).show();*/






        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s4);

        Picasso.get().load(s5).into(i1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Android_details_student.this,Student_attendance.class);
                intent.putExtra("eventname",s1);

                startActivity(intent);

            }
        });



    }
}
