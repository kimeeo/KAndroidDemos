package com.kimeeo.kAndroidDemos.recycleView.stickyRecyclerHeaders;


import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kimeeo.kAndroid.listViews.dataProvider.DataProvider;
import com.kimeeo.kAndroid.listViews.recyclerView.BaseItemHolder;
import com.kimeeo.kAndroidDemos.R;
import com.kimeeo.kAndroidDemos.services.DataBean;
import com.kimeeo.kAndroidDemos.services.aADataProvider.AQDataProvider;

/**
 * Created by bhavinpadhiyar on 1/30/16.
 */
public class VerticalGrid extends com.kimeeo.kAndroid.listViews.recyclerView.stickyRecyclerHeaders.VerticalGrid {

    @Override
    public View getStickyItemView(ViewGroup container) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        return inflater.inflate(R.layout.sample_column_header_cell, container, false);
    }

    @Override
    public BaseItemHolder getStickyItemHolder(View view) {
        return new StickyItemHolder1(view);
    }

    @Override
    public long getHeaderId(int position) {
        if (position < 5)
            return 1;
        else if (position < 10)
            return 2;
        else if (position < 20)
            return 3;
        else if (position < 25)
            return 4;
        return 5;
    }


    @Override
    public View getItemView(int i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.sample_list_view_item, viewGroup, false);
    }

    @Override
    public BaseItemHolder getItemHolder(int i, View view) {
        return new BaseItemHolder1(view);
    }

    @Override
    public int getListItemViewType(int i, Object o) {
        return 0;
    }


    @NonNull
    @Override
    protected DataProvider createDataProvider() {
        return new AQDataProvider(getActivity(), true, true);
    }

    public class BaseItemHolder1 extends BaseItemHolder {
        public BaseItemHolder1(View itemView) {
            super(itemView);
        }

        @Override
        public void updateItemView(Object o, View view, int i) {
            DataBean data = (DataBean) o;
            TextView title = (TextView) view.findViewById(R.id.title);
            title.setText(i + ". " + data.getName());
        }
    }

    public class StickyItemHolder1 extends BaseItemHolder {

        public StickyItemHolder1(View itemView) {
            super(itemView);
        }

        public void updateItemView(Object item, View view, int position) {
            DataBean data = (DataBean) item;
            TextView title = (TextView) view.findViewById(R.id.title);
            title.setText(position + ". " + data.getName());
        }
    }
}
