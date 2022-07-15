package com.fyp.e_laboratory.AdminAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fyp.e_laboratory.Model.ApointmentModel;
import com.fyp.e_laboratory.R;

import java.util.List;

public class ViewApointAdapters extends RecyclerView.Adapter<ViewApointAdapters.myHoder> {
    Context context;
    List<ApointmentModel> apointmentModelList;

    public ViewApointAdapters(Context context, List<ApointmentModel> apointmentModelList) {
        this.context = context;
        this.apointmentModelList = apointmentModelList;
    }

    @NonNull
    @Override
    public ViewApointAdapters.myHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.apoint_items,parent,false);
        return new myHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewApointAdapters.myHoder holder, int position) {
        ApointmentModel apointmentModel=apointmentModelList.get(position);
        holder.tvname.setText(apointmentModel.getName());
        holder.tvaddress.setText(apointmentModel.getAddress());
        holder.tvtime.setText(apointmentModel.getPhone());
        holder.tvphone.setText(apointmentModel.getPhone());
        holder.btndelivry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Not Yet Implemente", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return apointmentModelList.size();
    }

    public class myHoder extends RecyclerView.ViewHolder {
        TextView tvname,tvphone,tvaddress,tvtime;
        Button btndelivry;

        public myHoder(@NonNull View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.patients_name);
            tvaddress=itemView.findViewById(R.id.patiensAddress);
            tvphone=itemView.findViewById(R.id.patientsphone);
            tvtime=itemView.findViewById(R.id.patientstime);
            btndelivry=itemView.findViewById(R.id.medi_delivry_items);


        }
    }
}
