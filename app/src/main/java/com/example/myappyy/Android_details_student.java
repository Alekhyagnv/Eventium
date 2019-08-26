package com.example.myappyy;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class Android_details_student extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5;
    ImageView i1;
    Button b1,feedback,review,images,viewimg,report,delete;
    private PopupWindow window;
    String s1,s2,s3,s4,s5,s6,s7,att,feed;

    DatabaseReference database,ref,userref;

    FirebaseAuth auth;
    String uid,key;
    Spanned Text;
    Button edit;

    private static final int PIC_IMAGE=1;
    ArrayList<Uri> imageurl=new ArrayList<Uri>();
    private Uri imageuri;
    ProgressDialog progressDialog;
    int uploadcout=0;
    int currentimageselect=0;
    int countClipdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_details_student);
        final View parentLayout = findViewById(android.R.id.content);

        auth=FirebaseAuth.getInstance();
        delete=findViewById(R.id.delete);
        feedback=findViewById(R.id.feedback);
        report=findViewById(R.id.report);
        uid=auth.getCurrentUser().getUid();
        database=FirebaseDatabase.getInstance().getReference().child("attendance");
        userref=FirebaseDatabase.getInstance().getReference().child("users");

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please wait images are uploading...");





        s1=getIntent().getStringExtra("a1");
        s2=getIntent().getStringExtra("a2");
        s3=getIntent().getStringExtra("a3");
        s4=getIntent().getStringExtra("a4");
        s5=getIntent().getStringExtra("a5");
        s6=getIntent().getStringExtra("a6");
        s7=getIntent().getStringExtra("a7");
      //  Toast.makeText(Android_details_student.this,s7,Toast.LENGTH_LONG).show();


        b1=findViewById(R.id.attendance_btn);

        edit=findViewById(R.id.edit_post);
viewimg=findViewById(R.id.images_view);
        ref=FirebaseDatabase.getInstance().getReference().child("Clubs").child("Androidclub").child(uid);


        if(uid.equals(s7))
        {
            edit.setVisibility(View.VISIBLE);
            review.setVisibility(View.VISIBLE);
        }


        t1=(TextView)findViewById(R.id.as11);
        t2=(TextView)findViewById(R.id.as21);
        t3=(TextView)findViewById(R.id.as31);
        t4=(TextView)findViewById(R.id.as41);
        t5=(TextView)findViewById(R.id.as61);
        i1=(ImageView)findViewById(R.id.as51);
        review=findViewById(R.id.feedbackcount);
        images=findViewById(R.id.images1);
        Text = Html.fromHtml("<a href="+s6+">Registeration page</a>");

        userref.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    String temp=dataSnapshot.child("type").getValue().toString();
                    String type="STUDENT";
                    if(type.equals(temp))
                    {
                        b1.setVisibility(View.VISIBLE);
                        feedback.setVisibility(View.VISIBLE);
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

att=s1;
        database.child(s1).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                {
                    int count= (int) dataSnapshot.getChildrenCount();
                    String s1=String.valueOf(count);
                   Snackbar.make(parentLayout,"No of students registered "+s1,Snackbar.LENGTH_LONG).setAction("Action",null).show();
                    //Toast.makeText(Android_details_student.this,"No of students registered "+s1,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Android_details_student.this,Deleting_post.class);
                intent.putExtra("s1",s1);
                startActivity(intent);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(Android_details_student.this);
               // final AlertDialog.Builder builder1=new AlertDialog.Builder(Android_details_student.this);

                builder.setTitle("Edit Description");
                builder.setTitle("edit name");

                final EditText desc=new EditText(Android_details_student.this);
                final EditText desc1=new EditText(Android_details_student.this);

                desc.setText(s3);
                desc1.setText(s1);
                builder.setView(desc);
                builder.setView(desc1);

                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ref.child("info").setValue(desc.getText().toString());
                        ref.child("eventname").setValue(desc1.getText().toString());

                        t3.setText(desc.getText().toString());
                        t1.setText(desc1.getText().toString());

                    }
                });

                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });


                Dialog dialog=builder.create();
                dialog.show();

            }
        });



       /* Toast.makeText(Android_details.this,s1,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s2,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s3,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s4,Toast.LENGTH_LONG).show();
        Toast.makeText(Android_details.this,s5,Toast.LENGTH_LONG).show();*/


       images.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
               intent.setType("image/*");
               intent.putExtra("name",s1);
               intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
               startActivityForResult(intent,PIC_IMAGE);
           }
       });








