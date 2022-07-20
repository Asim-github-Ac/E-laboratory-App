package com.fyp.e_laboratory.UserPanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.fyp.e_laboratory.Model.ApointmentModel;
import com.fyp.e_laboratory.R;
import com.fyp.e_laboratory.SharedPrefrence.PrefManager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ApointMentBook extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TimePicker timepicker;
    Button changetime,submit;
    String uid;
    String time;
    String city;
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
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

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
        List<String> categories = new ArrayList<String>();
        categories.add("Faisalabad");
        categories.add("Lahore");
        categories.add("Islamabad");
        categories.add("Karachi");
        categories.add("Peshawar");
        categories.add("Multan");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
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
                    AddApointment(names.getText().toString(),emails.getText().toString(),phones.getText().toString(),addresss.getText().toString(),time,uid,city);
                }
            }
        });
    }
    public String getCurrentTime(){
        String currentTime="Current Time: "+timepicker.getCurrentHour()+":"+timepicker.getCurrentMinute();
        return currentTime;
    }
    public void AddApointment(String name,String email,String phone,String addres,String tim,String uid,String city){

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("ELab_Apointment");
        ApointmentModel apointmentModel=new ApointmentModel(name,email,phone,addres,tim,uid,city);

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
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
         city = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + city, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}