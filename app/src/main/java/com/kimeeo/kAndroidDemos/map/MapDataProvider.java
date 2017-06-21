package com.kimeeo.kAndroidDemos.map;

import android.os.Handler;

import com.kimeeo.kAndroid.dataProvider.StaticDataProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpa001 on 6/21/17.
 */

public class MapDataProvider extends StaticDataProvider {
    public MapDataProvider()
    {
        setRefreshEnabled(false);
        setPagingEnabled(true);
    }
    private int pageCount = 1;
    public int pageSize = 10;
    public int nextPageTotal = 8;
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

    private SamplePOIModel getSample(String name, String phone,Double latitude,Double longitude) {
        SamplePOIModel o = new SamplePOIModel();
        o.name =name;
        o.details = phone;
        o.latitude=latitude;
        o.longitude=longitude;
        return o;
    }
}
