package com.kimeeo.kAndroidDemos.oldListView;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroid.listViewExt.flipView.VerticalFlipView;
import com.kimeeo.kAndroid.listViews.listView.BaseItemHolder;
import com.kimeeo.kAndroidDemos.R;

/**
 * Created by BhavinPadhiyar on 24/05/16.
 */
public class VFlipView extends VerticalFlipView {
    @Override
    public View getItemView(int viewType, LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.sample_list_view_item_card_view, container, false);
    }

    @Override
    public BaseItemHolder getItemHolder(int viewType, View view) {
        return new ListItemHolder(view);
    }

    @NonNull
    @Override
    protected DataProvider createDataProvider() {
        return new StaticDataProvider1(true, true, 6);
    }
}
