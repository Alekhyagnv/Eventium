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

public class resetpassword extends AppCompatActivity {

    EditText pw;
    Button b1;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);

        pw=(EditText)findViewById(R.id.reset_pw);
        b1=(Button)findViewById(R.id.reset_pw_btn);

        auth=FirebaseAuth.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=pw.getText().toString();

                if(TextUtils.isEmpty(email)) 
                {
                    Toast.makeText(resetpassword.this,"Please enter the Email Address",Toast.LENGTH_LONG).show();
                }
                else
                {
                    auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful())
                            {
                                Toast.makeText(resetpassword.this,"Please Check your Email to Change Password",Toast.LENGTH_LONG).show();
                                Intent i1=new Intent(resetpassword.this,Loginpage.class);
                                startActivity(i1);
                                finish();
                            }
                            else
                            {
                                String msg=task.getException().toString();
                                Toast.makeText(resetpassword.this,"Error Ocuured :" +msg,Toast.LENGTH_LONG).show();

                            }

                        }
                    });
                }
            }
        });




    }
}
