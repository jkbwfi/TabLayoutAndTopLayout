package com.example.administrator.lifetab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/9/23.
 */
public class TabView extends LinearLayout implements View.OnClickListener {

    private ImageView mTabImage;
    private TextView mTablable;
    public TabView(Context context) {
        super(context);
        initView(context);
    }

    public TabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public TabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        LayoutInflater.from(context).inflate(R.layout.tabview,this,true);
        mTabImage = (ImageView) findViewById(R.id.tab_image);
        mTablable = (TextView)findViewById(R.id.tab_text);
    }
    public void initData(TabItem tabItem){
        mTabImage.setImageResource(tabItem.imageResId);
        mTablable.setText(tabItem.lableResId);
    }

    @Override
    public void onClick(View v) {

    }
    public void onDataChanged(int badgeCount) {
        //  TODO notify new message, change the badgeView
    }
}
