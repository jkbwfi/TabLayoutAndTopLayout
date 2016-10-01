package com.example.administrator.lifetab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by yx on 16/4/3.
 */
public class ContactsFragment extends BaseFragment implements ITabClickListener, TabLayout.OnTabClickListener
        , android.support.design.widget.TabLayout.OnTabSelectedListener {
    private android.support.design.widget.TabLayout mTableLayout;
    private ViewPager mViewPager;
    private List<Fragment> tabFragments;
    private TopFragmentAdapter  contentAdapter;
    private android.support.design.widget.TabLayout.Tab oneTab;
    private android.support.design.widget.TabLayout.Tab twoTab;
    private android.support.design.widget.TabLayout.Tab threeTab;
    @Override
    public void fetchData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contacts_layout, container, false);
        mTableLayout = (android.support.design.widget.TabLayout) view.findViewById(R.id.topTabLayout);
        mViewPager = (ViewPager)view.findViewById(R.id.topTabViewPager);
        contentAdapter = new TopFragmentAdapter(getFragmentManager());
        mViewPager.setAdapter(contentAdapter);
        initData();
        return view;
    }

    private void initData() {
        mTableLayout.addTab(mTableLayout.newTab().setText("Tab1"));
        mTableLayout.addTab(mTableLayout.newTab().setText("tab2"));
        mTableLayout.addTab(mTableLayout.newTab().setText("Tab3"));
        mTableLayout.addOnTabSelectedListener(this);
        mTableLayout.setupWithViewPager(mViewPager);
        //指定Tab的位置
//        oneTab = mTableLayout.getTabAt(0);
//        twoTab = mTableLayout.getTabAt(1);
//        threeTab = mTableLayout.getTabAt(2);
    }


    @Override
    public void onMenuItemClick() {

    }

    @Override
    public BaseFragment getFragment()
    {
        return this;
    }

    @Override
    public void onTabClick(TabItem tabItem) {

    }

    @Override
    public void onTabSelected(android.support.design.widget.TabLayout.Tab tab) {
        //选中了tab的逻辑
        Log.d("ace","1");
    }

    @Override
    public void onTabUnselected(android.support.design.widget.TabLayout.Tab tab) {
        //未选中了tab的逻辑
        Log.d("ace","2");
    }

    @Override
    public void onTabReselected(android.support.design.widget.TabLayout.Tab tab) {
        //再次选中tab的逻辑
        Log.d("ace","3");
    }

}
