package com.example.administrator.lifetab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2016/9/24.
 */
public class TopFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"已选","寒冰","郭嘉"};
    public TopFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new WechatFragment();
        } else if (position == 2) {
            return new ProfileFragment();
        }
        return new DiscoverFragment();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }
    //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
