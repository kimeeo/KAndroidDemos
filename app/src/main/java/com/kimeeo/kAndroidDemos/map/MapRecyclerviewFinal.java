package com.kimeeo.kAndroidDemos.map;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroid.dataProvider.StaticDataProvider;
import com.kimeeo.kAndroid.listViews.recyclerView.BaseRecyclerView;
import com.kimeeo.kAndroidDemos.R;
import com.kimeeo.kAndroidDemos.map.mapSyncWithList.AbstractHorizontalRecyclerview;
import com.kimeeo.kAndroidDemos.map.mapSyncWithList.AbstractMapRecyclerView;
import com.kimeeo.kAndroidDemos.map.mapSyncWithList.AbstractMapView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpa001 on 6/17/17.
 */

public class MapRecyclerviewFinal extends AbstractMapRecyclerView {
    @Override
    protected BaseRecyclerView createRecyclerView() {
        return new ListView();
    }
    @Override
    protected AbstractMapView createMapView() {
        return new MapView();
    }
    @NonNull
    @Override
    protected DataProvider createDataProvider() {
        return new MapDataProvider();
    }
    public static class MapView extends AbstractMapView{}
    public static class ListView extends AbstractHorizontalRecyclerview{
        @Override
        public View getItemView(int viewType, LayoutInflater layoutInflater, ViewGroup viewGroup) {
            return layoutInflater.inflate(R.layout.sample_list_view_item,viewGroup,false);
        }
        @Override
        public com.kimeeo.kAndroid.listViews.recyclerView.BaseItemHolder getItemHolder(int viewType, View view) {
            return new BaseItemHolder1(view);
        }

        public class BaseItemHolder1 extends com.kimeeo.kAndroid.listViews.recyclerView.BaseItemHolder
        {
            public BaseItemHolder1(View itemView) {
                super(itemView);
            }
            @Override
            public void updateItemView(Object o, View view, int i) {
                SamplePOIModel data = (SamplePOIModel) o;
                TextView title = (TextView) view.findViewById(R.id.title);
                title.setText(i +". "+data.name);
            }
        }
    }

}
