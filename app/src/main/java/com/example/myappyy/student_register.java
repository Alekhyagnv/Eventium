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
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

    EditText e1,e2,e3;
    Button b1;
    FirebaseAuth auth;
    String string;
    RadioButton rb1;
    RadioGroup radioGroup;
    ProgressDialog pd;
    private static final String TAG = "Register";
    String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);

        auth=FirebaseAuth.getInstance();
        radioGroup= findViewById(R.id.radio_group_register);




        pd=new ProgressDialog(this);

        e1=(EditText) findViewById(R.id.editText_register);
        e2=(EditText)findViewById(R.id.editText2_register);
        e3=findViewById(R.id.editText3_register);
        b1=(Button)findViewById(R.id.button11_register);


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
            pd.setCancelable(false);
            pd.show();

            auth.createUserWithEmailAndPassword(s1, s2)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(),"yes",Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(student_register.this,Setupactivity_student.class);
                                intent.putExtra("type",type);
                                startActivity(intent);
                                finish();
                                pd.dismiss();

                            } else {
                                String msg=task.getException().toString();
                                Toast.makeText(getApplicationContext(),"error"+msg,Toast.LENGTH_LONG).show();
                                pd.dismiss();
                            }
                        }

                    });
        }
    }



    public void radioclick(View view) {


        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.faculty:
                if (checked) {
                    type = "FACULTY";
                }
                    break;
            case R.id.student:
                if (checked) {
                    type = "STUDENT";
                }
                break;
        }



    }
}

