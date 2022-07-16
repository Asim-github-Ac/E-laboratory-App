package com.fyp.e_laboratory.Model;

public class PdfModel {
    String uid,pdfurl;

    public PdfModel(String uid, String pdfurl) {
        this.uid = uid;
        this.pdfurl = pdfurl;
    }

    public PdfModel() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPdfurl() {
        return pdfurl;
    }

    public void setPdfurl(String pdfurl) {
        this.pdfurl = pdfurl;
    }
}
