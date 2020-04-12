package com.andro.myappyy;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SliderAdapter1 extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater1;
    FirebaseAuth auth;
    DatabaseReference ref;
    public String type;
    String temp="FACULTY";


    public SliderAdapter1(Context context) {
        this.context = context;
    }

    public int[] sliding_image1=
            {
                    R.drawable.ieee, R.drawable.acm1, R.drawable.csi, R.drawable.iste};

    public String[] slide_headings1=
            {
                    "IEEE","ACM","CSI","ISTE"
            };


    @Override
    public int getCount() {
        return slide_headings1.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        FirebaseAuth auth1=FirebaseAuth.getInstance();

        String uid= auth1.getCurrentUser().getUid();

        ref= FirebaseDatabase.getInstance().getReference().child("users");

        ref.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    if(dataSnapshot.hasChild("type"))
                    {
                        type=dataSnapshot.child("type").getValue().toString();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        layoutInflater1=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater1.inflate(R.layout.activity_slider_adapter1,container,false);

        ImageView imageView= view.findViewById(R.id.slide_image2);
        TextView textView=view.findViewById(R.id.slide_heading2);

        imageView.setImageResource(sliding_image1[position]);
        textView.setText(slide_headings1[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0)
                {
                    //String temp11="FACULTY";
                    if(type.equals(temp))
                    {
                        v.getContext().startActivity(new Intent(context, Ieee_options.class));
                    }
                    else
                    {
                        v.getContext().startActivity(new Intent(context, Main3Activityieee_retrieve.class));

                    }

                }
                else if(position==1)
                {
                    //String temp2="FACULTY";
                    //String temp2 = "FACULTY";
                    if(type.equals(temp))
                    {
                        v.getContext().startActivity(new Intent(context, Acm_options.class));
                    }
                    else
                    {
                        v.getContext().startActivity(new Intent(context, Main3Activityacm_retrieve.class));
                    }
                    //Toast.makeText(context, "ACM", Toast.LENGTH_SHORT).show();
                }
                else if(position==2)
                {
                    //String temp1="FACULTY";
                    if(type.equals(temp))
                    {
                        v.getContext().startActivity(new Intent(context, Csi_options.class));
                    }
                    else
                    {
                        v.getContext().startActivity(new Intent(context, Main3Activitycsi_retrieve.class));
                    }
                    //Toast.makeText(context, "CSI", Toast.LENGTH_SHORT).show();
                }
                else if(position==3)
                {
                    //String temp="FACULTY";
                    if(type.equals(temp))
                    {

                        v.getContext().startActivity(new Intent(context, Iste_options.class));
                    }
                    else
                    {
                        v.getContext().startActivity(new Intent(context, Main3Activityiste_retrieve.class));
                    }
                    //Toast.makeText(context, "ISTE", Toast.LENGTH_SHORT).show();
                }
            }
        });

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}