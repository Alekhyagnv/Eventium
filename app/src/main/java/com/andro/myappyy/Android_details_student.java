package com.andro.myappyy;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
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

    TextView t1,t2,t3,t4,t5,t6;
    ImageView i1;
    Button report,delete;
    private PopupWindow window;
    String s1,s2,s3,s4,s5,s6,s7,s8,att,feed,newlink,s9,link1;

    DatabaseReference database,ref,ref1,userref;

    FirebaseAuth auth;
    String uid,key;
    Spanned Text,text1,text2,textt;
    Button edit,editdate,edittarget,editlink,editlink1;
    Toolbar toolbar;

    private static final int PIC_IMAGE=1;
    ArrayList<Uri> imageurl=new ArrayList<Uri>();
    private Uri imageuri;
    ProgressDialog progressDialog;
    int uploadcout=0;
    int currentimageselect=0;
    int countClipdata;

    boolean check1=false,check2=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_details_student);
        final View parentLayout = findViewById(android.R.id.content);

        s1=getIntent().getStringExtra("a1");
        s2=getIntent().getStringExtra("a2");
        s3=getIntent().getStringExtra("a3");
        s4=getIntent().getStringExtra("a4");
        s5=getIntent().getStringExtra("a5");
        s6=getIntent().getStringExtra("a6");
        s7=getIntent().getStringExtra("a7");
        s8=getIntent().getStringExtra("a8");
        link1=getIntent().getStringExtra("a9");

        auth=FirebaseAuth.getInstance();
        delete=findViewById(R.id.delete);
       // feedback=findViewById(R.id.feedback);
        report=findViewById(R.id.report);
        uid=auth.getCurrentUser().getUid();
        database=FirebaseDatabase.getInstance().getReference().child("attendance");
        userref=FirebaseDatabase.getInstance().getReference().child("users");

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please wait images are uploading...");
        toolbar = (Toolbar) findViewById(R.id.toolbar_main2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("EVENTIUM");



      //  b1=findViewById(R.id.attendance_btn);

        //edit=findViewById(R.id.edit_post);
        editdate=findViewById(R.id.editdate);
        edittarget=findViewById(R.id.edittarget);
        editlink=findViewById(R.id.editlink);
        editlink1=findViewById(R.id.editlink1);


     //   viewimg=findViewById(R.id.images_view);


        ref=FirebaseDatabase.getInstance().getReference().child("Clubs").child(s8).child(uid);
        ref1=FirebaseDatabase.getInstance().getReference().child("Chapters").child(s8).child(uid);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    if(dataSnapshot.hasChild("eventname"))
                    {
                        String temp=dataSnapshot.child("eventname").getValue().toString();
                        String temp1=t1.getText().toString();
                        if(temp.equals(temp1))
                        {
                            check1=true;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    if(dataSnapshot.hasChild("eventname"))
                    {
                        String temp=dataSnapshot.child("eventname").getValue().toString();
                        String temp1=t1.getText().toString();
                        if(temp.equals(temp1))
                        {
                            check2=true;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





        t1=(TextView)findViewById(R.id.as11);
        t2=(TextView)findViewById(R.id.as21);
        t3=(TextView)findViewById(R.id.as31);
        t4=(TextView)findViewById(R.id.as41);
        t5=(TextView)findViewById(R.id.as61);
        t6=(TextView)findViewById(R.id.as71);
        i1=(ImageView)findViewById(R.id.as51);
       // review=findViewById(R.id.feedbackcount);
      //  images=findViewById(R.id.images1);


        if(uid.equals(s7))
        {
            //edit.setVisibility(View.VISIBLE);
            editdate.setVisibility(View.VISIBLE);
            edittarget.setVisibility(View.VISIBLE);
            editlink.setVisibility(View.VISIBLE);
            editlink1.setVisibility(View.VISIBLE);
            report.setVisibility(View.VISIBLE);
           // review.setVisibility(View.VISIBLE);
        }

       /* userref.child(uid).addValueEventListener(new ValueEventListener() {
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
        });*/

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



        editdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(Android_details_student.this);
                // final AlertDialog.Builder builder1=new AlertDialog.Builder(Android_details_student.this);

                builder.setTitle("Edit date");
                // builder.setTitle("edit name");

                final EditText desc=new EditText(Android_details_student.this);
                //   final EditText desc1=new EditText(Android_details_student.this);

                desc.setText(s2);
                // desc1.setText(s1);
                builder.setView(desc);
                // builder.setView(desc1);

                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(check1)
                        {
                            ref.child("date").setValue(desc.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(Android_details_student.this,"open the page again to view the updated Date",Toast.LENGTH_LONG).show();
                                    }

                                }
                            });
                        }

                        if(check2)
                        {
                            ref1.child("date").setValue(desc.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(Android_details_student.this,"open the page again to view the updated Date",Toast.LENGTH_LONG).show();
                                    }

                                }
                            });
                        }
                        t2.setText(desc.getText().toString());

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
        edittarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(Android_details_student.this);
                // final AlertDialog.Builder builder1=new AlertDialog.Builder(Android_details_student.this);

                builder.setTitle("Edit Targeted Students");
                // builder.setTitle("edit name");

                final EditText desc=new EditText(Android_details_student.this);
                //   final EditText desc1=new EditText(Android_details_student.this);

                desc.setText(s4);
                // desc1.setText(s1);
                builder.setView(desc);
                // builder.setView(desc1);

                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ref.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.exists())
                                {
                                    ref.child("students").setValue(desc.getText().toString());
                                    // ref.child("eventname").setValue(desc1.getText().toString());

                                    t4.setText(desc.getText().toString());
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        ref1.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.exists())
                                {

                                    ref.child("students").setValue(desc.getText().toString());
                                    // ref.child("eventname").setValue(desc1.getText().toString());

                                    t4.setText(desc.getText().toString());
                                }

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


                        //t1.setText(desc1.getText().toString());

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

        editlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(Android_details_student.this);
                // final AlertDialog.Builder builder1=new AlertDialog.Builder(Android_details_student.this);

                builder.setTitle("Edit Link");
                // builder.setTitle("edit name");

                final EditText desc=new EditText(Android_details_student.this);
                //   final EditText desc1=new EditText(Android_details_student.this);

                desc.setText(s6);
                // desc1.setText(s1);
                builder.setView(desc);
                // builder.setView(desc1);

                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ref.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.exists())
                                {
                                    ref.child("link").setValue(desc.getText().toString());
                                    // ref.child("eventname").setValue(desc1.getText().toString());
                                    newlink=desc.getText().toString();
                                    text1 = Html.fromHtml("<a href="+newlink+">Registeration page</a>");
                                    t5.setMovementMethod(LinkMovementMethod.getInstance());
                                    t5.setText(text1);

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        ref1.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.exists())
                                {

                                    ref.child("link").setValue(desc.getText().toString());
                                    // ref.child("eventname").setValue(desc1.getText().toString());
                                     newlink=desc.getText().toString();
                                    text1 = Html.fromHtml("<a href="+newlink+">Registeration page</a>");

                                    t5.setMovementMethod(LinkMovementMethod.getInstance());
                                    t5.setText(text1);
                                }

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


                        //t1.setText(desc1.getText().toString());

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
        editlink1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(Android_details_student.this);
                // final AlertDialog.Builder builder1=new AlertDialog.Builder(Android_details_student.this);

                builder.setTitle("Edit Link");
                // builder.setTitle("edit name");

                final EditText desc=new EditText(Android_details_student.this);
                //   final EditText desc1=new EditText(Android_details_student.this);

                desc.setText(link1);
                // desc1.setText(s1);
                builder.setView(desc);
                // builder.setView(desc1);

                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ref.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.exists())
                                {
                                    ref.child("link1").setValue(desc.getText().toString());
                                    // ref.child("eventname").setValue(desc1.getText().toString());
                                    newlink=desc.getText().toString();
                                    text2 = Html.fromHtml("<a href="+newlink+">Registeration page</a>");
                                    t6.setMovementMethod(LinkMovementMethod.getInstance());
                                    t6.setText(text2);

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        ref1.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.exists())
                                {

                                    ref.child("link").setValue(desc.getText().toString());
                                    // ref.child("eventname").setValue(desc1.getText().toString());
                                    newlink=desc.getText().toString();
                                    text2 = Html.fromHtml("<a href="+newlink+">Registeration page</a>");

                                    t6.setMovementMethod(LinkMovementMethod.getInstance());
                                    t6.setText(text2);
                                }

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


                        //t1.setText(desc1.getText().toString());

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


      /* images.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
               intent.setType("image/*");
               intent.putExtra("name",s1);
               intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
               startActivityForResult(intent,PIC_IMAGE);
           }
       });*/








