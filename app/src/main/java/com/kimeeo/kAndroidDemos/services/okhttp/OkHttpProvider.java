package com.kimeeo.kAndroidDemos.services.okhttp;

import android.content.Context;

import com.kimeeo.kAndroid.listViews.dataProvider.DataModel;
import com.kimeeo.kAndroid.okHTTPDataProvider.JSONDataProvider;
import com.kimeeo.kAndroidDemos.services.BaseDataModel;
import com.kimeeo.kAndroidDemos.services.DataBean;

import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

/**
 * Created by BhavinPadhiyar on 02/05/16.
 */
public class OkHttpProvider extends JSONDataProvider {
    int curruntPage=0;
    int minCurruntPage=0;
    public OkHttpProvider(OkHttpClient client,boolean nextEnabled, boolean refreshEnabled)
    {
        super(client);
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
            return "http://www.googledrive.com/host/0B0GMnwpS0IrNRkI5WFVCZG5EUTQ/data_m" + minCurruntPage + ".txt";
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
            return "http://www.googledrive.com/host/0B0GMnwpS0IrNRkI5WFVCZG5EUTQ/data" + curruntPage + ".txt";
        }
        else {
            setCanLoadNext(false);
            return null;
        }
    }

    @Override
    protected Class getDataModel() {
        return BaseDataModel.class;
    }

    @Override
    protected RequestBody getNextRequestBody() {
        return null;
    }

    @Override
    protected RequestBody getRefreshRequestBody() {
        return null;
    }
}
