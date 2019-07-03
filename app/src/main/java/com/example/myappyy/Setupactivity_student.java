package com.example.myappyy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Setupactivity_student extends AppCompatActivity {

    EditText e5, e6, e7, e8;
    Button b8;
    FirebaseAuth auth;
    DatabaseReference reference;
    String currentid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setupstudent);
        auth = FirebaseAuth.getInstance();
        currentid = auth.getCurrentUser().getUid();
        reference = FirebaseDatabase.getInstance().getReference().child("users");

        e5 = (EditText) findViewById(R.id.editText5);
        e6 = (EditText) findViewById(R.id.editText6);
        e7 = (EditText) findViewById(R.id.editText7);
        e8 = (EditText) findViewById(R.id.editText8);
        b8 = findViewById(R.id.button8);

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = e5.getText().toString();
                String s2 = e6.getText().toString();
                String s3 = e7.getText().toString();
                String s4 = e8.getText().toString();
                if (TextUtils.isEmpty(s1)) {
                    Toast.makeText(getApplicationContext(), "enter username", Toast.LENGTH_LONG).show();
                    ;
                }

                else if (TextUtils.isEmpty(s2)) {
                    Toast.makeText(getApplicationContext(), "enter htno", Toast.LENGTH_LONG).show();
                }

                else if (TextUtils.isEmpty(s3)) {
                    Toast.makeText(getApplicationContext(), "enter branch", Toast.LENGTH_LONG).show();
                    ;
                }

                else if (TextUtils.isEmpty(s4)) {
                    Toast.makeText(getApplicationContext(), "enter section", Toast.LENGTH_LONG).show();
                    ;
                }
                else
                {


                    reference.child(currentid).child("username").setValue(s1);
                    reference.child(currentid).child("hallticketno").setValue(s2);
                    reference.child(currentid).child("branch").setValue(s3);
                    reference.child(currentid).child("section").setValue(s4).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "successful", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Setupactivity_student.this, MainActivity.class);
                                startActivity(intent);
                                finish();

                            } else {

                                Toast.makeText(getApplicationContext(), "error" , Toast.LENGTH_LONG).show();

                            }

                        }
                    });

                }


            }
        });
    }
}
