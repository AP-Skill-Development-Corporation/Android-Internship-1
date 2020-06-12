package com.example.cherry.exampledb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cherry.exampledb.RDB.Rdatabase;
import com.example.cherry.exampledb.RDB.Rtable;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText num,name;
   RecyclerView rv;
    Rdatabase rdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = findViewById(R.id.rnumber);
        name = findViewById(R.id.name);
        rv = findViewById(R.id.rv);
        rdb = Room.databaseBuilder(this,Rdatabase.class,"ROOM").allowMainThreadQueries().build();
    }

    public void save(View view) {
        String n = num.getText().toString();
        String nm = name.getText().toString();

        //To insert the data
        Rtable rtable = new Rtable();
        rtable.setRollnumber(n);
        rtable.setName(nm);
        rdb.rdao().insertData(rtable);

        //To Fetch the data
        List<Rtable> list = rdb.rdao().getAll();
        MyAdapter adapter = new MyAdapter(this,list);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}