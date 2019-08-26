package com.example.myappyy;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    FirebaseAuth auth;

    String type;
    DatabaseReference ref;

    CardView l1, l2, l3, l4, l5, card,ll10,ll11,ll12,ll13,ll14,ll15,ll16,ll17,card2;

    int i,j;

    Animation top, bottom;

    ViewPager viewPager1,viewPager2;
    LinearLayout dots1,dots2;

    TextView[] tdots,tdots1;


    SliderAdapter sliderAdapter;
    SliderAdapter1 sliderAdapter1;

    Integer[] imageId = {R.drawable.and_2, R.drawable.and_2, R.drawable.ml, R.drawable.iot,R.drawable.dsc};
    Integer[] imageId1= {R.drawable.ieee,R.drawable.and_2,R.drawable.csi,R.drawable.iste};
    String[] imagesName = {"image1", "image2", "image3", "image4","image5"};
    String[] imagesName1={"image6","image7","image8","image9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l1 = findViewById(R.id.li1);
        l2 = findViewById(R.id.li2);
        l3 = findViewById(R.id.li3);
        l4 = findViewById(R.id.li4);
        l5 = findViewById(R.id.li5);
        ll10=findViewById(R.id.ll10);
        ll11=findViewById(R.id.ll11);
        ll12=findViewById(R.id.ll12);
        ll13=findViewById(R.id.ll13);
        ll14=findViewById(R.id.ll14);
        ll15=findViewById(R.id.ll15);
        ll16=findViewById(R.id.ll16);
        ll17=findViewById(R.id.ll17);
        card = findViewById(R.id.card);
        card2 = findViewById(R.id.card2);

        bottom = AnimationUtils.loadAnimation(MainActivity.this, R.anim.from_bottom);
        top = AnimationUtils.loadAnimation(MainActivity.this, R.anim.from_top);

        l1.setAnimation(top);
        l2.setAnimation(bottom);
        l3.setAnimation(top);
        l4.setAnimation(bottom);
        l5.setAnimation(top);
        ll10.setAnimation(top);
        ll11.setAnimation(bottom);
        ll12.setAnimation(top);
        ll13.setAnimation(bottom);
        ll14.setAnimation(top);
        ll15.setAnimation(bottom);
        ll16.setAnimation(top);
        ll17.setAnimation(bottom);

        toolbar = (Toolbar) findViewById(R.id.toolbar_main1);
        setSupportActionBar(toolbar);
        auth=FirebaseAuth.getInstance();
        getSupportActionBar().setTitle("MyAppy");

        viewPager1 = findViewById(R.id.viewpager1);
        dots1 = findViewById(R.id.dots1);
        viewPager2 = findViewById(R.id.viewpager2);
        dots2 = findViewById(R.id.dots2);

        sliderAdapter = new SliderAdapter(this);
        sliderAdapter1 = new SliderAdapter1(this);

        viewPager1.setAdapter(sliderAdapter);
        viewPager2.setAdapter(sliderAdapter1);

        viewPager1.addOnPageChangeListener(changeListener);
        viewPager2.addOnPageChangeListener(changeListener1);


        Dotsindicator(0);
        Dotsindicator1(0);

        Timer timer = new Timer();
        Timer timer1=new Timer();
        timer.scheduleAtFixedRate(new Mytimer(), 2000, 4000);
        timer1.scheduleAtFixedRate(new Mytimer1(), 2000, 4000);



    }


    private void Dotsindicator1(int position1) {
        tdots1 = new TextView[4];
        dots2.removeAllViews();

        for (i = 0; i < tdots1.length; i++) {
            tdots1[i] = new TextView(this);
            tdots1[i].setText(Html.fromHtml("&#8226"));
            tdots1[i].setTextSize(35);
            tdots1[i].setTextColor(getResources().getColor(R.color.black));

            dots2.addView(tdots1[i]);
        }

        if (tdots1.length > 0) {
            tdots1[position1].setTextColor(getResources().getColor(R.color.white));
        }

    }

    public void Dotsindicator(int position) {
        tdots = new TextView[5];
        dots1.removeAllViews();

        for (j = 0; j < tdots.length; j++) {
            tdots[j] = new TextView(this);
            tdots[j].setText(Html.fromHtml("&#8226"));
            tdots[j].setTextSize(35);
            tdots[j].setTextColor(getResources().getColor(R.color.black));

            dots1.addView(tdots[j]);

        }

        if (tdots.length > 0) {
            tdots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }



    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            Dotsindicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    ViewPager.OnPageChangeListener changeListener1=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) { Dotsindicator1(i);

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    public class Mytimer extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager1.getCurrentItem() == 0) {
                        viewPager1.setCurrentItem(1);
                    } else if (viewPager1.getCurrentItem() == 1) {
                        viewPager1.setCurrentItem(2);
                    } else if (viewPager1.getCurrentItem() == 2) {
                        viewPager1.setCurrentItem(3);
                    }else if(viewPager1.getCurrentItem()==3){
                        viewPager1.setCurrentItem(4);
                    } else {
                        viewPager1.setCurrentItem(0);
                    }
                }
            });
        }


    }
    public class Mytimer1 extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager2.getCurrentItem() == 0) {
                        viewPager2.setCurrentItem(1);
                    } else if (viewPager2.getCurrentItem() == 1) {
                        viewPager2.setCurrentItem(2);
                    } else if (viewPager2.getCurrentItem() == 2) {
                        viewPager2.setCurrentItem(3);
                    } else {
                        viewPager2.setCurrentItem(0);
                    }
                }
            });
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int s=item.getItemId();
        switch (s){
            case R.id.i1:
                auth.signOut();
                Intent intent=new Intent(MainActivity.this,Loginpage.class);
                startActivity(intent);
                finish();

        }
        return true;
    }



}
