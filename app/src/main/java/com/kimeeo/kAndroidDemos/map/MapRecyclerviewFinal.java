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
        DataProvider dataProvider = new StaticDataProvider(){
            private int pageCount = 1;
            public int pageSize = 10;
            public int nextPageTotal = 10;
            public int count = 0;
            Handler h = new Handler();
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    List list = new ArrayList();
                    for (int i = 0; i < pageSize; i++) {
                        list.add(getSample("B1", "534534",23.012916023+count,72.524510072+count));
                        count++;
                    }
                    addData(list);
                }
            };
            @Override
            protected void invokeLoadNext() {
                if (pageCount != nextPageTotal) {
                    h.postDelayed(r, 5000);
                    pageCount += 1;
                } else {
                    setCanLoadNext(false);
                    dataLoadError(null);
                }
            }
            @Override
            protected void invokeLoadRefresh() {}
        };
        /*
        dataProvider.add(getSample("B1", "534534",23.012916023,72.524510072));
        dataProvider.add(getSample("B1", "534534", 24.012916023, 72.524510072));
        dataProvider.add(getSample("B2", "534534", 25.012916023, 73.524510072));
        dataProvider.add(getSample("B1", "534534",24.012916023,74.334510072));
        dataProvider.add(getSample("B1", "534534", 21.012916023, 72.524510072));
        dataProvider.add(getSample("B2", "534534", 20.012916023, 74.524510072));
        */
        dataProvider.setCanLoadNext(true);
        dataProvider.setPagingEnabled(true);
        return dataProvider;
    }
    private SamplePOIModel getSample(String name, String phone,Double latitude,Double longitude) {
        SamplePOIModel o = new SamplePOIModel();
        o.name =name;
        o.details = phone;
        o.latitude=latitude;
        o.longitude=longitude;
        return o;
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
