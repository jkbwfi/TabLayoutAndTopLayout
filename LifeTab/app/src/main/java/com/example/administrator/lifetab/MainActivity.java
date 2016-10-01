package com.example.administrator.lifetab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabClickListener {

    private TabLayout mTabLayout;
    ArrayList<TabItem> tabItems;
    private ViewPager mViewPager;
    BasePageFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        tabItems = new ArrayList<>();
        tabItems.add(new TabItem(R.drawable.selector_tab_msg, R.string.wecat, WechatFragment.class));
        tabItems.add(new TabItem(R.drawable.selector_tab_moments, R.string.contact, ContactsFragment.class));
        tabItems.add(new TabItem(R.drawable.selector_tab_profile, R.string.order, DiscoverFragment.class));
        tabItems.add(new TabItem(R.drawable.selector_tab_contact, R.string.my, ProfileFragment.class));
        mTabLayout.initData(tabItems, this);
        mTabLayout.setCurrentTab(0);

        FragAdapter fragAdapter = new FragAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(fragAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setCurrentTab(position);
                Toast.makeText(MainActivity.this,"ai"+position,Toast.LENGTH_SHORT).show();
//                actionBar.setTitle(tabs.get(position).lableResId);lableResId
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.myTab_layout);
        mViewPager =(ViewPager) findViewById(R.id.myViewPager);
    }

    @Override
    public void onTabClick(TabItem tabItem) {
      //  actionBar.setTitle(tabItem.lableResId);
        mViewPager.setCurrentItem(tabItems.indexOf(tabItem));
        Toast.makeText(MainActivity.this,"ai",Toast.LENGTH_SHORT).show();
    }

    public class FragAdapter extends FragmentPagerAdapter {

        public FragAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            try {
                return tabItems.get(position).tagFragmentClz.newInstance();

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return tabItems.size();
        }
    }
}
