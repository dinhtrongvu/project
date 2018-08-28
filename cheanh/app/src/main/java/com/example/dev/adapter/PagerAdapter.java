package com.example.dev.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.dev.fragment.Animals;
import com.example.dev.fragment.Cartoon;
import com.example.dev.fragment.Humans;
import com.example.dev.fragment.Rage;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position) {
            case 0:
                frag = new Humans();
                break;
            case 1:
                frag = new Animals();
                break;
            case 2:
                frag = new Cartoon();
                break;
            case 3:
                frag = new Rage();
                break;
        }

        return frag;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0:
                title="HUMANS";
                break;
            case 1:
                title="ANIMALS";
                break;
            case 2:
                title="CARTOON";
                break;
            case 3:
                title="RAGE";
                break;
        }
        return title;
    }
}
