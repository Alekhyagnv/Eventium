package com.andro.myappyy;

import android.content.Intent;
import android.content.Context;
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

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    FirebaseAuth auth;
    DatabaseReference ref;
    String type,no;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] sliding_image=
            {
                    R.drawable.and_2, R.drawable.ml, R.drawable.web_2, R.drawable.iot,R.drawable.dsc,R.drawable.daa,
                    R.drawable.nullclubb,R.drawable.animate,R.drawable.cloudclub1};

    public String[] slide_headings=
            {
                    "Android","Machine Learning","Web","IOT","DSC","Data Analytics","Null Club","Animation Club","Cloud Club"
            };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        type="null";


        FirebaseAuth auth1=FirebaseAuth.getInstance();

        final String uid= auth1.getCurrentUser().getUid();

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
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.activity_slider_adapter,container,false);

        ImageView imageView= view.findViewById(R.id.slide_image);
        TextView textView=view.findViewById(R.id.slide_heading);

        imageView.setImageResource(sliding_image[position]);
        textView.setText(slide_headings[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0)
                {
                    String temp="FACULTY";
                    if(type.equals(temp))
                    {
                        v.getContext().startActivity(new Intent(context, faculty_options.class));
                    }
                    else
                    {
                        v.getContext().startActivity(new Intent(context, Main3Activityand_retrieve.class));

                    }

                }
                else if(position==1)
                {
                    String temp="FACULTY";

                   if(type.equals(temp))
                    {
                        v.getContext().startActivity(new Intent(context, Malai_options.class));

                    }
                    else
                    {
                        v.getContext().startActivity(new Intent(context, Main3Activitymalai_retrieve.class));
                    }

                }
                else if(position==2)
                {
                    String temp="FACULTY";
                    if(type.equals(temp))
                    {
                        v.getContext().startActivity(new Intent(context, Web_options.class));
                    }
                    else
                    {
                        v.getContext().startActivity(new Intent(context, Main3Activityweb_retrieve.class));

                    }
                    //Toast.makeText(context, "CSI", Toast.LENGTH_SHORT).show();
                }
                else if(position==3)
                {
                    String temp="FACULTY";
                    if(type.equals(temp))
                    {
                        v.getContext().startActivity(new Intent(context, Iot_options.class));
                    }
                    else
                    {
                        v.getContext().startActivity(new Intent(context, Main3Activityiot_retrieve.class));

                    }
                    //Toast.makeText(context, "ISTE", Toast.LENGTH_SHORT).show();
                }
                else if(position==4)
                {
                    String temp="FACULTY";
                    if(type.equals(temp))
                    {
                        v.getContext().startActivity(new Intent(context, Dsc_options.class));
                    }
                    else
                    {
                        v.getContext().startActivity(new Intent(context, Main3Activitydsc_retrieve.class));

                    }
                    //Toast.makeText(context, "ISTE", Toast.LENGTH_SHORT).show();
                }
                else if(position==5)
                {
                    String temp="FACULTY";
                    if(type.equals(temp))
                    {
                        v.getContext().startActivity(new Intent(context, Daa_options.class));
                    }
                    else
                    {
                        v.getContext().startActivity(new Intent(context, Main3Activitydaa_retrieve.class));

                    }
                    //Toast.makeText(context, "ISTE", Toast.LENGTH_SHORT).show();
                }
                else if(position==6)
                {
                    String temp="FACULTY";
                    if(type.equals(temp))
                    {
                        v.getContext().startActivity(new Intent(context, null_options.class));
                    }
                    else
                    {
                        v.getContext().startActivity(new Intent(context, Main3Activitynull_retrieve.class));

                    }
                    //Toast.makeText(context, "ISTE", Toast.LENGTH_SHORT).show();
                }
                else if(position==7)
                {
                    String temp="FACULTY";
                    if(type.equals(temp))
                    {
                        v.getContext().startActivity(new Intent(context, Anim_options.class));
                    }
                    else
                    {
                        v.getContext().startActivity(new Intent(context, Main3Activityanim_retrieve.class));

                    }
                    //Toast.makeText(context, "ISTE", Toast.LENGTH_SHORT).show();
                }
                else if(position==8)
                {
                    String temp="FACULTY";
                    if(type.equals(temp))
                    {
                        v.getContext().startActivity(new Intent(context, Cloud_options.class));
                    }
                    else
                    {
                        v.getContext().startActivity(new Intent(context, Main3Activitycloud_retrieve.class));

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

