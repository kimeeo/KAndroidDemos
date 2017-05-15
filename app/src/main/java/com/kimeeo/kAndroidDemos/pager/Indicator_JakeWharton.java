package com.kimeeo.kAndroidDemos.pager;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroid.listViews.pager.BaseItemHolder;
import com.kimeeo.kAndroid.listViews.pager.viewPager.BaseViewPagerAdapter;
import com.kimeeo.kAndroidDemos.R;
import com.kimeeo.kAndroidDemos.services.DataBean;
import com.kimeeo.kAndroidDemos.services.aADataProvider.AQDataProvider;
import com.viewpagerindicator.PageIndicator;

/**
 * Created by BhavinPadhiyar on 22/05/16.
 */
public class Indicator_JakeWharton extends com.kimeeo.kAndroid.listViews.pager.viewPager.HorizontalViewPager {


    @Override
    protected void setUpIndicator(View indicator, ViewPager viewPager, boolean isFirstTime) {
        if (isFirstTime && indicator instanceof PageIndicator) {
            PageIndicator pageIndicator = (PageIndicator) indicator;
            pageIndicator.setViewPager(viewPager);
        } else if (indicator instanceof PageIndicator) {
            PageIndicator pageIndicator = (PageIndicator) indicator;
            pageIndicator.notifyDataSetChanged();
        }
    }

    @Override
    @LayoutRes
    protected int getRootRefreshLayoutResID() {
        return R.layout._fragment_view_pager_indicator_jake_wharton;
    }

    @Override
    @LayoutRes
    protected int getRootLayoutResID() {
        return R.layout._fragment_view_pager_indicator_jake_wharton;
    }


    public String getItemTitle(int position, Object o) {
        if (o instanceof DataBean) {
            DataBean data = (DataBean) o;
            return data.getName();
        }
        return "";
    }

    protected void configViewPager(ViewPager viewPager, BaseViewPagerAdapter mAdapter, View indicator) {
        viewPager.setPageTransformer(true, new StackTransformer());
    }

    @Override
    public View getView(int i, Object o) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.sample_list_view_item, null);
        return view;
    }

    @NonNull
    @Override
    protected DataProvider createDataProvider() {
        return new AQDataProvider(getActivity(), true, true);
    }

    @Override
    public BaseItemHolder getItemHolder(View view, int i, Object o) {
        return new BaseItemHolder1(view);
    }

    public class BaseItemHolder1 extends BaseItemHolder {
        public BaseItemHolder1(View itemView) {
            super(itemView);
        }

        @Override
        public void cleanView(View view, int i) {

        }

        @Override
        public void updateItemView(Object o, View view, int i) {
            DataBean data = (DataBean) o;
            TextView title = (TextView) view.findViewById(R.id.title);
            title.setText(i + ". " + data.getName());
        }
    }
}
