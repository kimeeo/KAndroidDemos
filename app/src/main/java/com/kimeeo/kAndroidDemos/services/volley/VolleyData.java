package com.kimeeo.kAndroidDemos.services.volley;

import com.android.volley.Request;
import com.kimeeo.kAndroid.volleyDataProvider.IVolleyRequestProvider;
import com.kimeeo.kAndroid.volleyDataProvider.JSONDataProvider;
import com.kimeeo.kAndroidDemos.services.BaseDataModel;

/**
 * Created by BhavinPadhiyar on 04/05/16.
 */
public class VolleyData extends JSONDataProvider {
    int curruntPage=0;
    public VolleyData(IVolleyRequestProvider volleyRequestController)
    {
        super(volleyRequestController);
    }
    @Override
    protected int getMethod() {
        return Request.Method.GET;
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
    protected Object getNextParam() {return null;}

    @Override
    protected Class getDataModel() {
        return BaseDataModel.class;
    }
}
