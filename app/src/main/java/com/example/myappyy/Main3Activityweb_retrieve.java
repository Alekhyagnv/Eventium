package com.example.myappyy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Main3Activityweb_retrieve extends AppCompatActivity {

    RecyclerView eventslist;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_activityweb_retrieve);


        eventslist = (RecyclerView) findViewById(R.id.recyclerviewweb);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        eventslist.setLayoutManager(linearLayoutManager);

        validateeventslist();


    }

    private void validateeventslist() {

        reference= FirebaseDatabase.getInstance().getReference().child("Clubs").child("Webclub");

        FirebaseRecyclerAdapter<Events, Main3Activityweb_retrieve.eventslistviewholder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Events, Main3Activityweb_retrieve.eventslistviewholder>
                (
                        Events.class,R.layout.events_info, Main3Activityweb_retrieve.eventslistviewholder.class,reference
                ) {
            @Override
            protected void populateViewHolder(Main3Activityweb_retrieve.eventslistviewholder viewHolder, Events model, int position) {

                viewHolder.setEventname(model.getEventname());
                viewHolder.setInfo(model.getInfo());
                viewHolder.setImage(model.getImage());
                viewHolder.setStudents(model.getStudents());
                viewHolder.setDate(model.getDate());
                final String s1=model.getEventname();
                final String s3=model.getInfo();
                final String s5=model.getImage();
                final String s4=model.getStudents();
                final String s2=model.getDate();
                //final String s6=model.getUid();

                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent=new Intent(Main3Activityweb_retrieve.this,Android_details.class);
                        intent.putExtra("a1",s1);
                        intent.putExtra("a2",s2);
                        intent.putExtra("a3",s3);
                        intent.putExtra("a4",s4);
                        intent.putExtra("a5",s5);
                        //intent.putExtra("a6",s6);
                        startActivity(intent);



                    }
                });
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
                ImageView imageView = mview.findViewById(R.id.retrivalimg);
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
    }
}





