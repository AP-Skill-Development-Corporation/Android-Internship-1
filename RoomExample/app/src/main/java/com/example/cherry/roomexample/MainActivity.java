package com.example.cherry.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cherry.roomexample.RDB.Rdatabase;
import com.example.cherry.roomexample.RDB.Rtable;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Rdatabase rdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.name);
        rdb = Room.databaseBuilder(this,Rdatabase.class,"MYROOM").allowMainThreadQueries().build();
    }

    public void submit(View view) {
        String name = et.getText().toString();
        Rtable rtable = new Rtable();
        rtable.setName(name);
        rdb.rdao().insert(rtable);
       List<Rtable> list = rdb.rdao().getall();
        Toast.makeText(this, ""+list.get(0).getName(), Toast.LENGTH_SHORT).show();

    }
}