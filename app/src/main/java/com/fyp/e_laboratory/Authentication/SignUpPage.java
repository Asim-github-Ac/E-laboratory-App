package com.fyp.e_laboratory.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fyp.e_laboratory.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpPage extends AppCompatActivity {
    private EditText mDisplayName, mEmail, mPassword, mCity, mPhone;
    private Button mCreateBtn;
    ProgressDialog progressDialog;
    private ProgressDialog mRegProgress;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        mRegProgress = new ProgressDialog(this);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        mAuth = FirebaseAuth.getInstance();

        mRegProgress = new ProgressDialog(this);
        mDisplayName = (EditText) findViewById(R.id.reg_name);
        mEmail = (EditText) findViewById(R.id.reg_email);
        mPassword = (EditText) findViewById(R.id.reg_pass);
        mCity = (EditText) findViewById(R.id.reg_city);
        mPhone = findViewById(R.id.reg_phone);
        mCreateBtn = (Button) findViewById(R.id.register);

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }
}