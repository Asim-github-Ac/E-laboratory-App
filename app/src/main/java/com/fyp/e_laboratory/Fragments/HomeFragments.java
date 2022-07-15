package com.fyp.e_laboratory.Fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fyp.e_laboratory.R;
import com.fyp.e_laboratory.UserPanel.Instruction;


public class HomeFragments extends Fragment {



    CardView medi,aid,ambulance,apoinment,report;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home_fragments, container, false);

        medi=v.findViewById(R.id.medicine);
        aid=v.findViewById(R.id.aid);
        ambulance=v.findViewById(R.id.ambulance);
        apoinment=v.findViewById(R.id.apoinment);
        report=v.findViewById(R.id.report);

        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:1122"));

                if (ActivityCompat.checkSelfPermission(getContext(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });
        aid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Instruction.class));

            }
        });

        return v;
    }
}