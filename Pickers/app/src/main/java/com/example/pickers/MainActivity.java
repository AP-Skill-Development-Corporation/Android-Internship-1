package com.example.pickers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    int c_year,c_month,c_day;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);
    }

    public void getalert(View view)
    {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setTitle("alert");
        b.setMessage("do you want close the app");
        b.setIcon(R.drawable.alert);
       b.setPositiveButton("yes", new DialogInterface.OnClickListener()
       {@Override
           public void onClick(DialogInterface dialogInterface, int i)
           { finish(); }
       });
       b.setNegativeButton("no", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
               dialogInterface.cancel(); }
       });


     b.show();

    }

    public void getdate(View view)
    {

        Calendar c=Calendar.getInstance();
        c_year=c.get(Calendar.YEAR);
        c_month=c.get(Calendar.MONTH);
        c_day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dp=new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {


                       tv.setText(""+i+"-"+(i1+1)+"-"+i2);
                    }
                },c_year,c_month,c_day);

        dp.show();

    }

}
