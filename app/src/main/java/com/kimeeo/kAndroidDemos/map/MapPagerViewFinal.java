package com.kimeeo.kAndroidDemos.map;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroid.dataProvider.StaticDataProvider;
import com.kimeeo.kAndroid.listViews.BaseListDataView;
import com.kimeeo.kAndroid.listViews.pager.BaseItemHolder;
import com.kimeeo.kAndroid.listViews.pager.BaseViewPager;
import com.kimeeo.kAndroid.listViews.pager.viewPager.BaseViewPagerAdapter;
import com.kimeeo.kAndroidDemos.R;
import com.kimeeo.kAndroidDemos.map.mapList.AbstractMapPagerView;
import com.kimeeo.kAndroidDemos.map.mapList.AbstractMapView;
import com.kimeeo.kAndroidDemos.map.mapList.AbstractHorizontalViewPager;

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
        DataProvider dataProvider = new StaticDataProvider(){
            @Override
            protected void invokeLoadNext() {}
            @Override
            protected void invokeLoadRefresh() {}
        };
        dataProvider.add(getSample("B1", "534534",23.012916023,72.524510072));
        dataProvider.add(getSample("B1", "534534", 24.012916023, 72.524510072));
        dataProvider.add(getSample("B2", "534534", 25.012916023, 73.524510072));
        dataProvider.add(getSample("B1", "534534",24.012916023,74.334510072));
        dataProvider.add(getSample("B1", "534534", 21.012916023, 72.524510072));
        dataProvider.add(getSample("B2", "534534", 20.012916023, 74.524510072));
        //dataProvider.setCanLoadNext(false);
        //dataProvider.setNextEnabled(false);
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
