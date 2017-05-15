package com.kimeeo.kAndroidDemos.services.local;

import android.content.Context;

import com.kimeeo.kAndroid.localDataProvider.AssetsDataProvider;
import com.kimeeo.kAndroidDemos.services.BaseDataModel;

/**
 * Created by BhavinPadhiyar on 03/05/16.
 */
public class AssetsData extends AssetsDataProvider{

    int curruntPage=0;
    public AssetsData(Context context)
    {
        super(context);
    }

    @Override
    protected String getNextAssetsPath() {
        if(curruntPage!=4) {
            curruntPage+=1;
            return "dir/assetData.txt";
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
}
