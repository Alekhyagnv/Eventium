package com.example.myappyy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class Android_details extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    ImageView i1;

    String s1,s2,s3,s4,s5,s6;
    FirebaseAuth auth;
    String uid;
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_details);

        auth=FirebaseAuth.getInstance();
        uid=auth.getCurrentUser().getUid();

        s1=getIntent().getStringExtra("a1");
        s2=getIntent().getStringExtra("a2");
        s3=getIntent().getStringExtra("a3");
        s4=getIntent().getStringExtra("a4");
        s5=getIntent().getStringExtra("a5");
       s6=getIntent().getStringExtra("a6");

        Toast.makeText(this,uid,Toast.LENGTH_LONG).show();


        t1=(TextView)findViewById(R.id.as1);
        t2=(TextView)findViewById(R.id.as2);
        t3=(TextView)findViewById(R.id.as3);
        t4=(TextView)findViewById(R.id.as4);
        i1=(ImageView)findViewById(R.id.as5);

        edit=findViewById(R.id.postedit);

       if(s6.equals(uid))
        {
            edit.setVisibility(View.VISIBLE);
        }



       /* Toast.makeText(Android_details.this,s1,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s2,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s3,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s4,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s5,Toast.LENGTH_LONG).show();*/

       edit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Snackbar.make(v,"Edit clicked",Snackbar.LENGTH_LONG).setAction("Action",null).show();
           }
       });


        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s4);

        Picasso.get().load(s5).into(i1);



    }
}
