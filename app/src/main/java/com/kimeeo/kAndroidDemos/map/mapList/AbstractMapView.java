package com.kimeeo.kAndroidDemos.map.mapList;

import com.google.android.gms.maps.model.Marker;
import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroid.dataProvider.StaticDataProvider;
import com.kimeeo.kAndroid.map.BaseMapView;

/**
 * Created by bpa001 on 6/17/17.
 */

abstract public class AbstractMapView extends BaseMapView implements OnPageChange {
    OnPageChange onPageChange;
    @Override
    public void setOnPageChange(OnPageChange onPageChange) {
        this.onPageChange=onPageChange;
    }
    @Override
    public void onPageChange(int page) {
        if(onPageChange!=null)
            onPageChange.onPageChange(page);
    }
    public boolean onMarkerTouch(Marker marker, Object data) {
        onPageChange(getDataProvider().indexOf(data));
        return false;
    };
    final protected DataProvider createDataProvider(){return null;}
}
