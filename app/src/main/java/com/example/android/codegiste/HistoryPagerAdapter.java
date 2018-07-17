package com.example.android.codegiste;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16/07/2018.
 */

public class HistoryPagerAdapter extends FragmentPagerAdapter {

    //The list that will contain the two fragments
    private final List<Fragment> listFragment = new ArrayList<>();

    //The list that will contain the titels of the two fragments
    private final List<String> listTitles = new ArrayList<>();

    /**
     * The default constructor
     * @param fm
     */
    public HistoryPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * To get the number of items
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    /**
     * To get the number of fragments
     * @return
     */
    @Override
    public int getCount() {
        return listTitles.size();
    }

    /**
     * To get the titel for each fragment
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitles.get(position);
    }


    /**
     * Custom method to add the fragment and the titels to the layout
     * @param fragment
     * @param title
     */
    public void addFragment (Fragment fragment , String title){

        //Add a fragment to the fragments list
        listFragment.add(fragment);

        //Add a titele to the titels list
        listTitles.add(title);

    }
}
