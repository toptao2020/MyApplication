package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class FaceBin {
    @SerializedName("to")
    private String mTo;

    @SerializedName("from")
    private String mFrom;

    public String getTo() {
        return mTo;
    }

    public String getFrom() {
        return mFrom;
    }

    public void setTo(String to) {
        this.mTo = to;
    }

    public void setFrom(String from) {
        this.mFrom = from;
    }
}
