package com.kimeeo.kAndroidDemos.map;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RawRes;

import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroid.map.BaseMapView;
import com.kimeeo.kAndroidDemos.R;

/**
 * Created by BhavinPadhiyar on 07/05/16.
 */
public class MapView extends BaseMapView
{

    @RawRes
    @Override
    protected int getDefaultMapStyle() {
        return R.raw.map_style1;
    }

    @NonNull
    @Override
    protected DataProvider createDataProvider() {
        Handler h = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                getDataProvider().remove(0);
                setMapStyle(R.raw.map_style2);
            }
        };
        h.postDelayed(r, 5000);

        DataProvider dataProvider = new DataProvider(){
            @Override
            protected void invokeLoadNext() {}
            @Override
            protected void invokeLoadRefresh() {}
        };
        dataProvider.add(getSample("B1", "534534",23.012916023,72.524510072));
        dataProvider.add(getSample("B1", "534534", 24.012916023, 72.524510072));
        dataProvider.add(getSample("B2", "534534", 25.012916023, 73.524510072));
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
}
