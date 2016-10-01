package com.example.administrator.lifetab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/23.
 */
public class TabLayout extends LinearLayout implements View.OnClickListener {

    private ArrayList<TabItem> tabItems;
    private OnTabClickListener listener;
    private View selectView;
    private int tabCount;
    public TabLayout(Context context) {
        super(context);
        initView();
    }

    public TabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public TabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        setOrientation(HORIZONTAL);
    }
    public void setCurrentTab(int i) {
        if (i < tabCount && i >= 0) {
            View view = getChildAt(i);
            if (selectView != view) {
                view.setSelected(true);
                if (selectView != null) {
                    selectView.setSelected(false);
                }
                selectView = view;
            }
        }
    }
    public void onDataChanged(int i, int badgeCount) {
        if (i < tabCount && i >= 0) {
            TabView view = (TabView) getChildAt(i);
            view.onDataChanged(badgeCount);
        }
    }
    public void initData(ArrayList<TabItem> tabs,OnTabClickListener listener){
        this.tabItems = tabs;
        this.listener = listener;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        if (tabItems!=null&&tabItems.size()>0){
            tabCount=tabs.size();
            TabView tabView = null;
            for (int i = 0; i <tabItems.size() ; i++) {
                tabView = new TabView(getContext());
                tabView.setTag(tabItems.get(i));
                tabView.initData(tabItems.get(i));
                tabView.setOnClickListener(this);
                addView(tabView,params);

            }
        }else{
            throw new IllegalArgumentException("tabs can not be empty");
        }
    }
    @Override
    public void onClick(View v) {
        listener.onTabClick((TabItem) v.getTag());

    }
    public interface OnTabClickListener{
        void onTabClick(TabItem tabItem);
    }
}
