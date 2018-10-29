package com.example.anton.qutparking;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by anton on 13/02/18.
 */

public class RecyclerAdapterKG extends android.support.v7.widget.RecyclerView.Adapter<RecyclerAdapterKG.ViewHolder>{

    private static final String TAG = "RecyclerAdapterKG";

    private List<ParkingData> parkingDataList;
    private Context mContext;

    public RecyclerAdapterKG(List<ParkingData> parkingDataList, Context mContext) {
        this.parkingDataList = parkingDataList;
        this.mContext = mContext;

    }


    @Override
    public RecyclerAdapterKG.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.card_layout, null);
        return new RecyclerAdapterKG.ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return parkingDataList.size();
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapterKG.ViewHolder holder, int position) {
        final ParkingData parkingItem = parkingDataList.get(position);

        holder.carparkName.setText(parkingItem.getCarparkName());
        holder.carparkAvailable.setText(String.valueOf(parkingItem.getCarparkAvailable()));

        if(parkingItem.getCarparkAvailable() <= 10){
            holder.carparkAvailable.setTextColor(mContext.getResources().getColor(R.color.lessThen10));
        }else if(parkingItem.getCarparkAvailable() <= 50){
            holder.carparkAvailable.setTextColor(mContext.getResources().getColor(R.color.lessThen50));
        }else{
            holder.carparkAvailable.setTextColor(mContext.getResources().getColor(R.color.allTheRest));
        }




    }

    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder implements View.OnClickListener{

        TextView carparkName;
        TextView carparkAvailable;
        TextView textAvailable;
        TextView location;


        public ViewHolder(View itemView) {
            super(itemView);

            carparkName = itemView.findViewById(R.id.carparkName);
            carparkAvailable = itemView.findViewById(R.id.carparkAvailable);
            textAvailable = itemView.findViewById(R.id.textAvailable);
            location = itemView.findViewById(R.id.location);
            location.setClickable(true);
            location.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            final Intent intent;
            switch (getAdapterPosition()){
                case 0:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getKgFblockParking()));
                    mContext.startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getKgFblockParking()));
                    mContext.startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getKgFblockParking()));
                    mContext.startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getKgFblockParking()));
                    mContext.startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getKgFblockParking()));
                    mContext.startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getKgFblockParking()));
                    mContext.startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getKgSportslaneParking()));
                    mContext.startActivity(intent);
                    break;
                case 7:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getKgSportslaneParking()));
                    mContext.startActivity(intent);
                    break;
                case 8:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getKgSportslaneParking()));
                    mContext.startActivity(intent);
                    break;

                default:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getKgSportslaneParking()));
            }
            mContext.startActivity(intent);
        }
    }

}
