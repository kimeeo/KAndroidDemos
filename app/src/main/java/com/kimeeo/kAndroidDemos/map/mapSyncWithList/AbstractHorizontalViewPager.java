package com.kimeeo.kAndroidDemos.map.mapSyncWithList;

/**
 * Created by bpa001 on 6/17/17.
 */
import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroid.listViews.pager.viewPager.HorizontalViewPager;

abstract public class AbstractHorizontalViewPager extends HorizontalViewPager implements OnPageChange {
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
    @Override
    protected void onPageChange(Object itemPosition, int position) {
        onPageChange(position);
    }
    @Override
    final protected DataProvider createDataProvider(){return null;}
}
