package com.example.anton.qutparking.Controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anton.qutparking.Model.JsonResponse;
import com.example.anton.qutparking.Model.ResponseArray;
import com.example.anton.qutparking.ParkingAPI;
import com.example.anton.qutparking.ParkingData;
import com.example.anton.qutparking.R;
import com.example.anton.qutparking.RecyclerAdapterGP;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anton on 9/02/18.
 */

public class GardensPoint extends android.support.v4.app.Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private static final String TAG = "GardensPoint";

    private static final String BASE_URL = "https://paseweb.parkassist.com/";

    private static final String JSON_URL = "https://paseweb.parkassist.com/sites/qut/status/v2/zones.json";

    private android.support.v7.widget.RecyclerView recyclerView;
    private android.support.v7.widget.RecyclerView.Adapter adapter;
    ArrayList<ParkingData> parkingDataList = new ArrayList<>();


    private TextView mTextView;

    private SwipeRefreshLayout mSwipeRefreshLayout;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);

        recyclerView = (android.support.v7.widget.RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSwipeRefreshLayout = rootView.findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        init();
        return rootView;

    }



    private void init(){

        mSwipeRefreshLayout.setRefreshing(true);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //converter XML
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ParkingAPI response = retrofit.create(ParkingAPI.class);

        Call<JsonResponse> call = response.getData(JSON_URL);

        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                Log.d(TAG, "onResponse: Server Respnse: " + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());

                ArrayList<ResponseArray> responseList = response.body().getCarparkResponse();


                for(int i = 0; i < responseList.size(); i++){
                    parkingDataList.add(new ParkingData(
                            responseList.get(i).getCarparkName(),
                            responseList.get(i).getCarparkData().getAvailable(),
                            responseList.get(i).getCarparkData().getTimestamp()
                            ));

                }

//                String timeUpdated = responseList.get(0).getCarparkData().getTimestamp();
//                mTextView.setText(parkingDataTime.formattedDate(timeUpdated));
                adapter = new RecyclerAdapterGP(parkingDataList, getActivity());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                mSwipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went horribly wrong: ", t);

            }
        });

    }


    @Override
    public void onRefresh() {
        parkingDataList.clear();
        init();
    }
}


