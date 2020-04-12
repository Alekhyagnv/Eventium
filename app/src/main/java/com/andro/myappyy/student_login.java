package com.andro.myappyy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
    Button b2,b4;
    FirebaseAuth auth;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);



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
                        Intent intent=new Intent(student_login.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                        pd.dismiss();
                    }
                    else {
                        String msg=task.getException().toString();
                        Toast.makeText(getApplicationContext(),"error : "+msg,Toast.LENGTH_LONG).show();
                        pd.dismiss();




                    }
                }

            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth mauth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=mauth.getCurrentUser();
        if(firebaseUser!=null)
        {

            Intent intent=new Intent(student_login.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

