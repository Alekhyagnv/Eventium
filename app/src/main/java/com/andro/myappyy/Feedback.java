package com.andro.myappyy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Feedback extends AppCompatActivity {
    EditText e2,e3,e4;
    Button b1;
    DatabaseReference databaseReference;
    Feedback1 feedback1;
    RadioGroup radioGroup;
    RadioButton rb1;

    String string,key;
    String uid;
    FirebaseAuth auth;

    boolean b=false,b2=false,b3=false,b4=false,b5=false,b6=false;
    boolean check=true;

    String s11,s12,s13,s14,s15,s16,s17,s18;
    String s1="null";

    DatabaseReference reference,ref1,ref2,ref3,ref4,ref5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        auth=FirebaseAuth.getInstance();
        uid=auth.getCurrentUser().getUid();

        reference=FirebaseDatabase.getInstance().getReference().child("users").child(uid);


        e2 = findViewById(R.id.feed_mail);
        e3 = findViewById(R.id.feed_sub);


        s11=getIntent().getStringExtra("a1");
        s12=getIntent().getStringExtra("a2");
        s13=getIntent().getStringExtra("a3");
        s14=getIntent().getStringExtra("a4");
        s15=getIntent().getStringExtra("a5");
        s16=getIntent().getStringExtra("a6");
        s17=getIntent().getStringExtra("a7");
        s18=getIntent().getStringExtra("a8");


        ref1=FirebaseDatabase.getInstance().getReference().child("Feedback").child(s11).child("Excellent");
        ref2=FirebaseDatabase.getInstance().getReference().child("Feedback").child(s11).child("Verygood");
        ref3=FirebaseDatabase.getInstance().getReference().child("Feedback").child(s11).child("Good");
        ref4=FirebaseDatabase.getInstance().getReference().child("Feedback").child(s11).child("Average");
        ref5=FirebaseDatabase.getInstance().getReference().child("Feedback").child(s11).child("Poor");



        e4 = findViewById(R.id.feed_feedback);
        b1 = findViewById(R.id.feed_submit);
        radioGroup= findViewById(R.id.radio_group_feed);
        //t1=(TextView)findViewById(R.id.textView_feed);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb1=radioGroup.findViewById(checkedId);
                switch (checkedId){
                    case R.id.excellent:
                        string=rb1.getText().toString();
                        b=true;
                        b6=true;
                        break;
                    case R.id.verygood:
                        string=rb1.getText().toString();
                        b2=true;
                        b6=true;
                        break;
                    case R.id.good:
                        string=rb1.getText().toString();
                        b3=true;
                        b6=true;
                        break;
                    case R.id.average:
                        string=rb1.getText().toString();
                        b4=true;
                        b6=true;
                        break;
                    case R.id.poor:
                        string=rb1.getText().toString();
                        b5=true;
                        b6=true;
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

        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    if(dataSnapshot.hasChild(uid))
                    {
                        check=false;
                    }
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    if(dataSnapshot.hasChild(uid))
                    {
                        check=false;
                    }
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    if(dataSnapshot.hasChild(uid))
                    {
                        check=false;
                    }
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    if(dataSnapshot.hasChild(uid))
                    {
                        check=false;
                    }
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ref5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    if(dataSnapshot.hasChild(uid))
                    {
                        check=false;
                    }
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( e2.getText().toString().isEmpty() || e3.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "please insert the data", Toast.LENGTH_SHORT).show();
                }
                else if(!b6)
                {
                    Toast.makeText(getApplicationContext(), "please Choose any one option", Toast.LENGTH_SHORT).show();
                }
                else{
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(Feedback.this);
                    alertDialog.setMessage("Are u sure to submit the data?").setCancelable(false)
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
                    alertDialog.show();

                }
            }
        });
    }

    private void insertdata() {

        String s2,s3,s4;

        s2=e2.getText().toString();
        s3=e3.getText().toString();
        s4=e4.getText().toString();

        if(check)
        {

            if(b)
            {
                databaseReference=FirebaseDatabase.getInstance().getReference().child("Feedback").child(s11).child("Excellent").child(uid);
                databaseReference.child("hall").setValue(s1);
                databaseReference.child("college").setValue(s2);
                databaseReference.child("subject").setValue(s3);
                databaseReference.child("feedback").setValue(s4).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Intent intent=new Intent(Feedback.this,Android_details_student.class);
                            intent.putExtra("a1",s11);
                            intent.putExtra("a2",s12);
                            intent.putExtra("a3",s13);
                            intent.putExtra("a4",s14);
                            intent.putExtra("a5",s15);
                            intent.putExtra("a6",s16);
                            intent.putExtra("a7",s17);
                            intent.putExtra("a8",s18);
                            startActivity(intent);
                            finish();
                        }
                    }
                });

            }
            else if(b2)
            {
                databaseReference=FirebaseDatabase.getInstance().getReference().child("Feedback").child(s11).child("Verygood").child(uid);
                databaseReference.child("hall").setValue(s1);
                databaseReference.child("college").setValue(s2);
                databaseReference.child("subject").setValue(s3);
                databaseReference.child("feedback").setValue(s4).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {

                            Intent intent=new Intent(Feedback.this,Android_details_student.class);
                            intent.putExtra("a1",s11);
                            intent.putExtra("a2",s12);
                            intent.putExtra("a3",s13);
                            intent.putExtra("a4",s14);
                            intent.putExtra("a5",s15);
                            intent.putExtra("a6",s16);
                            intent.putExtra("a7",s17);
                            intent.putExtra("a8",s18);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }
            else if(b3)
            {
                databaseReference=FirebaseDatabase.getInstance().getReference().child("Feedback").child(s11).child("Good").child(uid);
                databaseReference.child("hall").setValue(s1);
                databaseReference.child("college").setValue(s2);
                databaseReference.child("subject").setValue(s3);
                databaseReference.child("feedback").setValue(s4).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Intent intent=new Intent(Feedback.this,Android_details_student.class);
                            intent.putExtra("a1",s11);
                            intent.putExtra("a2",s12);
                            intent.putExtra("a3",s13);
                            intent.putExtra("a4",s14);
                            intent.putExtra("a5",s15);
                            intent.putExtra("a6",s16);
                            intent.putExtra("a7",s17);
                            intent.putExtra("a8",s18);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            } else if(b4)
            {
                databaseReference=FirebaseDatabase.getInstance().getReference().child("Feedback").child(s11).child("Average").child(uid);
                databaseReference.child("hall").setValue(s1);
                databaseReference.child("college").setValue(s2);
                databaseReference.child("subject").setValue(s3);
                databaseReference.child("feedback").setValue(s4).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Intent intent=new Intent(Feedback.this,Android_details_student.class);
                            intent.putExtra("a1",s11);
                            intent.putExtra("a2",s12);
                            intent.putExtra("a3",s13);
                            intent.putExtra("a4",s14);
                            intent.putExtra("a5",s15);
                            intent.putExtra("a6",s16);
                            intent.putExtra("a7",s17);
                            intent.putExtra("a8",s18);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            } else if(b5)
            {
                databaseReference=FirebaseDatabase.getInstance().getReference().child("Feedback").child(s11).child("Poor").child(uid);
                databaseReference.child("hall").setValue(s1);
                databaseReference.child("college").setValue(s2);
                databaseReference.child("subject").setValue(s3);
                databaseReference.child("feedback").setValue(s4).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Intent intent=new Intent(Feedback.this,Android_details_student.class);
                            intent.putExtra("a1",s11);
                            intent.putExtra("a2",s12);
                            intent.putExtra("a3",s13);
                            intent.putExtra("a4",s14);
                            intent.putExtra("a5",s15);
                            intent.putExtra("a6",s16);
                            intent.putExtra("a7",s17);
                            intent.putExtra("a8",s18);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }

        }
        else
        {
            Toast.makeText(Feedback.this,"Your Feedback is already Recorded, Thank you...",Toast.LENGTH_LONG).show();
        }






    }
}



