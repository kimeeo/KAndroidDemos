package com.kimeeo.kAndroidDemos.services.local;

import android.content.Context;

import com.kimeeo.kAndroid.localDataProvider.RawDataProvider;
import com.kimeeo.kAndroidDemos.R;
import com.kimeeo.kAndroidDemos.services.BaseDataModel;

/**
 * Created by BhavinPadhiyar on 03/05/16.
 */
public class RawData extends RawDataProvider
{

    int curruntPage=0;
    public RawData(Context context)
    {
        super(context);
    }

    @Override
    protected int getNextResID() {
        if(curruntPage!=4) {
            curruntPage+=1;
            return R.raw.asset_data;
        }
        else {
            setCanLoadNext(false);
            return -1;
        }
    }

    @Override
    protected Class getDataModel() {
        return BaseDataModel.class;
    }
}
