package com.andro.myappyy;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import id.zelory.compressor.Compressor;

public class Main3Activityanim extends AppCompatActivity {
    private ImageView profile;
    private EditText eventname,dateed,targeted,info,link,oplink;
    private Button uploadBtn1,save;
    ProgressDialog progressDialog;

    private Uri postImageUri = null;


    String postdate,posttime,postrandomname,downloadurl;
    DatabaseReference useref,postref;

    String event,date1,target,info1,uid,link1,link2;



    private StorageReference storageReference;

    private FirebaseAuth firebaseAuth;



    String thumb_downloadurl;

    private Bitmap compressedImageFile=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_activityanim);
        storageReference = FirebaseStorage.getInstance().getReference();


        postref= FirebaseDatabase.getInstance().getReference().child("Clubs").child("Animation");

        eventname=(EditText)findViewById(R.id.edanimeventname) ;
        dateed=(EditText)findViewById(R.id.edanimdate) ;
        targeted=(EditText)findViewById(R.id.edanimtarget) ;
        uploadBtn1=(Button)findViewById(R.id.banimupload);
        info=(EditText)findViewById(R.id.edanimprofile);
        link=(EditText)findViewById(R.id.edanimlink);
        oplink = findViewById(R.id.edanimlink1);
        save=(Button)findViewById(R.id.banimsave);
        profile=(ImageView)findViewById(R.id.imganim) ;



        progressDialog=new ProgressDialog(this);
        uploadBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .setMinCropResultSize(512, 512)
                        .setAspectRatio(1, 1)
                        .start(Main3Activityanim.this);

            }
        });
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel() {
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                dateed.setText(sdf.format(myCalendar.getTime()));
            }

        };
        dateed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(Main3Activityanim.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });






        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                event=eventname.getText().toString();
                date1=dateed.getText().toString();
                info1=info.getText().toString();
                target=targeted.getText().toString();
                link1=link.getText().toString();
                link2 = oplink.getText().toString();
                if(TextUtils.isEmpty(event))
                {
                    Toast.makeText(Main3Activityanim.this,"Please enter the Event Name",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(date1))
                {
                    Toast.makeText(Main3Activityanim.this,"Please fill the date",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(info1))
                {
                    Toast.makeText(Main3Activityanim.this,"Please fill the profile",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(target))
                {
                    Toast.makeText(Main3Activityanim.this,"Please fill the targeted students",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(link1))
                {
                    Toast.makeText(Main3Activityanim.this,"Please fill the link",Toast.LENGTH_LONG).show();
                }
                else if(postImageUri==null)
                {
                    Toast.makeText(Main3Activityanim.this,"Please Select the Image to Post",Toast.LENGTH_LONG).show();
                }
                else {

                    progressDialog.setMessage("Please Wait...");
                    progressDialog.setTitle("Uploading");
                    progressDialog.show();
                    progressDialog.setCancelable(false);


                    Calendar calendardate=Calendar.getInstance();
                    SimpleDateFormat currentdate=new SimpleDateFormat("dd-MMMM-yyyy");
                    postdate=currentdate.format(calendardate.getTime());

                    Calendar calendartime=Calendar.getInstance();
                    SimpleDateFormat currenttime=new SimpleDateFormat("hh:mm a");
                    posttime=currenttime.format(calendartime.getTime());

                    postrandomname=postdate+posttime;


                    ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
                    compressedImageFile.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream);

                    final byte[] cropbyte=byteArrayOutputStream.toByteArray();

                    StorageReference filepath=storageReference.child("animimages").child(postdate+posttime+".jpg");

                    final StorageReference thumb_filepath=storageReference.child("animimages").child(postdate+posttime+".jpg");

                    filepath.putFile(postImageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if(task.isSuccessful())
                            {
                                UploadTask uploadTask=thumb_filepath.putBytes(cropbyte);

                                uploadTask.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task_thump) {

                                        thumb_downloadurl=task_thump.getResult().getDownloadUrl().toString();

                                        if(task_thump.isSuccessful())
                                        {
                                            savingpostinfo();

                                        }

                                    }
                                });


                            }

                        }
                    });


                }
            }
        });



    }

    private void savingpostinfo() {
        firebaseAuth=FirebaseAuth.getInstance();
        uid=firebaseAuth.getCurrentUser().getUid();
        link1=link.getText().toString();
        link2 = oplink.getText().toString();
        HashMap postmap=new HashMap();
        postmap.put("eventname",event);
        postmap.put("date",date1);
        postmap.put("info",info1);
        postmap.put("students",target);
        postmap.put("image",thumb_downloadurl);
        postmap.put("uid",uid);
        postmap.put("link",link1);
        postmap.put("optional_link",link2);
        postmap.put("club","Animation");
        postref.child(uid).updateChildren(postmap).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if(task.isSuccessful())
                {
                    progressDialog.dismiss();
                    Intent intent=new Intent(Main3Activityanim.this,Main3Activityanim_retrieve.class);
                    intent.putExtra("event",postrandomname);
                    startActivity(intent);

                    finish();
                }
                else
                {
                    progressDialog.dismiss();
                    String msg=task.getException().toString();
                    Toast.makeText(Main3Activityanim.this,"Error Occured :"+msg,Toast.LENGTH_LONG).show();
                }

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {

                postImageUri = result.getUri();
                Picasso.get().load(postImageUri).networkPolicy(NetworkPolicy.OFFLINE).into(profile);

                File crop_path=new File(postImageUri.getPath());


                try {
                    compressedImageFile=new Compressor(this)
                            .setMaxHeight(300)
                            .setMaxWidth(300).setQuality(100).compressToBitmap(crop_path);
                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }






            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {

                Exception error = result.getError();


            }
        }

    }

}

