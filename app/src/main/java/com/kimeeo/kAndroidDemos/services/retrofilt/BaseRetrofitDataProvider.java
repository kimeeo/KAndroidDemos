package com.kimeeo.kAndroidDemos.services.retrofilt;


import com.kimeeo.kAndroid.listViews.dataProvider.BackgroundDataProvider;
import com.kimeeo.kAndroid.listViews.dataProvider.DataModel;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by BhavinPadhiyar on 02/05/16.
 */
abstract public class BaseRetrofitDataProvider extends BackgroundDataProvider{
    protected void call(Call call) {
        Callback<DataModel> callback = new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, retrofit2.Response<DataModel> response) {
                DataModel dataModel=response.body();
                processDataManager(dataModel);
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                processDataManager(null);
            }
        };
        call.enqueue(callback);
    }

}
