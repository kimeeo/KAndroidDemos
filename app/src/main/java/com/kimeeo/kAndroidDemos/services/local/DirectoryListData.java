package com.kimeeo.kAndroidDemos.services.local;

import android.content.Context;
import android.os.Environment;

import com.kimeeo.kAndroid.listViews.dataProvider.DirectoryDataProvider;

/**
 * Created by BhavinPadhiyar on 03/05/16.
 */
public class DirectoryListData extends DirectoryDataProvider{

    int curruntPage=0;
    public DirectoryListData(Context context)
    {
        super(context);
        //setFilters(new String[]{"png","txt"});
    }

    @Override
    protected String nextPath() {
        if(curruntPage!=1) {
            curruntPage+=1;
            return Environment.getExternalStorageDirectory().toString() + "/Download";
        }
        else {
            setCanLoadNext(false);
            return null;
        }
    }
    @Override
    protected String refreshPath() {
        return null;
    }
}
