package com.example.exampleintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name,link;//Declared the views

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name); //Intialised the view for id name
        link = findViewById(R.id.link);//Intialised the view for id link
    }

    public void send(View view) {//Explicit Intent : navigation in between the app
        String n = name.getText().toString(); // To read the data in the edittext with object name.
        Intent i = new Intent(this,SecondActivity.class);//Syntax for intent(presentscreen , nextscreen)
        i.putExtra("key",n);//Used to carry data from one screen to other by using the key
        startActivity(i);//To start the activity
    }

    public void search(View view) {//Implicit Intent : navigation between two applications
        String l = link.getText().toString();//To read the data in the edittext with object link
        Uri uri = Uri.parse("https://"+l);//To indicate that the given data is of link type
        Intent i = new Intent(Intent.ACTION_VIEW,uri);//To open the data in a webview(browser)
        startActivity(i);//To start the activity


    }
}