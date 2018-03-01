package com.example.anton.qutparking;

import com.example.anton.qutparking.Model.JsonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by anton on 8/02/18.
 */

public interface ParkingAPI {


//    @Headers("Content-Type: application/json")
    @GET
    Call<JsonResponse> getData(@Url String url);

}
