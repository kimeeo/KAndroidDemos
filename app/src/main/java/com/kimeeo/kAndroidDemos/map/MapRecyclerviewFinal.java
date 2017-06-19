package com.kimeeo.kAndroidDemos.map;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroid.dataProvider.StaticDataProvider;
import com.kimeeo.kAndroid.listViews.BaseListDataView;
import com.kimeeo.kAndroid.listViews.pager.BaseItemHolder;
import com.kimeeo.kAndroid.listViews.pager.BaseViewPager;
import com.kimeeo.kAndroid.listViews.pager.viewPager.BaseViewPagerAdapter;
import com.kimeeo.kAndroid.listViews.recyclerView.BaseRecyclerView;
import com.kimeeo.kAndroidDemos.R;
import com.kimeeo.kAndroidDemos.map.mapList.AbstractHorizontalRecyclerview;
import com.kimeeo.kAndroidDemos.map.mapList.AbstractHorizontalViewPager;
import com.kimeeo.kAndroidDemos.map.mapList.AbstractMapPagerView;
import com.kimeeo.kAndroidDemos.map.mapList.AbstractMapRecyclerView;
import com.kimeeo.kAndroidDemos.map.mapList.AbstractMapView;
import com.kimeeo.kAndroidDemos.oldListView.DataObject;
import com.kimeeo.kAndroidDemos.recycleView.horizontalViews.ListView;
import com.kimeeo.kAndroidDemos.services.DataBean;
import com.kimeeo.kAndroidDemos.services.aADataProvider.AQDataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            public int nextPageTotal = 2;

            Handler h = new Handler();
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    List list = new ArrayList();
                    for (int i = 0; i < pageSize; i++) {
                        list.add(getSample("New "+i, "534534",23.012916023+0.44,72.524510072+0.66));
                    }
                    addData(list);
                }
            };
            @Override
            protected void invokeLoadNext() {
                if (pageCount != nextPageTotal) {
                    h.postDelayed(r, 2000);
                    pageCount += 1;
                } else {
                    setCanLoadNext(false);
                    dataLoadError(null);
                }
            }
            @Override
            protected void invokeLoadRefresh() {}
        };
        dataProvider.add(getSample("B1", "534534",23.012916023,72.524510072));
        dataProvider.add(getSample("B1", "534534", 24.012916023, 72.524510072));
        dataProvider.add(getSample("B2", "534534", 25.012916023, 73.524510072));
        dataProvider.add(getSample("B1", "534534",24.012916023,74.334510072));
        dataProvider.add(getSample("B1", "534534", 21.012916023, 72.524510072));
        dataProvider.add(getSample("B2", "534534", 20.012916023, 74.524510072));
        dataProvider.setCanLoadNext(false);
        dataProvider.setNextEnabled(false);
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
