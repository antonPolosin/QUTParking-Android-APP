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
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anton on 9/02/18.
 */

public class GardensPoint extends android.support.v4.app.Fragment{

    private static final String TAG = "GardensPoint";

    private static final String BASE_URL = "https://paseweb.parkassist.com/";

    private static final String JSON_URL = "https://paseweb.parkassist.com/sites/qut/status/v2/zones.json";

    private android.support.v7.widget.RecyclerView recyclerView;
    private android.support.v7.widget.RecyclerView.Adapter adapter;
    ArrayList<ParkingData> parkingDataList = new ArrayList<>();
    int sumParking = 0;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView mTextView;
    private TextView mBestCarpark;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mTextView = rootView.findViewById(R.id.carparks_number);
        mBestCarpark = rootView.findViewById(R.id.text_best_carpark);

        init();
        return rootView;

    }



    private void init(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ParkingAPI response = retrofit.create(ParkingAPI.class);

        Call<JsonResponse> call = response.getData(JSON_URL);

        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                Log.d(TAG, "onResponse: Server Respnse: " + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());
                HashMap<Integer, String> bestCarpark = new HashMap<>();
                ArrayList<ResponseArray> responseList = response.body().getCarparkResponse();
                /**
                 * inserting values into hashmap
                 */
                for(int i = 0; i < responseList.size(); i++){
                    bestCarpark.put(responseList.get(i).getCarparkData().getAvailable(), responseList.get(i).getCarparkName());
                }
                /**
                 * setting first element in the hashmap
                 */
                Map.Entry<Integer, String> firstEntry = bestCarpark.entrySet().iterator().next();
                int largestKey = firstEntry.getKey();
                String largestKeyValue = firstEntry.getValue();
                /**
                 * processing hashmap and getting largest value
                 */
                for(Map.Entry<Integer, String> entry : bestCarpark.entrySet()){
                    int key = entry.getKey();
                    if(key > largestKey){
                        largestKey = key;
                        largestKeyValue = entry.getValue();
                    }
                }

                mBestCarpark.setText(largestKeyValue);


                for(int i = 0; i < responseList.size(); i++){
                    parkingDataList.add(new ParkingData(
                            responseList.get(i).getCarparkName(),
                            responseList.get(i).getCarparkData().getAvailable(),
                            responseList.get(i).getCarparkData().getTimestamp()
                            ));

                }

                for(int i = 0; i< responseList.size(); i++){

                    sumParking += responseList.get(i).getCarparkData().getAvailable();

                }

                adapter = new RecyclerAdapterGP(parkingDataList, getActivity());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                mTextView.setText(String.valueOf(sumParking));
                if(sumParking <= 30){
                    mTextView.setTextColor(getActivity().getResources().getColor(R.color.lessThen10));
                }else if(sumParking <= 100){
                    mTextView.setTextColor(getActivity().getResources().getColor(R.color.lessThen50));
                }else{
                    mTextView.setTextColor(getActivity().getResources().getColor(R.color.allTheRest));
                }

                }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went horribly wrong: ", t);

            }
        });

    }
}


