package com.example.pokemonjavatraining;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> FragmentList = new ArrayList<>();
    private final List<String> List = new ArrayList<>();


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return FragmentList.get(position);
    }
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
    @Override
    public int getCount() {
        if(List == null)
            return 0;
        return List.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {

        return List.get(position);
    }
    public void AddFragment (Fragment fragment,String title){
        FragmentList.add(fragment);
        List.add(title);
    }
}
