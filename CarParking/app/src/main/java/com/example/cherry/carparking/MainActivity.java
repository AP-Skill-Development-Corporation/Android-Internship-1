package com.example.cherry.carparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button s1,s2,s3,s4;
    DatabaseReference reference;
    Date startDate,endDate;
    AlarmManager manger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1 = findViewById(R.id.slot1);
        s2 = findViewById(R.id.slot2);
        s3 = findViewById(R.id.slot3);
        s4 = findViewById(R.id.slot4);
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("slot1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String status = snapshot.child("k").getValue(String.class);
                    String value = snapshot.child("defValue").getValue(String.class);
                    String st = snapshot.child("st").getValue(String.class);
                    String et = snapshot.child("et").getValue(String.class);
                    //fetchStatus(st,et,"slot1");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                    try {
                        startDate = simpleDateFormat.parse(st);
                        endDate = simpleDateFormat.parse(et);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    long difference = endDate.getTime() - startDate.getTime();
                    int days = (int) (difference / (1000 * 60 * 60 * 24));
                    int hours = (int) ((difference - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
                    final int min = (int) (difference - (1000 * 60 * 60 * 24 * days) - (1000 * 60 * 60 * hours)) / (1000 * 60);
                    Toast.makeText(MainActivity.this, "" + min, Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            HashMap<String, Object> map = new HashMap<>();
                            map.put("k", "0");
                            reference.child("slot1").getRef().updateChildren(map);
                        }
                    },min*60*1000);
                    /*Thread t = new Thread() {
                        @Override
                        public void run() {
                            try {
                                sleep(min * 60 * 1000);
                                HashMap<String, Object> map = new HashMap<>();
                                map.put("k", "0");
                                reference.child("slot1").getRef().updateChildren(map);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    t.start();
*/
                    if (status.equals("0") && value.equals("0")) {
                        s1.setBackgroundColor(Color.RED);
                        s1.setEnabled(false);
                    } else if (status.equals("0") && value.equals("1")) {
                        s1.setBackgroundColor(Color.GREEN);
                        s1.setEnabled(true);
                    } else if (status.equals("1") && value.equals("0")) {
                        s1.setBackgroundColor(Color.YELLOW);
                        s1.setEnabled(false);
                    } else {
                        s1.setBackgroundColor(Color.BLUE);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("slot2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String status = snapshot.child("k").getValue(String.class);
                    String value = snapshot.child("defValue").getValue(String.class);
                    String st = snapshot.child("st").getValue(String.class);
                    String et = snapshot.child("et").getValue(String.class);
                  //  fetchStatus(st,et,"slot2");
                    Toast.makeText(MainActivity.this, "" + status + "::" + value, Toast.LENGTH_SHORT).show();
                    if (status.equals("0") && value.equals("0")) {
                        s1.setBackgroundColor(Color.RED);
                        s1.setEnabled(false);
                    } else if (status.equals("0") && value.equals("1")) {
                        s1.setBackgroundColor(Color.BLUE);
                        s1.setEnabled(false);
                    } else if (status.equals("1") && value.equals("0")) {
                        s1.setBackgroundColor(Color.YELLOW);
                        s1.setEnabled(false);
                    } else {
                        s1.setBackgroundColor(Color.GREEN);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("slot3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String status = snapshot.child("k").getValue(String.class);
                    String value = snapshot.child("defValue").getValue(String.class);
                    String st = snapshot.child("st").getValue(String.class);
                    String et = snapshot.child("et").getValue(String.class);
                   // fetchStatus(st,et,"slot3");
                    Toast.makeText(MainActivity.this, "" + status + "::" + value, Toast.LENGTH_SHORT).show();
                    if (status.equals("0") && value.equals("0")) {
                        s1.setBackgroundColor(Color.RED);
                        s1.setEnabled(false);
                    } else if (status.equals("0") && value.equals("1")) {
                        s1.setBackgroundColor(Color.BLUE);
                        s1.setEnabled(false);
                    } else if (status.equals("1") && value.equals("0")) {
                        s1.setBackgroundColor(Color.YELLOW);
                        s1.setEnabled(false);
                    } else {
                        s1.setBackgroundColor(Color.GREEN);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("slot4").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String status = snapshot.child("k").getValue(String.class);
                    String value = snapshot.child("defValue").getValue(String.class);
                    String st = snapshot.child("st").getValue(String.class);
                    String et = snapshot.child("et").getValue(String.class);
                   // fetchStatus(st,et,"slot4");
                    Toast.makeText(MainActivity.this, "" + status + "::" + value, Toast.LENGTH_SHORT).show();
                    if (status.equals("0") && value.equals("0")) {
                        s1.setBackgroundColor(Color.RED);
                        s1.setEnabled(false);
                    } else if (status.equals("0") && value.equals("1")) {
                        s1.setBackgroundColor(Color.BLUE);
                        s1.setEnabled(false);
                    } else if (status.equals("1") && value.equals("0")) {
                        s1.setBackgroundColor(Color.YELLOW);
                        s1.setEnabled(false);
                    } else {
                        s1.setBackgroundColor(Color.GREEN);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("slot","slot1");
                startActivity(i);
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("slot","slot2");
                startActivity(i);
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("slot","slot3");
                startActivity(i);
            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("slot","slot4");
                startActivity(i);
            }
        });
    }
   /* private void fetchStatus(String st, String et, final String slot) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        try {
            startDate = simpleDateFormat.parse(st);
            endDate = simpleDateFormat.parse(et);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long difference = endDate.getTime() - startDate.getTime();
        int days = (int) (difference / (1000*60*60*24));
        int hours = (int) ((difference - (1000*60*60*24*days)) / (1000*60*60));
        final int min = (int) (difference - (1000*60*60*24*days) - (1000*60*60*hours)) / (1000*60);
        Toast.makeText(MainActivity.this, ""+min, Toast.LENGTH_SHORT).show();
        Thread t=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(min*60*1000);
                    HashMap<String,Object> map = new HashMap<>();
                    map.put("k","0");
                    reference.child(slot).getRef().updateChildren(map);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }*/
    }
