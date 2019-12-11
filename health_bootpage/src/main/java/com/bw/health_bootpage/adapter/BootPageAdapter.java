package com.bw.health_bootpage.adapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class BootPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fraglist;
    public BootPageAdapter(@NonNull FragmentManager fm, List<Fragment> fraglist) {
        super(fm);
        this.fraglist = fraglist;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fraglist.get(position);
    }

    @Override
    public int getCount() {
        return fraglist.size();
    }
}
