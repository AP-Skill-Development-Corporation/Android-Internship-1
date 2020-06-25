package com.example.cherry.databaseex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et,et1,et2,u,u1;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.name);
        et1 = findViewById(R.id.roll);
        et2 = findViewById(R.id.number);
        u = findViewById(R.id.uroll);
        u1 = findViewById(R.id.unumber);

    }

    public void save(View view) {
        //Code to save the data in the firebase database.
    }

    public void update(View view) {
        //Code to update the existing data in the firebase database.
    }

    public void viewData(View view) {
        //To navigate to another activity and to view the data.
    }
}