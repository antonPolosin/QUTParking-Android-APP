package com.example.anton.qutparking.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by anton on 8/02/18.
 */

public class JsonResponse {

    @SerializedName("response")
    @Expose
    private ArrayList<ResponseArray> carparkResponse;

    public ArrayList<ResponseArray> getCarparkResponse() {
        return carparkResponse;
    }

    public void setCarparkResponse(ArrayList<ResponseArray> carparkResponse) {
        this.carparkResponse = carparkResponse;
    }
}
