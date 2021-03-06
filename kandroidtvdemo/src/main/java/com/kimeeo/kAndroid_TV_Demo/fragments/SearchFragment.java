/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.kimeeo.kAndroid_TV_Demo.fragments;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v17.leanback.app.BackgroundManager;
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
import com.kimeeo.kAndroidTV.searchFragment.AbstractSearchFragment;
import com.kimeeo.kAndroid_TV_Demo.R;
import com.kimeeo.kAndroid_TV_Demo.YoutubeActivity;
import com.kimeeo.kAndroid_TV_Demo.dataProviders.HeaderDataProvider;
import com.kimeeo.kAndroid_TV_Demo.presenter.Row1PresenterSelector;
import com.kimeeo.kAndroid_TV_Demo.presenter.Row2PresenterSelector;

public class SearchFragment extends AbstractSearchFragment {

    @NonNull
    @Override
    protected DataProvider createDataProvider() {
        return new HeaderDataProvider();
    }

    @Override
    public boolean supportBackgroundChange() {
        return true;
    }

    @Override
    public void updateBackground(BackgroundManager mBackgroundManager, Object item, int width, int height) {
        mBackgroundManager.setDrawable(getResources().getDrawable(R.drawable.background_canyon));
    }


    public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
        Intent intent = new Intent(getActivity(), YoutubeActivity.class);
        getActivity().startActivity(intent);
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

    protected String getEmptySearchMessage() {
        return "NO Data";
    }

    protected PresenterSelector createListRowPresenterSelector() {
        return new SearchFragment.ShadowRowPresenterSelector();
    }

    public static class ShodowListRow extends ListRow {
        public ShodowListRow(HeaderItem header, ObjectAdapter adapter) {
            super(header, adapter);

        }
    }

    public class ShadowRowPresenterSelector extends PresenterSelector {

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
