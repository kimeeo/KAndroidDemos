package com.kimeeo.kAndroidDemos.services.sqlLite;

import android.content.Context;

import java.util.List;

/**
 * Created by BhavinPadhiyar on 03/05/16.
 */
public class DataProvider extends com.kimeeo.kAndroid.listViews.dataProvider.DataProvider
{
    MySQLiteDataHelper mySQL;
    public  DataProvider(Context context)
    {
        mySQL=new MySQLiteDataHelper(context);
        //mySQL.addSample();
    }

    private int curruntPage=0;

    @Override
    protected void invokeLoadNext() {
        if(curruntPage!=3) {
            curruntPage +=1;
            List list =mySQL.getList();
            addData(list);
        }
        else
        {
            setCanLoadNext(false);
            dataLoadError(null);
        }
    }

    @Override
    protected void invokeLoadRefresh() {
        setRefreshEnabled(false);
        setCanLoadNext(false);
    }
}
