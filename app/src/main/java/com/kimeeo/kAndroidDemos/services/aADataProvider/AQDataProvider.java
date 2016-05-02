package com.kimeeo.kAndroidDemos.services.aADataProvider;

import android.content.Context;

import com.kimeeo.kAndroid.aQueryDataProvider.JSONDataProvider;

import java.util.List;
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
    protected Map<String, Object> getNextParam() {
        return null;
    }
    @Override
    protected Class getDataModel() {
        return BaseDataModel.class;
    }

    public class BaseDataModel implements DataModel
    {
        private String success;
        private List<DataBean> data;
        @Override
        public List getDataProvider() {
            return data;
        }

        public String getSuccess() {
            return success;
        }
        public void setSuccess(String success) {
            this.success = success;
        }
        public List<DataBean> getData() {
            return data;
        }
        public void setData(List<DataBean> data) {
            this.data = data;
        }
    }

}
