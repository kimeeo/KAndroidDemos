package com.kimeeo.kAndroidDemos.bindingDemo;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroid.listViews.listView.BaseItemHolder;
import com.kimeeo.kAndroidDemos.BR;
import com.kimeeo.kAndroidDemos.R;
import com.kimeeo.kAndroidDemos.bindingDemo.core.ListViewBindingItemHolder;
import com.kimeeo.kAndroidDemos.services.aADataProvider.AQDataProvider;

/**
 * Created by BhavinPadhiyar on 24/05/16.
 */
public class ListView extends com.kimeeo.kAndroid.listViews.listView.verticalViews.ListView {
    @Override
    public View getItemView(int viewType, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.sample_list_binding_view_item, viewGroup, false);
    }

    @Override
    public BaseItemHolder getItemHolder(int viewType, View view) {
        return new BaseItemHolder1(view, BR.data);
    }

    @Override
    public int getTotalViewTypeCount() {
        return 2;
    }

    @Override
    public int getListItemViewType(int position, Object o) {
        if (position < 4)
            return 1;
        else
            return 2;
    }

    @NonNull
    @Override
    protected DataProvider createDataProvider() {
        return new AQDataProvider(getActivity(), true, true);
    }

    public class BaseItemHolder1<SampleListBindingViewItemBinding> extends ListViewBindingItemHolder {
        public BaseItemHolder1(View itemView, int variableID) {
            super(itemView, variableID);
        }
    }
}
