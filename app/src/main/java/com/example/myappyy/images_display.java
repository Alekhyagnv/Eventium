package com.example.myappyy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.example.myappyy.R.layout.recyclerview_items;

public class images_display extends AppCompatActivity {
    RecyclerView eventslist;
    DatabaseReference reference;
    String s1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_display);

        s1=getIntent().getStringExtra("s1");


        eventslist = (RecyclerView) findViewById(R.id.recyclerView_images1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        eventslist.setLayoutManager(linearLayoutManager);


        validateeventslist();


    }

    private void validateeventslist() {

        reference= FirebaseDatabase.getInstance().getReference().child("Reportimages").child("Clubs").child("Androidclub").child(s1);

        FirebaseRecyclerAdapter<ImageUploadInfo, images_display.eventslistviewholder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<ImageUploadInfo, images_display.eventslistviewholder>
                (
                      ImageUploadInfo.class, R.layout.recyclerview_items, images_display.eventslistviewholder.class,reference
                ) {
            @Override
            protected void populateViewHolder(images_display.eventslistviewholder viewHolder, ImageUploadInfo model, int position) {


                viewHolder.setImage(model.getImage());


                final String s5=model.getImage();
                        //   final String s6=model.getUid();

                /*viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent=new Intent(images_display.this,images_display.class);

                        intent.putExtra("a5",s5);



                        startActivity(intent);



                    }
                });*/



            }
        };
        eventslist.setAdapter(firebaseRecyclerAdapter);


    }

    public static class eventslistviewholder extends RecyclerView.ViewHolder {
        View mview;

        public eventslistviewholder(@NonNull View itemView) {
            super(itemView);
            mview = itemView;
        }



        public void setImage(String image) {

                ImageView imageView = mview.findViewById(R.id.imageView_extra);
                Picasso.get().load(image).into(imageView);
            }

        }

    }



