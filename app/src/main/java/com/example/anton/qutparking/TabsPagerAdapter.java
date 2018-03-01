package com.example.anton.qutparking;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.anton.qutparking.Controller.GardensPoint;
import com.example.anton.qutparking.Controller.KelvinGrove;

/**
 * Created by anton on 10/02/18.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    String tabTitles[] = new String[]{"Gardens Point", "Kelvin Grove"};
    Context mContext;


    public TabsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new GardensPoint();
            case 1:
                return new KelvinGrove();
        }

        return null;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
