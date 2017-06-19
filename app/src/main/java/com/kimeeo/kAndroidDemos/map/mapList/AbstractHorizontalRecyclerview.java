package com.kimeeo.kAndroidDemos.map.mapList;

import android.view.View;
import android.widget.AdapterView;

import com.kimeeo.kAndroid.dataProvider.DataProvider;

/**
 * Created by bpa001 on 6/19/17.
 */

abstract public class AbstractHorizontalRecyclerview extends com.kimeeo.kAndroid.listViews.recyclerView.horizontalViews.ListView implements OnPageChange,AbstractMapRecyclerView.MapRecyclerView{
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        super.onItemClick(parent,view,position,id);
        onPageChange(position);
    }
    final protected DataProvider createDataProvider(){return null;}
    @Override
    public android.support.v7.widget.RecyclerView recyclerView()
    {
        return getRecyclerView();
    }
}
