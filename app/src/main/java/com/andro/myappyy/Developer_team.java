package com.andro.myappyy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.ramotion.foldingcell.FoldingCell;

public class Developer_team extends AppCompatActivity {

    ImageView hand,hand1,hand2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_team);

        hand=findViewById(R.id.hand);
        hand1=findViewById(R.id.hand100);
        hand2=findViewById(R.id.hand101);

        Animation blinkLogo = AnimationUtils.loadAnimation(this, R.anim.animation);
        hand.setAnimation(blinkLogo);

        Animation blinkLogo1 = AnimationUtils.loadAnimation(this, R.anim.animation);
        hand1.setAnimation(blinkLogo1);

        Animation blinkLogo2 = AnimationUtils.loadAnimation(this, R.anim.animation);
        hand2.setAnimation(blinkLogo2);

        final FoldingCell fc = (FoldingCell) findViewById(R.id.folding_cell);
        final FoldingCell fc2 = (FoldingCell) findViewById(R.id.folding_cell100);
        final FoldingCell fc3 = (FoldingCell) findViewById(R.id.folding_cell101);

        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(false);
            }
        });

        fc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc2.toggle(false);
            }
        });

        fc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc3.toggle(false);
            }
        });





    }
}
