package com.andro.myappyy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Report extends AppCompatActivity {
    TextView t1, t2, t3, t5, t6, t7, t8, t9;
    String s1, s2, s3;
    ImageView i1;
    Button b1;
    DatabaseReference database, databaseReference;


    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        t1 = findViewById(R.id.t2_report);
        t3 = findViewById(R.id.as4_report);
        database = FirebaseDatabase.getInstance().getReference().child("attendance");
        b1 = findViewById(R.id.pie);
        t2 = findViewById(R.id.as2_report);
        t5 = findViewById(R.id.excellent_report);
        t6 = findViewById(R.id.vgood_report);
        t7 = findViewById(R.id.good_report);
        t8 = findViewById(R.id.avg_report);
        t9 = findViewById(R.id.poor_report);

        i1 = (ImageView) findViewById(R.id.img_report);
        s1 = getIntent().getStringExtra("name");
        s2 = getIntent().getStringExtra("date");
        s3 = getIntent().getStringExtra("image");
        t1.setText(s1);
        t2.setText(s2);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);





        databaseReference = FirebaseDatabase.getInstance().getReference().child("Feedback").child(s1);
        Picasso.get().load(s3).into(i1);
        database.child(s1).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    int count = (int) dataSnapshot.getChildrenCount();
                    String s1 = String.valueOf(count);
                    t3.setText(s1);
                    Toast.makeText(Report.this, "No of students registered " + s1, Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child("Excellent").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    int count = (int) dataSnapshot.getChildrenCount();
                    String s1 = String.valueOf(count);
                    t5.setText(s1);
                    // Toast.makeText(Report.this,"No of students registered "+s1,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child("Verygood").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    int count = (int) dataSnapshot.getChildrenCount();
                    String s1 = String.valueOf(count);
                    t6.setText(s1);
                    // Toast.makeText(Report.this,"No of students registered "+s1,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child("Good").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    int count = (int) dataSnapshot.getChildrenCount();
                    String s1 = String.valueOf(count);
                    t7.setText(s1);
                    // Toast.makeText(Report.this,"No of students registered "+s1,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child("Average").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    int count = (int) dataSnapshot.getChildrenCount();
                    String s1 = String.valueOf(count);
                    t8.setText(s1);
                    // Toast.makeText(Report.this,"No of students registered "+s1,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child("Poor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    int count = (int) dataSnapshot.getChildrenCount();
                    String s1 = String.valueOf(count);
                    t9.setText(s1);
                    // Toast.makeText(Report.this,"No of students registered "+s1,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(Report.this, Piechart.class);
                        intent.putExtra("s1", s1);
                        startActivity(intent);

                    }
                });
            }
        });
    }


}