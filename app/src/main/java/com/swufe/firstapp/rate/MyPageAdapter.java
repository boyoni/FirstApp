package com.swufe.firstapp.rate;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.swufe.firstapp.view.FirstFragment;
import com.swufe.firstapp.view.SecondFragment;
import com.swufe.firstapp.view.ThirdFragment;

public class MyPageAdapter extends FragmentPagerAdapter {

    public MyPageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new FirstFragment();
        }else if(position==1){
            return new SecondFragment();
        }else{
            return new ThirdFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
