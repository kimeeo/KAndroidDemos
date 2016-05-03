package com.kimeeo.kAndroidDemos.services.local;

import android.content.Context;
import android.os.Environment;

import com.kimeeo.kAndroid.localDataProvider.FileDataProvider;
import com.kimeeo.kAndroidDemos.services.BaseDataModel;

/**
 * Created by BhavinPadhiyar on 03/05/16.
 */
public class FileData extends FileDataProvider
{

    int curruntPage=0;
    public FileData(Context context)
    {
        super(context);
    }

    @Override
    protected String getNextPath() {
        if(curruntPage!=4) {
            curruntPage+=1;
            return Environment.getExternalStorageDirectory().toString()+"/kandroidData/asset_data.txt";
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
