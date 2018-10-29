package com.example.anton.qutparking;

import android.widget.TextView;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by anton on 9/02/18.
 */

public class ParkingData {

    private String carparkName;

    private int carparkAvailable;

    private String carparkTime;

    public ParkingData(String carparkName, int carparkAvailable, String carparkTime) {
        this.carparkName = carparkName;
        this.carparkAvailable = carparkAvailable;
        this.carparkTime = carparkTime;
    }

    public ParkingData(String carparkTime) {
        this.carparkTime = carparkTime;
    }

    public ParkingData() {
    }

    public String formattedDate(String inputDate){
        PrettyTime p = new PrettyTime(Locale.getDefault());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
        Date d = null;
        try {
            d = sdf.parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return p.format(d);
    }


    public String getCarparkName() {
        return carparkName;
    }

    public int getCarparkAvailable() {
        return carparkAvailable;
    }

    public String getCarparkTime() {
        return carparkTime;
    }

    public void setCarparkName(String carparkName) {
        this.carparkName = carparkName;
    }

    public void setCarparkAvailable(int carparkAvailable) {
        this.carparkAvailable = carparkAvailable;
    }

    public void setCarparkTime(String carparkTime) {
        this.carparkTime = carparkTime;
    }

}
