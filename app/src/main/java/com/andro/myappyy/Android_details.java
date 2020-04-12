package com.andro.myappyy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class Android_details extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;
    ImageView i1;

    String s1,s2,s3,s4,s5,s6,s7;
    FirebaseAuth auth;
    String uid;
    Button edit;
    Spanned Text;

    String key;

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
         s7=getIntent().getStringExtra("a7");
        key=getIntent().getStringExtra("key");



        t1=(TextView)findViewById(R.id.as1);
        t2=(TextView)findViewById(R.id.as2);
        t3=(TextView)findViewById(R.id.as3);
        t4=(TextView)findViewById(R.id.as4);
        t5=(TextView)findViewById(R.id.ass6);
        i1=(ImageView)findViewById(R.id.as5);

        Text = Html.fromHtml("<a href="+s6+">Registeration page</a>");






       /* Toast.makeText(Android_details.this,s1,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s2,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s3,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s4,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s5,Toast.LENGTH_LONG).show();*/




        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s4);
        t5.setMovementMethod(LinkMovementMethod.getInstance());
        t5.setText(Text);

       /* if(!TextUtils.isEmpty(s6))
        {
            t5.setVisibility(View.VISIBLE);
            t5.setText(s6);
        }*/

        Picasso.get().load(s5).into(i1);



    }
}
