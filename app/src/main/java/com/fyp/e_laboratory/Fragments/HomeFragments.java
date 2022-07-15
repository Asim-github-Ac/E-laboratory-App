package com.fyp.e_laboratory.Fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fyp.e_laboratory.R;


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


        return v;
    }
}