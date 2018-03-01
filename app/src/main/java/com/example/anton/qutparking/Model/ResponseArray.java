package com.example.anton.qutparking.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anton on 9/02/18.
 */

public class ResponseArray {

    @SerializedName("counts")
    @Expose
    private Counts carparkData;

    @SerializedName("name")
    @Expose
    private String carparkName;

    public Counts getCarparkData() {
        return carparkData;
    }

    public String getCarparkName() {
        return carparkName;
    }

    public void setCarparkData(Counts carparkData) {
        this.carparkData = carparkData;
    }

    public void setCarparkName(String carparkName) {
        this.carparkName = carparkName;
    }
}
