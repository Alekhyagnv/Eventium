package com.example.myappyy;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class student_login extends AppCompatActivity {

    EditText e3,e4;
    Button b2,b3;
    FirebaseAuth auth;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        auth=FirebaseAuth.getInstance();

        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);

        pd=new ProgressDialog(this);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e3.getText().toString();
                String s2 = e4.getText().toString();
                Login(s1,s2);
            }



        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(student_login.this,student_register.class);
                startActivity(i);
            }
        });




    }

    private void Login(String s1,String s2) {
        if (TextUtils.isEmpty(s1)){
            Toast.makeText(getApplicationContext(),"enter username",Toast.LENGTH_LONG).show();;
        }
        else if(TextUtils.isEmpty(s2)){
            Toast.makeText(getApplicationContext()," enter password",Toast.LENGTH_LONG).show();;


        }
        else {

            pd.setTitle("Sign In");
            pd.setMessage("Please wait While Signing");
            pd.setCancelable(true);
            pd.show();


            auth.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(student_login.this,new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"successful",Toast.LENGTH_LONG).show();;
                        Intent intent=new Intent(student_login.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                        pd.dismiss();
                    }
                    else {
                        String msg=task.getException().toString();
                        Toast.makeText(getApplicationContext(),"error"+msg,Toast.LENGTH_LONG).show();
                        pd.dismiss();




                    }
                }

            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser firebaseUser=auth.getCurrentUser();
        if(firebaseUser!=null)
        {

            Intent intent=new Intent(student_login.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

