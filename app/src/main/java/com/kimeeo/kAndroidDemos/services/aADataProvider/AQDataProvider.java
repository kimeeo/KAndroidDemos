package com.kimeeo.kAndroidDemos.services.aADataProvider;

import android.content.Context;

import com.kimeeo.kAndroid.aQueryDataProvider.JSONDataProvider;
import com.kimeeo.kAndroidDemos.services.BaseDataModel;

import java.util.Map;

/**
 * Created by BhavinPadhiyar on 02/05/16.
 */
public class AQDataProvider extends JSONDataProvider {
    int curruntPage=0;
    int minCurruntPage=0;
    public AQDataProvider(Context context,boolean nextEnabled,boolean refreshEnabled)
    {
        super(context);
        setNextEnabled(nextEnabled);
        setRefreshEnabled(refreshEnabled);
    }
    @Override
    protected int getMethod() {
        return METHOD_GET;
    }
    @Override
    protected String getRefreshURL() {
        if(minCurruntPage!=2) {
            minCurruntPage+=1;
            return "http://kimeeo.com/kAndroidSample/data" + minCurruntPage + ".txt";
        }
        else {
            setCanLoadRefresh(false);
            return null;
        }
    }
    @Override
    protected String getNextURL() {
        if(curruntPage!=4) {
            curruntPage+=1;
            return "http://kimeeo.com/kAndroidSample/data" + curruntPage + ".txt";
        }
        else {
            setCanLoadNext(false);
            return null;
        }
    }
    @Override
    protected Map<String, Object> getNextParam() {
        return null;
    }
    @Override
    protected Class getDataModel() {
        return BaseDataModel.class;
    }
}
