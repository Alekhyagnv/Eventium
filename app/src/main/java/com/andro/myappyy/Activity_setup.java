package com.andro.myappyy;

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

public class Activity_setup extends AppCompatActivity {

    EditText e5, e6;
    Button b8;
    FirebaseAuth auth;
    DatabaseReference reference;
    String currentid;
    String type;
    String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        auth = FirebaseAuth.getInstance();
        currentid = auth.getCurrentUser().getUid();
        reference = FirebaseDatabase.getInstance().getReference().child("users");

        type=getIntent().getStringExtra("type");

        e5 = (EditText) findViewById(R.id.fac_name);
        e6 = (EditText) findViewById(R.id.fac_dept);

        b8 = findViewById(R.id.fac_save);

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s1 = e5.getText().toString();
                s2 = e6.getText().toString();

                if (TextUtils.isEmpty(s1)) {
                    Toast.makeText(getApplicationContext(), "enter username", Toast.LENGTH_LONG).show();
                    ;
                }

                else if (TextUtils.isEmpty(s2)) {
                    Toast.makeText(getApplicationContext(), "enter Department", Toast.LENGTH_LONG).show();
                }

                else
                {


                    reference.child(currentid).child("username").setValue(s1);
                   // reference.child(currentid).child("dept").setValue(s2);
                //    reference.child(currentid).child("branch").setValue(s3);
                    reference.child(currentid).child("type").setValue(type);
                    reference.child(currentid).child("dept").setValue(s2).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "successful", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Activity_setup.this, MainActivity.class);
                                //intent.putExtra("number",s2);
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
