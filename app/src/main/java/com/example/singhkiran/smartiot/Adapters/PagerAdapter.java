package com.example.singhkiran.smartiot.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.singhkiran.smartiot.*;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int NoofTab;

    public PagerAdapter(FragmentManager fm, int Numberoftabs) {
        super(fm);
        this.NoofTab = Numberoftabs;
    }

    @Override
    public Fragment getItem(int postistion) {
        switch (postistion) {
            case 0:
                 tab1 = new Logs();
                return tab1;
            default:
                return null;



        }
    }

    @Override
    public int getCount() {
        return NoofTab;
    }
}
