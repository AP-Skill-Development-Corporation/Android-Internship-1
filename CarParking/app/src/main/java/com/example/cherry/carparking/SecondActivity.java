package com.example.cherry.carparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SecondActivity extends AppCompatActivity {

    EditText name,cnumber,stime,etime;
    String slot;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        name = findViewById(R.id.name);
        cnumber = findViewById(R.id.cnum);
        stime = findViewById(R.id.stime);
        etime = findViewById(R.id.etime);
        slot = getIntent().getStringExtra("slot");
        reference = FirebaseDatabase.getInstance().getReference(slot);
    }

    public void book(View view) {
        String n = name.getText().toString();
        String number = cnumber.getText().toString();
        String st = stime.getText().toString();
        String et = etime.getText().toString();
        String k = "1";
        String defValue = "0";
        Pojo pojo = new Pojo(n,number,st,et,k,defValue);
        reference.setValue(pojo).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(SecondActivity.this, "Upload Successful", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SecondActivity.this, "Upload Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
    }
}