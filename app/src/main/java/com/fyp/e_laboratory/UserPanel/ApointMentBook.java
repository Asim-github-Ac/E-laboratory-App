package com.fyp.e_laboratory.UserPanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TimePicker;
import android.widget.Toast;

import com.fyp.e_laboratory.Model.ApointmentModel;
import com.fyp.e_laboratory.R;
import com.fyp.e_laboratory.SharedPrefrence.PrefManager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ApointMentBook extends AppCompatActivity {
    TimePicker timepicker;
    Button changetime,submit;
    String uid;
    String time;
    EditText emails,names,phones,addresss;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apoint_ment_book);
        names=findViewById(R.id.ap_name);
        emails=findViewById(R.id.ap_email);
        addresss=findViewById(R.id.ap_address);
        phones=findViewById(R.id.ap_phone);
        progressBar=findViewById(R.id.ap_pbbar);
        submit=findViewById(R.id.ap_submit);
        PrefManager prefManager=new PrefManager(getApplicationContext());
        uid=prefManager.getUserID();

        timepicker=(TimePicker)findViewById(R.id.timePicker1);
        //Uncomment the below line of code for 24 hour view
        timepicker.setIs24HourView(true);
        changetime=(Button)findViewById(R.id.button1);
        System.out.println("time is "+time);
        time=getCurrentTime();
        changetime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
              time= getCurrentTime();
                System.out.println("time is "+time);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (emails.getText().toString().isEmpty() && phones.getText().toString().isEmpty() && addresss.getText().toString().isEmpty() && names.getText().toString().isEmpty()){
                    emails.setError("Complete Requirements");
                    names.setError("Complete Requirements");
                    addresss.setError("Complete Requirements");
                    phones.setError("Complete Requirements");
                    Toast.makeText(ApointMentBook.this, "Something is Empty", Toast.LENGTH_SHORT).show();
                }else {
                    progressBar.setVisibility(View.VISIBLE);
                    AddApointment(names.getText().toString(),emails.getText().toString(),phones.getText().toString(),addresss.getText().toString(),time,uid);
                }
            }
        });
    }
    public String getCurrentTime(){
        String currentTime="Current Time: "+timepicker.getCurrentHour()+":"+timepicker.getCurrentMinute();
        return currentTime;
    }
    public void AddApointment(String name,String email,String phone,String addres,String tim,String uid){

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("ELab_Apointment");
        ApointmentModel apointmentModel=new ApointmentModel(name,email,phone,addres,tim,uid);

        databaseReference.child(uid).setValue(apointmentModel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(ApointMentBook.this, "ApointMent Added", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(ApointMentBook.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}