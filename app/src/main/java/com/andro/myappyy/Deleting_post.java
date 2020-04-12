package com.andro.myappyy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Deleting_post extends AppCompatActivity {

    RadioButton rb1;
    RadioGroup radioGroup;

    Button b1;
    String a1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleting_post);

        radioGroup= findViewById(R.id.radio_group_register1);

        b1=findViewById(R.id.post_del);

        a1=getIntent().getStringExtra("s1");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String s1=rb1.getText().toString();
                String s2="ANDROID CLUB";
                String s3="MALAI CLUB";
                String s4="IOT CLUB";
                String s5="WEB CLUB";
                String s6="DSC CLUB";
                String s7="CSI CHAPTER";
                String s8="IEEE CHAPTER";
                String s9="ACM CHAPTER";
                String s10="ISTE CHAPTER";

                if(s1.equals(s2))
                {
                    FirebaseAuth auth=FirebaseAuth.getInstance();
                    FirebaseUser user=auth.getCurrentUser();
                    final String uid=user.getUid();

                    final DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("Clubs").child("Androidclub");
                    final DatabaseReference ref1= FirebaseDatabase.getInstance().getReference().child("Feedback");
                    final DatabaseReference ref2= FirebaseDatabase.getInstance().getReference().child("Reportimages").child("Clubs").child("Androidclub");
                    final DatabaseReference ref3= FirebaseDatabase.getInstance().getReference().child("attendance");


                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(uid))
                                {
                                    ref.child(uid).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                }
                if(s1.equals(s3))
                {
                    FirebaseAuth auth=FirebaseAuth.getInstance();
                    FirebaseUser user=auth.getCurrentUser();
                    final String uid=user.getUid();

                    final DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("Clubs").child("Malaiclub");
                    final DatabaseReference ref1= FirebaseDatabase.getInstance().getReference().child("Feedback");
                    final DatabaseReference ref2= FirebaseDatabase.getInstance().getReference().child("Reportimages").child("Clubs").child("Androidclub");
                    final DatabaseReference ref3= FirebaseDatabase.getInstance().getReference().child("attendance");


                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(uid))
                                {
                                    ref.child(uid).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                }
                if(s1.equals(s4))
                {
                    FirebaseAuth auth=FirebaseAuth.getInstance();
                    FirebaseUser user=auth.getCurrentUser();
                    final String uid=user.getUid();

                    final DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("Clubs").child("Iotclub");
                    final DatabaseReference ref1= FirebaseDatabase.getInstance().getReference().child("Feedback");
                    final DatabaseReference ref2= FirebaseDatabase.getInstance().getReference().child("Reportimages").child("Clubs").child("Androidclub");
                    final DatabaseReference ref3= FirebaseDatabase.getInstance().getReference().child("attendance");


                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(uid))
                                {
                                    ref.child(uid).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                }
                if(s1.equals(s5))
                {
                    FirebaseAuth auth=FirebaseAuth.getInstance();
                    FirebaseUser user=auth.getCurrentUser();
                    final String uid=user.getUid();

                    final DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("Clubs").child("Webclub");
                    final DatabaseReference ref1= FirebaseDatabase.getInstance().getReference().child("Feedback");
                    final DatabaseReference ref2= FirebaseDatabase.getInstance().getReference().child("Reportimages").child("Clubs").child("Androidclub");
                    final DatabaseReference ref3= FirebaseDatabase.getInstance().getReference().child("attendance");


                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(uid))
                                {
                                    ref.child(uid).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                }
                if(s1.equals(s6))
                {
                    FirebaseAuth auth=FirebaseAuth.getInstance();
                    FirebaseUser user=auth.getCurrentUser();
                    final String uid=user.getUid();

                    final DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("Clubs").child("Dscclub");
                    final DatabaseReference ref1= FirebaseDatabase.getInstance().getReference().child("Feedback");
                    final DatabaseReference ref2= FirebaseDatabase.getInstance().getReference().child("Reportimages").child("Clubs").child("Androidclub");
                    final DatabaseReference ref3= FirebaseDatabase.getInstance().getReference().child("attendance");


                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(uid))
                                {
                                    ref.child(uid).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                }
                if(s1.equals(s7))
                {
                    FirebaseAuth auth=FirebaseAuth.getInstance();
                    FirebaseUser user=auth.getCurrentUser();
                    final String uid=user.getUid();

                    final DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("Clubs").child("CSI");
                    final DatabaseReference ref1= FirebaseDatabase.getInstance().getReference().child("Feedback");
                    final DatabaseReference ref2= FirebaseDatabase.getInstance().getReference().child("Reportimages").child("Clubs").child("Androidclub");
                    final DatabaseReference ref3= FirebaseDatabase.getInstance().getReference().child("attendance");


                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(uid))
                                {
                                    ref.child(uid).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                }

                if(s1.equals(s8))
                {
                    FirebaseAuth auth=FirebaseAuth.getInstance();
                    FirebaseUser user=auth.getCurrentUser();
                    final String uid=user.getUid();

                    final DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("Clubs").child("ACM");
                    final DatabaseReference ref1= FirebaseDatabase.getInstance().getReference().child("Feedback");
                    final DatabaseReference ref2= FirebaseDatabase.getInstance().getReference().child("Reportimages").child("Clubs").child("Androidclub");
                    final DatabaseReference ref3= FirebaseDatabase.getInstance().getReference().child("attendance");


                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(uid))
                                {
                                    ref.child(uid).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                }

                if(s1.equals(s9))
                {
                    FirebaseAuth auth=FirebaseAuth.getInstance();
                    FirebaseUser user=auth.getCurrentUser();
                    final String uid=user.getUid();

                    final DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("Clubs").child("IEEE");
                    final DatabaseReference ref1= FirebaseDatabase.getInstance().getReference().child("Feedback");
                    final DatabaseReference ref2= FirebaseDatabase.getInstance().getReference().child("Reportimages").child("Clubs").child("Androidclub");
                    final DatabaseReference ref3= FirebaseDatabase.getInstance().getReference().child("attendance");


                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(uid))
                                {
                                    ref.child(uid).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                }
                if(s1.equals(s10))
                {
                    FirebaseAuth auth=FirebaseAuth.getInstance();
                    FirebaseUser user=auth.getCurrentUser();
                    final String uid=user.getUid();

                    final DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("Clubs").child("ISTE");
                    final DatabaseReference ref1= FirebaseDatabase.getInstance().getReference().child("Feedback");
                    final DatabaseReference ref2= FirebaseDatabase.getInstance().getReference().child("Reportimages").child("Clubs").child("Androidclub");
                    final DatabaseReference ref3= FirebaseDatabase.getInstance().getReference().child("attendance");


                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(uid))
                                {
                                    ref.child(uid).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    ref3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild(s1))
                                {
                                    ref.child(s1).removeValue();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                }

            }

        });

    }

    public void radioclick(View view) {

        int radioid=radioGroup.getCheckedRadioButtonId();

        rb1=view.findViewById(radioid);
    }
}