/*viewimg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i =new Intent(Android_details_student.this,images_display.class);
        i.putExtra("s1",s1);
        startActivity(i);
    }
});*/
        Text = Html.fromHtml("<a href="+s6+">Registeration page</a>");
        textt = Html.fromHtml("<a href="+link1+">Registeration page</a>");
        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s4);
        t5.setMovementMethod(LinkMovementMethod.getInstance());
        t5.setText(Text);
        t6.setMovementMethod(LinkMovementMethod.getInstance());
        t6.setText(textt);

        Picasso.get().load(s5).into(i1);
        /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Android_details_student.this,Student_attendance.class);
                intent.putExtra("eventname",s1);

                startActivity(intent);

            }
        });*/
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
       /* feedback.setOnClickListener(new View.OnClickListener() {
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
        });*/


       /* review.setOnClickListener(new View.OnClickListener() {
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
        });*/



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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.android_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int s=item.getItemId();
        switch (s){
            case R.id.attendance:
                Intent intent=new Intent(Android_details_student.this,Student_attendance.class);
                intent.putExtra("eventname",s1);
                intent.putExtra("a2",s2);
                intent.putExtra("a3",s3);
                intent.putExtra("a4",s4);
                intent.putExtra("a5",s5);
                intent.putExtra("a6",s6);
                intent.putExtra("a7",s7);
                intent.putExtra("a8",s8);
                intent.putExtra("a9",link1);
                startActivity(intent);
                finish();
                break;
            case R.id.feedbackmenu:
                Intent i=new Intent(Android_details_student.this,Feedback.class);
                i.putExtra("a1",s1);
                i.putExtra("a2",s2);
                i.putExtra("a3",s3);
                i.putExtra("a4",s4);
                i.putExtra("a5",s5);
                i.putExtra("a6",s6);
                i.putExtra("a7",s7);
                i.putExtra("a8",s8);
                i.putExtra("a9",link1);
                startActivity(i);
                break;
           /* case R.id.add:
                Intent intent1=new Intent(Intent.ACTION_GET_CONTENT);
                intent1.setType("image/*");
                intent1.putExtra("name",s1);
                intent1.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
                startActivityForResult(intent1,PIC_IMAGE);
                break;
            case R.id.view:
                Intent i1 =new Intent(Android_details_student.this,images_display.class);
                i1.putExtra("s1",s1);
                startActivity(i1);
                break;*/
                default:break;


        }
        return true;
    }


}
