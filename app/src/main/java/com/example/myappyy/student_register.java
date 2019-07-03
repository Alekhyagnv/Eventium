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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class student_register extends AppCompatActivity {

    EditText e1,e2;
    Button b1;
    FirebaseAuth auth;
    ProgressDialog pd;
    private static final String TAG = "Register";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);

        auth=FirebaseAuth.getInstance();

        pd=new ProgressDialog(this);

        e1=(EditText) findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString().trim();
                String s2=e2.getText().toString().trim();
                register(s1,s2);
            }



        });

    }

    private void register(String s1,String s2) {
        if (TextUtils.isEmpty(s1)){
            Toast.makeText(getApplicationContext(),"enter username",Toast.LENGTH_LONG).show();;
        }
        else if(TextUtils.isEmpty(s2)){
            Toast.makeText(getApplicationContext(),"password",Toast.LENGTH_LONG).show();;


        }
        else {

            pd.setTitle("Registering");
            pd.setMessage("Please wait While Creating your Account");
            pd.setCancelable(true);
            pd.show();

            auth.createUserWithEmailAndPassword(s1, s2)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(),"successful",Toast.LENGTH_LONG).show();;
                                Intent intent=new Intent(student_register.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                                pd.dismiss();

                            } else {
                                String msg=task.getException().toString();
                                Toast.makeText(getApplicationContext(),"error"+msg,Toast.LENGTH_LONG).show();
                                pd.dismiss();
                                try {
                                    throw task.getException();
                                } catch(FirebaseAuthWeakPasswordException e) {
                                    System.out.println(e);

                                } catch(FirebaseAuthInvalidCredentialsException e) {
                                    System.out.println(e);

                                } catch(FirebaseAuthUserCollisionException e) {
                                    System.out.println(e);

                                } catch(Exception e) {
                                    System.out.println(e);

                                }
                            }
                        }

                    });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=auth.getCurrentUser();
        if(user!=null){
            Intent intent=new Intent(student_register.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

