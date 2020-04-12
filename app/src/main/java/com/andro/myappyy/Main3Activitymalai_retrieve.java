package com.andro.myappyy;

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

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Main3Activitymalai_retrieve extends AppCompatActivity {

    RecyclerView eventslist;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_activitymalai_retrieve);


        eventslist = (RecyclerView) findViewById(R.id.recyclerview_malai);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        eventslist.setLayoutManager(linearLayoutManager);

        validateeventslist();


    }

    private void validateeventslist() {

        reference= FirebaseDatabase.getInstance().getReference().child("Clubs").child("Malaiclub");

        final FirebaseRecyclerAdapter<Events,eventslistviewholder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Events, eventslistviewholder>
                (
                        Events.class,R.layout.events_info,Main3Activitymalai_retrieve.eventslistviewholder.class,reference
                ) {
            @Override
            protected void populateViewHolder(eventslistviewholder viewHolder, Events model, int position) {

                viewHolder.setEventname(model.getEventname());
                viewHolder.setImage(model.getImage());
                viewHolder.setLink1(model.getLink1());
                final String s1=model.getEventname();

                final ImageView img=viewHolder.itemView.findViewById(R.id.retrivalimg);

                final String s3=model.getInfo();
                final String s5=model.getImage();
                final String s4=model.getStudents();
                final String s2=model.getDate();
               final String s6=model.getLink();
                final String s7=model.getUid();
                final String s8=model.getClub();
                final String s9=model.getLink1();

                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Main3Activitymalai_retrieve.this,Android_details_student.class);
                        intent.putExtra("a1",s1);
                        intent.putExtra("a2",s2);
                        intent.putExtra("a3",s3);
                        intent.putExtra("a4",s4);
                        intent.putExtra("a5",s5);
                       intent.putExtra("a6",s6);
                        intent.putExtra("a7",s7);
                        intent.putExtra("a8",s8);
                        intent.putExtra("a9",s9);
                        startActivity(intent);



                    }
                });
            }
        };
        eventslist.setAdapter(firebaseRecyclerAdapter);


    }

    public static class eventslistviewholder extends RecyclerView.ViewHolder {
        View mview;

        ImageView imageView;

        public eventslistviewholder(@NonNull View itemView) {
            super(itemView);
            mview = itemView;
        }

        public void setDate(String date) {
            TextView t1 = mview.findViewById(R.id.retrivalbranch);
            t1.setText(date);
        }

        public void setEventname(String eventname) {
            TextView t2 = mview.findViewById(R.id.retrivalevent);
            t2.setText(eventname);
        }

        public void setImage(String image) {
            {
                imageView = mview.findViewById(R.id.retrivalimg);
                Picasso.get().load(image).into(imageView);
            }

        }
        public void setInfo(String info) {
            TextView t2 = mview.findViewById(R.id.retrivalt1);
            t2.setText(info);
        }

        public void setStudents(String students) {
            TextView t2 = mview.findViewById(R.id.retrivalt2);
            t2.setText(students);
        }
        public void setLink(String link) {
            TextView t4 = mview.findViewById(R.id.retrivallink);
            if(!TextUtils.isEmpty(link))
            {
                t4.setVisibility(View.VISIBLE);
                t4.setText(link);
            }

        }
        public void setLink1(String link) {
            TextView t5 = mview.findViewById(R.id.retrivallink);
            if(!TextUtils.isEmpty(link))
            {
                t5.setVisibility(View.VISIBLE);
                t5.setText(link);
            }
        }
    }




}



