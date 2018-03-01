package com.example.anton.qutparking;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by anton on 9/02/18.
 */

public class RecyclerAdapterGP extends android.support.v7.widget.RecyclerView.Adapter<RecyclerAdapterGP.ViewHolder>{

private static final String TAG = "RecyclerAdapterGP";

private List<ParkingData> parkingDataList;
private Context mContext;
//Setting library for the time elapsed after news were published

public RecyclerAdapterGP(List<ParkingData> parkingDataList, Context mContext) {
        this.parkingDataList = parkingDataList;
        this.mContext = mContext;

        }


@Override
public RecyclerAdapterGP.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext)
        .inflate(R.layout.card_layout, null);
        return new ViewHolder(v);
        }

@Override
public int getItemCount() {
        return parkingDataList.size();
        }

@Override
public void onBindViewHolder(final RecyclerAdapterGP.ViewHolder holder, int position) {
        final ParkingData parkingItem = parkingDataList.get(position);

//        int carparkAvailable = Integer.parseInt(parkingItem.getCarparkAvailable());
        holder.carparkName.setText(parkingItem.getCarparkName());
        holder.carparkAvailable.setText(String.valueOf(parkingItem.getCarparkAvailable()));

//        changing color according to carpark availability
        if(parkingItem.getCarparkAvailable() <= 10){
            holder.carparkAvailable.setTextColor(mContext.getResources().getColor(R.color.lessThen10));
        }else if(parkingItem.getCarparkAvailable() <= 50){
            holder.carparkAvailable.setTextColor(mContext.getResources().getColor(R.color.lessThen50));
        }else{
            holder.carparkAvailable.setTextColor(mContext.getResources().getColor(R.color.allTheRest));
        }


}
    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder implements View.OnClickListener{

    TextView updated;
    TextView carparkName;
    TextView carparkAvailable;
    TextView textAvailable;
    TextView location;


    public ViewHolder(View itemView) {
        super(itemView);

        carparkName = (TextView) itemView.findViewById(R.id.carparkName);
        carparkAvailable = (TextView) itemView.findViewById(R.id.carparkAvailable);
        textAvailable = (TextView) itemView.findViewById(R.id.textAvailable);
        location = itemView.findViewById(R.id.location);
        itemView.setClickable(true);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final Intent intent;
            switch (getAdapterPosition()){
                case 0:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getpBlockParking()));
                    mContext.startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getpBlockParking()));
                    mContext.startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getpBlockParking()));
                    mContext.startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getpBlockParking()));
                    mContext.startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getsZCBlockParking()));
                    mContext.startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getsZCBlockParking()));
                    mContext.startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getsZCBlockParking()));
                    mContext.startActivity(intent);
                    break;
                case 7:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getsZCBlockParking()));
                    mContext.startActivity(intent);
                    break;
                case 8:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getsZCBlockParking()));
                    mContext.startActivity(intent);
                    break;
                case 9:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getsZCBlockParking()));
                    mContext.startActivity(intent);
                    break;
                case 10:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getFreewayBlockParking()));
                    mContext.startActivity(intent);
                    break;


                    default:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MapsUtils.getFreewayBlockParking()));
            }
            mContext.startActivity(intent);
    }
}

}
