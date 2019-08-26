package com.example.myappyy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Student_attendance extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton rb1;
    Button b1;
    EditText eName,eHno,eBranch,eYear,eename;
    TextView present,t1;
    DatabaseReference databaseReference;
    String string;
    StudentAttendence1 studentAttendence;
    int count;

    String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance);
        radioGroup= findViewById(R.id.radio_group_attendance);
        b1=(Button)findViewById(R.id.button16_attendance);
        eName=(EditText)findViewById(R.id.editText5_attendance);
        eHno=(EditText)findViewById(R.id.editText6_attendance);
        eBranch=(EditText)findViewById(R.id.editText7_attendance);
        eename=(EditText)findViewById(R.id.editText9_attendance) ;
        eYear=(EditText)findViewById(R.id.editText8_attendance);
      //  present=(TextView)findViewById(R.id.textView2_attendance);
        t1=(TextView)findViewById(R.id.textView_attendance);
        studentAttendence=new StudentAttendence1();
key=getIntent().getStringExtra("eventname");


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


        databaseReference= FirebaseDatabase.getInstance().getReference().child("attendance").child(""+key);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eName.getText().toString().isEmpty() || eHno.getText().toString().isEmpty() || eBranch.getText().toString().isEmpty()||
                        eYear.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "please insert the data", Toast.LENGTH_SHORT).show();
                }
                else{
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(Student_attendance.this);
                    alertDialog.setMessage("Are u sure to submit the data?").setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    studentAttendence.setName(eName.getText().toString().trim());
                                    studentAttendence.setH_No(eHno.getText().toString().trim());
                                    studentAttendence.setBranch(eBranch.getText().toString().trim());
                                    studentAttendence.setYear(eYear.getText().toString().trim());
                                    studentAttendence.setPresent(string);
                                    studentAttendence.setEname(eename.getText().toString().trim());
                                    databaseReference.push().setValue(studentAttendence);
                                    Toast.makeText(getApplicationContext(), "Done!!", Toast.LENGTH_SHORT).show();
                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog dialog = alertDialog.create();
                    dialog.setTitle(" submit the data???");
                    dialog.show();

                }

            }
        });

        new CountDownTimer(300000, 10000) {

            public void onTick(long millisUntilFinished) {
                long mint = (millisUntilFinished/1000)/60;
                t1.setText("Minutes remaining: " + mint);
            }

            public void onFinish() {
                t1.setText("done!");
                Intent intent = new Intent(Student_attendance.this,Finish.class);
                startActivity(intent);
                finish();
            }
        }.start();

    }
}
