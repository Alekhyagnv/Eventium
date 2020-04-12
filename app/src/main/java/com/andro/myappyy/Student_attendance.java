package com.andro.myappyy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Student_attendance extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton rb1;
    Button b1;
    EditText eName,eHno,eBranch,eYear,eename;
    TextView present,t1;
    DatabaseReference databaseReference,ref1;
    String string,s1;
    StudentAttendence1 studentAttendence;
    int count;
    boolean check=true;
    FirebaseAuth auth;
    String key,uid;
    DatabaseReference reference,refff;
    boolean temp=true;
    String userid;
    FirebaseAuth mauth;


    String s11,s12,s13,s14,s15,s16,s17,s18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance);
        radioGroup= findViewById(R.id.radio_group_attendance);
        b1=(Button)findViewById(R.id.button16_attendance);
        eName=(EditText)findViewById(R.id.editText5_attendance);
       // eHno=(EditText)findViewById(R.id.editText6_attendance);
        eBranch=(EditText)findViewById(R.id.editText7_attendance);
        eename=(EditText)findViewById(R.id.editText9_attendance) ;
        eYear=(EditText)findViewById(R.id.editText8_attendance);
      //  present=(TextView)findViewById(R.id.textView2_attendance);
        t1=(TextView)findViewById(R.id.textView_attendance);
        auth=FirebaseAuth.getInstance();
        studentAttendence=new StudentAttendence1();
        uid=auth.getCurrentUser().getUid();
        key=getIntent().getStringExtra("eventname");
        s12=getIntent().getStringExtra("a2");
        s13=getIntent().getStringExtra("a3");
        s14=getIntent().getStringExtra("a4");
        s15=getIntent().getStringExtra("a5");
        s16=getIntent().getStringExtra("a6");
        s17=getIntent().getStringExtra("a7");
        s18=getIntent().getStringExtra("a8");


        reference=FirebaseDatabase.getInstance().getReference().child("users").child(uid);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb1=radioGroup.findViewById(checkedId);
                switch (checkedId){
                    case R.id.yes:
                        string=rb1.getText().toString();
                        break;
                    case R.id.no:
                        string=rb1.getText().toString();
                        break;
                    default:
                }
            }
        });
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    if(dataSnapshot.hasChild("hallticketno"))
                    {
                        s1=dataSnapshot.child("hallticketno").getValue().toString();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


       // ref1=FirebaseDatabase.getInstance().getReference().child("attendance").child(key);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("attendance").child(key);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(!temp)
                        {
                            Toast.makeText(Student_attendance.this,"Your Response is Recorded, Thank you...",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            if (eName.getText().toString().isEmpty() || eBranch.getText().toString().isEmpty() ||
                                    eYear.getText().toString().isEmpty()) {
                                Toast.makeText(getApplicationContext(), "please insert the data", Toast.LENGTH_SHORT).show();
                            } else {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Student_attendance.this);
                                alertDialog.setMessage("Are you sure to submit the data?").setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                insertdata();

                                            }
                                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                });
                                AlertDialog dialog = alertDialog.create();
                                dialog.setTitle(" Submit the data???");
                                dialog.show();

                            }
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


        new CountDownTimer(100000, 10000) {

            public void onTick(long millisUntilFinished) {
                long mint = (millisUntilFinished/1000)/60;
                t1.setText("Minutes remaining: " + mint);
            }

            public void onFinish() {
                t1.setText("done!");
            }
        }.start();

    }

    private void insertdata() {

        String s2,s3,s4,s5,s6;

        s2=eName.getText().toString();
        s3=eBranch.getText().toString();
        s4=eYear.getText().toString();
        s5=eename.getText().toString();


        HashMap postmap=new HashMap();
        postmap.put("branch",s3);
        postmap.put("ename",s5);
        postmap.put("h_No",s1);
        postmap.put("name",s2);
        postmap.put("present",string);
        postmap.put("year",s4);
        databaseReference.child(uid).updateChildren(postmap).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if(task.isSuccessful())
                {
                    Intent intent=new Intent(Student_attendance.this,Android_details_student.class);
                    intent.putExtra("a1",key);
                    intent.putExtra("a2",s12);
                    intent.putExtra("a3",s13);
                    intent.putExtra("a4",s14);
                    intent.putExtra("a5",s15);
                    intent.putExtra("a6",s16);
                    intent.putExtra("a7",s17);
                    intent.putExtra("a8",s18);
                  //  intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }

            }
        });



    }


    @Override
    protected void onStart() {
        super.onStart();
        key=getIntent().getStringExtra("eventname");
        mauth=FirebaseAuth.getInstance();
        userid=mauth.getCurrentUser().getUid();
        refff= FirebaseDatabase.getInstance().getReference().child("attendance").child(key);

        refff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(userid))
                {
                    temp=false;
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
