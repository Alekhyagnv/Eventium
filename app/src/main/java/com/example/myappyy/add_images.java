package com.example.myappyy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.HashMap;

public class add_images extends AppCompatActivity {
    Button choose,upload;
    TextView alert;
    private static final int PICK_IMAGE = 1;
    String s1;
    ArrayList<Uri> ImageList=new ArrayList<Uri>();
    private Uri ImageUri;
    private ProgressDialog progressDialog;
    private int Upload_count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_images);
            alert=(TextView)findViewById(R.id.alert);
            choose=findViewById(R.id.choose);
            s1=getIntent().getStringExtra("name");
            upload=findViewById(R.id.upload);
            progressDialog=new ProgressDialog(this);
            progressDialog.setMessage("Please wait uploading image.....!");
            choose.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                    intent.setType("image/*");
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
                    startActivityForResult(intent,PICK_IMAGE);
                }
            });
            upload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    progressDialog.show();
                    alert.setText("If loading takes too long please press the button again.");
                    StorageReference ImageFolder= FirebaseStorage.getInstance().getReference().child("ImageFolder");
                    for (Upload_count=0;Upload_count <ImageList.size();Upload_count++)
                    {
                        Uri IndividualImage=ImageList.get(Upload_count);
                        final StorageReference ImageName=ImageFolder.child("Image"+IndividualImage.getLastPathSegment());
                        ImageName.putFile(IndividualImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                ImageName.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        String url= String.valueOf(uri);
                                        StoreLink(url);
                                    }
                                });
                            }
                        });

                    }
                }
            });
    }

    private void StoreLink(String url) {
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("images").child(s1);
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("imglink",url);
        databaseReference.push().setValue(hashMap);
        progressDialog.dismiss();
        alert.setText("Image uploaded successfully..!");
        upload.setVisibility(View.GONE);
        ImageList.clear();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE)
        {
            if(resultCode==RESULT_OK)
            {
                if(data.getClipData()!=null)
                {

                   int countClipData=data.getClipData().getItemCount();
                   int currentImageSelect=0;
                   while (currentImageSelect<countClipData)
                   {

                    ImageUri=data.getClipData().getItemAt(currentImageSelect).getUri();
                    ImageList.add(ImageUri);
                       currentImageSelect = currentImageSelect + 1;
                   }

                   alert.setVisibility(View.VISIBLE);
                   alert.setText("you have selected "+ImageList.size()+" Images");
                   choose.setVisibility(View.GONE);

                }else {
                    Toast.makeText(this,"please select multiple images",Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
