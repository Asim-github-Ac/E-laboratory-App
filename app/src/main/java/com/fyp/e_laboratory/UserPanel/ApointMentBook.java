package com.fyp.e_laboratory.UserPanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.fyp.e_laboratory.R;
import com.fyp.e_laboratory.SharedPrefrence.PrefManager;

public class ApointMentBook extends AppCompatActivity {
    TimePicker timepicker;
    Button changetime;
    String uid;
    String time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apoint_ment_book);
        PrefManager prefManager=new PrefManager(getApplicationContext());
        uid=prefManager.getUserID();

        timepicker=(TimePicker)findViewById(R.id.timePicker1);
        //Uncomment the below line of code for 24 hour view
        timepicker.setIs24HourView(true);
        changetime=(Button)findViewById(R.id.button1);

        time=getCurrentTime();
        changetime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
              time= getCurrentTime();
            }
        });

    }
    public String getCurrentTime(){
        String currentTime="Current Time: "+timepicker.getCurrentHour()+":"+timepicker.getCurrentMinute();
        return currentTime;
    }
}