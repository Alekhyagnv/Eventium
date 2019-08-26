package com.example.myappyy;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Piechart extends AppCompatActivity {

    Float ydata[]={0.0f,0.0f,0.0f,0.0f,0.0f};
    String xdata[]={"Excellent","Very Good","Good","Average","Poor"};
    PieChart pieChart;

    ArrayList<PieEntry> years=new ArrayList<>();
    ArrayList<String> xentries=new ArrayList<>();

    Float f1,f2,f3,f4,f5;

    TextView t1;

    String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piechart);


        pieChart=findViewById(R.id.piechart);






    }


    @Override
    protected void onStart() {
        super.onStart();

        s1= getIntent().getStringExtra("s1");



        DatabaseReference reference=FirebaseDatabase.getInstance().getReference().child("Feedback").child(s1);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                {
                    if(dataSnapshot.hasChild("Excellent"))
                    {
                       int temp;
                        temp= (int) dataSnapshot.child("Excellent").getChildrenCount();
                        String t1=String.valueOf(temp);
                        f1= Float.valueOf(t1);
                        years.add(new PieEntry(f1,"Excellent"));

                    }
                    if(dataSnapshot.hasChild("Verygood"))
                    {
                       int temp;
                        temp= (int) dataSnapshot.child("Verygood").getChildrenCount();
                        String t1=String.valueOf(temp) ;
                        f2= Float.valueOf(t1);

                        years.add(new PieEntry(f2,"Verygood"));
                    }
                    if(dataSnapshot.hasChild("Good"))
                    {
                         int temp;
                        temp= (int) dataSnapshot.child("Good").getChildrenCount();
                        String t1=String.valueOf(temp) ;

                        f3= Float.valueOf(t1);
                        years.add(new PieEntry(f3,"Good"));
                    }
                    if(dataSnapshot.hasChild("Average"))
                    {
                        int temp;
                        temp= (int) dataSnapshot.child("Average").getChildrenCount();
                        String t1=String.valueOf(temp) ;

                        f4= Float.valueOf(t1);
                        years.add(new PieEntry(f4,"Average"));
                    }
                    if(dataSnapshot.hasChild("Poor"))
                    {
                        int temp;
                        temp= (int) dataSnapshot.child("Poor").getChildrenCount();
                        String t1=String.valueOf(temp) ;
                        f5= Float.valueOf(t1);
                        years.add(new PieEntry(f5,"Poor"));
                    }

                    pieChart.setRotationEnabled(true);
                    pieChart.setHoleRadius(25f);
                    pieChart.setCenterText("Feedback");
                    pieChart.setCenterTextSize(10);

                    PieDataSet dataSet=new PieDataSet(years,"Feedback");
                    dataSet.setSliceSpace(2);
                    dataSet.setValueTextSize(12);
                    ArrayList<Integer> colors=new ArrayList<>();
                    colors.add(Color.GRAY);
                    colors.add(Color.BLUE);
                    colors.add(Color.RED);
                    colors.add(Color.GREEN);
                    colors.add(Color.CYAN);
                    dataSet.setColors(colors);


                    Legend legend=pieChart.getLegend();
                    legend.setForm(Legend.LegendForm.CIRCLE);

                    PieData pieData=new PieData(dataSet);
                    pieChart.setData(pieData);
                    pieChart.invalidate();


                }
                else {
                    Toast.makeText(Piechart.this,"exit",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }
}

