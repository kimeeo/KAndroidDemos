package com.kimeeo.kAndroid_TV_Demo.fragments;

import android.support.annotation.NonNull;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.ObjectAdapter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;

import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroidTV.core.IHeaderItem;
import com.kimeeo.kAndroidTV.rowsFragment.AbstractRowsFragment;
import com.kimeeo.kAndroid_TV_Demo.dataProviders.HeaderDataProvider;
import com.kimeeo.kAndroid_TV_Demo.presenter.Row1PresenterSelector;
import com.kimeeo.kAndroid_TV_Demo.presenter.Row2PresenterSelector;

/**
 * Created by BhavinPadhiyar on 5/19/17.
 */

public class RowsFragment extends AbstractRowsFragment {


    /*
    protected RowHeaderPresenter createRowHeaderPresenter() {
        return new IconHeaderPresenter();
    }
    protected  HeaderItem getHeaderItem(int i,IHeaderItem headerItem, String name)
    {
        return new IconHeaderItem(i,name, R.drawable.ic_android_black_24dp);
    }*/


    @NonNull
    @Override
    public DataProvider createDataProvider() {
        return new HeaderDataProvider();
    }

    public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
    }

    @Override
    public PresenterSelector getRowItemPresenterSelector(IHeaderItem headerItem) {
        if (headerItem.getID().equals("0"))
            return new Row1PresenterSelector();
        return new Row2PresenterSelector();
    }

    public Row getListRow(IHeaderItem headerItem, HeaderItem header, ArrayObjectAdapter listRowAdapter) {
        return new ListRow(header, listRowAdapter);
    }

    public PresenterSelector createMainRowPresenterSelector() {
        return new BrowseFragment.ShadowRowPresenterSelector();
    }

    public static class ShodowListRow extends ListRow {
        public ShodowListRow(HeaderItem header, ObjectAdapter adapter) {
            super(header, adapter);

        }
    }

    public static class ShadowRowPresenterSelector extends PresenterSelector {

        private ListRowPresenter mShadowEnabledRowPresenter = new ListRowPresenter();
        private ListRowPresenter mShadowDisabledRowPresenter = new ListRowPresenter();

        public ShadowRowPresenterSelector() {
            mShadowEnabledRowPresenter.setNumRows(1);
            mShadowDisabledRowPresenter.setShadowEnabled(false);
        }

        @Override
        public Presenter getPresenter(Object item) {
            if (item instanceof BrowseFragment.ShodowListRow)
                return mShadowDisabledRowPresenter;
            else
                return mShadowEnabledRowPresenter;
        }

        @Override
        public Presenter[] getPresenters() {
            return new Presenter[]{
                    mShadowDisabledRowPresenter,
                    mShadowEnabledRowPresenter
            };
        }
    }
}

