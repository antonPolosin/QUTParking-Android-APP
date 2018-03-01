package com.example.anton.qutparking.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anton on 8/02/18.
 */

public class Counts {

    @SerializedName("available")
    @Expose
    private int available;

    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    public int getAvailable() {
        return available;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Counts{" +
                "available='" + available + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
