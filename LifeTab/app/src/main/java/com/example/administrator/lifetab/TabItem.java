package com.example.administrator.lifetab;

/**
 * Created by Administrator on 2016/9/23.
 */
public class TabItem {
    /**
     * icon
     */
    public int imageResId;
    /**
     * 文本
     */
    public int lableResId;

    public Class<? extends BaseFragment>tagFragmentClz;

    public TabItem(int imageResId, int lableResId, Class<? extends BaseFragment> tagFragmentClz) {
        this.imageResId = imageResId;
        this.lableResId = lableResId;
        this.tagFragmentClz = tagFragmentClz;
    }
}
