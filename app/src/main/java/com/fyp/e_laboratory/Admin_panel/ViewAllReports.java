package com.fyp.e_laboratory.Admin_panel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.fyp.e_laboratory.AdminAdapters.ViewPdfAdapter;
import com.fyp.e_laboratory.Model.PdfModel;
import com.fyp.e_laboratory.R;
import com.fyp.e_laboratory.SharedPrefrence.PrefManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewAllReports extends AppCompatActivity {

    RecyclerView recyclerView;
    private DatabaseReference mDatabase;
    List<PdfModel> pdfModelList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_reports);


        recyclerView=findViewById(R.id.allreport);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("ELabPdf");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    PdfModel pdfModel=snapshot1.getValue(PdfModel.class);
                    pdfModelList.add(pdfModel);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setAdapter(new ViewPdfAdapter(getApplicationContext(),pdfModelList));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(ViewAllReports.this, "error "+ error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}