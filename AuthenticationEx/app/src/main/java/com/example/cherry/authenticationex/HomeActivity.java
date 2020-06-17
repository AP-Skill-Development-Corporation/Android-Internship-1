package com.example.cherry.authenticationex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        auth = FirebaseAuth.getInstance();
        Toast.makeText(this, ""+auth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();

    }

    public void signout(View view) {
        auth.signOut();
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}