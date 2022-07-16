package com.fyp.e_laboratory.AdminAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fyp.e_laboratory.Model.PdfModel;
import com.fyp.e_laboratory.R;

import java.util.List;

public class ViewPdfAdapter extends RecyclerView.Adapter<ViewPdfAdapter.myHolder> {
    Context context;
    List<PdfModel> pdfModelList;

    public ViewPdfAdapter(Context context, List<PdfModel> pdfModelList) {
        this.context = context;
        this.pdfModelList = pdfModelList;
    }

    @NonNull
    @Override
    public ViewPdfAdapter.myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pdf_all_reports,parent,false);
        return new ViewPdfAdapter.myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPdfAdapter.myHolder holder, int position) {

        PdfModel pdfModel=pdfModelList.get(position);
        holder.tvname.setText(pdfModel.getPname());
        holder.tvphone.setText(pdfModel.getNumber());
        System.out.println("data__________"+pdfModel.getNumber());
        holder.dow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return pdfModelList.size();
    }

    public class myHolder extends RecyclerView.ViewHolder {
        TextView tvname,tvphone;
        Button dow;
        public myHolder(@NonNull View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.pname);
            tvphone=itemView.findViewById(R.id.pnumbers);
            dow=itemView.findViewById(R.id.downpdf);

        }
    }
}
