package com.kimeeo.kAndroidDemos.pager;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.kimeeo.kAndroid.core.fragment.BaseFragment;
import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroidDemos.recycleView.verticalViews.GridView;
import com.kimeeo.kAndroidDemos.recycleView.verticalViews.ListView;
import com.kimeeo.kAndroidDemos.services.DataBean;
import com.kimeeo.kAndroidDemos.services.aADataProvider.AQDataProvider;

/**
 * Created by BhavinPadhiyar on 22/05/16.
 */
public class HorizontalFragmentViewPager extends com.kimeeo.kAndroid.listViews.pager.fragmentPager.BaseHorizontalFragmentViewPager {


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
        return new AQDataProvider(getActivity(), true, false);
    }

    @Override
    public Fragment getItemFragment(int i, Object o) {
        Fragment view;
        if (i < 5)
            view = BaseFragment.newInstance(ListView.class);
        else
            view = BaseFragment.newInstance(GridView.class);
        return view;
    }
}
