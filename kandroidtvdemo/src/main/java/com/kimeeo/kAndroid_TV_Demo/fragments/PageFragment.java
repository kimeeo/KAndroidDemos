package com.kimeeo.kAndroid_TV_Demo.fragments;

import android.app.Fragment;
import android.support.v17.leanback.app.BrowseFragment;

import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroidTV.pageFragments.AbstractPageFragment;
import com.kimeeo.kAndroidTV.pageFragments.PageRow;
import com.kimeeo.kAndroid_TV_Demo.dataProviders.HeaderDataProvider;

/**
 * Created by BhavinPadhiyar on 5/18/17.
 */

public class PageFragment extends AbstractPageFragment {

    protected DataProvider createDataProvider() {

        return new HeaderDataProvider();
    }

    @Override
    public Fragment getFragmentForItem(Object rowObj) {
        if (rowObj instanceof PageRow) {
            PageRow page = (PageRow) rowObj;
            if ((page.getHeaderData()).getID().equals("1")) {
                return new MyVerticalGridFragment();
            }
        }
        return new MyRowsFragment();
    }

    public static class MyVerticalGridFragment extends VerticalGridFragment implements BrowseFragment.MainFragmentAdapterProvider {
        private BrowseFragment.MainFragmentAdapter mMainFragmentAdapter = new BrowseFragment.MainFragmentAdapter(this);

        @Override
        public BrowseFragment.MainFragmentAdapter getMainFragmentAdapter() {
            return mMainFragmentAdapter;
        }
    }

    public static class MyRowsFragment extends RowsFragment implements BrowseFragment.MainFragmentAdapterProvider {
        private android.support.v17.leanback.app.RowsFragment.MainFragmentAdapter mMainFragmentAdapter = new android.support.v17.leanback.app.RowsFragment.MainFragmentAdapter(this);

        @Override
        public android.support.v17.leanback.app.RowsFragment.MainFragmentAdapter getMainFragmentAdapter() {
            return mMainFragmentAdapter;
        }
    }


}