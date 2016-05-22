package com.kimeeo.kAndroidDemos.pager;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.kimeeo.kAndroid.core.fragment.BaseFragment;
import com.kimeeo.kAndroid.listViews.dataProvider.DataProvider;
import com.kimeeo.kAndroidDemos.services.DataBean;
import com.kimeeo.kAndroidDemos.services.aADataProvider.AQDataProvider;

/**
 * Created by BhavinPadhiyar on 22/05/16.
 */
public class VerticleFragmentViewPager extends com.kimeeo.kAndroid.listViews.pager.fragmentPager.BaseVerticalFragmentViewPager {


    public String getItemTitle(int position, Object o) {
        if (o instanceof DataBean) {
            DataBean data = (DataBean) o;
            return data.getName();

        }
        return "";
    }

    /*
    protected void configViewPager(ViewPager viewPager, BaseViewPagerAdapter mAdapter, View indicator) {
        viewPager.setPageTransformer(true, new StackTransformer());
    }*/
    @NonNull
    @Override
    protected DataProvider createDataProvider() {
        return new AQDataProvider(getActivity(), false, false);
    }

    @Override
    public Fragment getItemFragment(int i, Object o) {
        Fragment view = BaseFragment.newInstance(DummyFragment.class);
        return view;
    }
}
