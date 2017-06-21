package com.kimeeo.kAndroidDemos.map;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroid.dataProvider.StaticDataProvider;
import com.kimeeo.kAndroid.listViews.pager.BaseItemHolder;
import com.kimeeo.kAndroid.listViews.pager.BaseViewPager;
import com.kimeeo.kAndroid.listViews.pager.viewPager.BaseViewPagerAdapter;
import com.kimeeo.kAndroidDemos.R;
import com.kimeeo.kAndroidDemos.map.mapSyncWithList.AbstractMapPagerView;
import com.kimeeo.kAndroidDemos.map.mapSyncWithList.AbstractMapView;
import com.kimeeo.kAndroidDemos.map.mapSyncWithList.AbstractHorizontalViewPager;

/**
 * Created by bpa001 on 6/17/17.
 */

public class MapPagerViewFinal extends AbstractMapPagerView {



    @Override
    protected BaseViewPager createViewPagerView() {
        return new ViewPager();
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
    public static class ViewPager extends AbstractHorizontalViewPager {


        public String getItemTitle(int position, Object o) {
            if (o instanceof SamplePOIModel) {
                SamplePOIModel data = (SamplePOIModel) o;
                return data.name;

            }
            return "";
        }

        protected void configViewPager(android.support.v4.view.ViewPager viewPager, BaseViewPagerAdapter mAdapter, View indicator) {
            viewPager.setPageTransformer(true, new CubeOutTransformer());
        }

        @Override
        public View getView(int i, Object o) {
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View view = inflater.inflate(R.layout.sample_list_view_item, null);
            return view;
        }

        @Override
        public BaseItemHolder getItemHolder(View view, int i, Object o) {
            return new BaseItemHolder1(view);
        }
    }
    public static class BaseItemHolder1 extends BaseItemHolder {
        public BaseItemHolder1(View itemView) {
            super(itemView);
        }

        @Override
        public void cleanView(View view, int i) {

        }

        @Override
        public void updateItemView(Object o, View view, int i) {
            SamplePOIModel data = (SamplePOIModel) o;
            TextView title = (TextView) view.findViewById(R.id.title);
            title.setText(i + ". " + data.name);
        }
    }

}
