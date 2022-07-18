package com.fyp.e_laboratory.AdminAdapters;

import static android.content.Context.DOWNLOAD_SERVICE;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fyp.e_laboratory.Model.PdfModel;
import com.fyp.e_laboratory.R;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ViewPdfAdapter extends RecyclerView.Adapter<ViewPdfAdapter.myHolder> {
    Context context;
    List<PdfModel> pdfModelList;
    URL url;
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
                downloadPdf(pdfModel.getPdfurl());

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
    private void downloadPdf(String pdfURL) {

        try {
            url = new URL(pdfURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            //  requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},READ_STORAGE_PERMISSION_REQUEST_CODE);
        }

        File direct = new File(Environment.getExternalStorageDirectory() + "/Download/AldoFiles");

        if (!direct.exists()) {
            File pdfDirectory = new File("/sdcard/Download/AldoFiles/");
            pdfDirectory.mkdirs();
        }

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url + ""));
        request.setTitle("pdf");
        request.setMimeType("application/pdf");
        request.allowScanningByMediaScanner();
        request.setAllowedOverMetered(true);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"pdf");
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);

    }
}