viewimg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i =new Intent(Android_details_student.this,images_display.class);
        i.putExtra("s1",s1);
        startActivity(i);
    }
});

        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s4);
        t5.setMovementMethod(LinkMovementMethod.getInstance());
        t5.setText(Text);

        Picasso.get().load(s5).into(i1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Android_details_student.this,Student_attendance.class);
                intent.putExtra("eventname",s1);

                startActivity(intent);

            }
        });
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Android_details_student.this,Report.class);
                i.putExtra("name",s1);
                i.putExtra("date",s2);
                i.putExtra("image",s5);
                startActivity(i);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent i=new Intent(Android_details_student.this,Feedback.class);
                i.putExtra("a1",s1);
                i.putExtra("a2",s2);
                i.putExtra("a3",s3);
                i.putExtra("a4",s4);
                i.putExtra("a5",s5);
                i.putExtra("a6",s6);
                i.putExtra("a7",s7);



                startActivity(i);
            }
        });


        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference feed=FirebaseDatabase.getInstance().getReference().child("Feedback").child(s1);

                feed.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists())
                        {
                            long s1,s2,s3,s4,s5;
                            if(dataSnapshot.hasChild("Excellent"))
                            {
                                s1=dataSnapshot.child("Excellent").getChildrenCount();
                                String a1=String.valueOf(s1);
                                Toast.makeText(Android_details_student.this, a1,Toast.LENGTH_LONG).show();
                            }
                            if(dataSnapshot.hasChild("Verygood"))
                            {
                                s2=dataSnapshot.child("Verygood").getChildrenCount();
                                String a1=String.valueOf(s2);
                                Toast.makeText(Android_details_student.this, a1,Toast.LENGTH_LONG).show();
                            }
                            if(dataSnapshot.hasChild("Good"))
                            {
                                s3=dataSnapshot.child("Good").getChildrenCount();
                                String a1=String.valueOf(s3);
                                Toast.makeText(Android_details_student.this, a1,Toast.LENGTH_LONG).show();
                            }
                            if(dataSnapshot.hasChild("Average"))
                            {
                                s4=dataSnapshot.child("Average").getChildrenCount();
                                String a1=String.valueOf(s4);
                                Toast.makeText(Android_details_student.this, a1,Toast.LENGTH_LONG).show();
                            }
                            if(dataSnapshot.hasChild("Poor"))
                            {
                                s5=dataSnapshot.child("Poor").getChildrenCount();
                                String a1=String.valueOf(s5);
                                Toast.makeText(Android_details_student.this, a1,Toast.LENGTH_LONG).show();
                            }

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });



    }


   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==PIC_IMAGE)
        {
            if(data.getClipData()!=null)
            {
                countClipdata=data.getClipData().getItemCount();
                while(currentimageselect<countClipdata)
                {
                    imageuri=data.getClipData().getItemAt(currentimageselect).getUri();
                    imageurl.add(imageuri);
                    currentimageselect=currentimageselect+1;
                    imagesupload();
                }

            }
        }
    }

    private void imagesupload() {

        progressDialog.show();
        progressDialog.setCancelable(false);
        StorageReference imagestrorage= FirebaseStorage.getInstance().getReference().child("ReportImages");

        for(uploadcout=0;uploadcout<imageurl.size();uploadcout++)
        {
            Uri individualimage=imageurl.get(uploadcout);
            final StorageReference imagename=imagestrorage.child("Image"+individualimage.getLastPathSegment());
            imagename.putFile(individualimage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    imagename.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            String url=String.valueOf(uri);
                            Storelink(url);
                        }
                    });
                }
            });
        }

    }

    private void Storelink(String url) {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference().child("Reportimages").child("Clubs").child("Androidclub").child(s1);
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("image",url);
        reference.push().setValue(hashMap);
        progressDialog.dismiss();

    }



}
