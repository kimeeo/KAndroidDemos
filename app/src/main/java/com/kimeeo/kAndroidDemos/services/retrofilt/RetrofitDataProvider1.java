package com.kimeeo.kAndroidDemos.services.retrofilt;


import com.kimeeo.kAndroid.listViews.dataProvider.BackgroundDataProvider;
import com.kimeeo.kAndroidDemos.services.BaseDataModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by BhavinPadhiyar on 02/05/16.
 */
public class RetrofitDataProvider1 extends BackgroundDataProvider{

    int curruntPage=0;
    PostsService service;
    public RetrofitDataProvider1()
    {
        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("http://www.googledrive.com/host/0B0GMnwpS0IrNRkI5WFVCZG5EUTQ/");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit =builder.build();
        service = retrofit.create(PostsService.class);
        setCanLoadRefresh(true);
        setNextEnabled(true);
    }

    @Override
    protected void invokeLoadNext() {
        if(curruntPage!=4) {
            try {
                curruntPage +=1;
                Call<BaseDataModel> post = service.dataModel();
                Callback<BaseDataModel> callback = new Callback<BaseDataModel>() {
                    @Override
                    public void onResponse(Call<BaseDataModel> call, retrofit2.Response<BaseDataModel> response) {
                        BaseDataModel baseDataModel=response.body();
                        processDataManager(baseDataModel);
                    }

                    @Override
                    public void onFailure(Call<BaseDataModel> call, Throwable t) {
                        processDataManager(null);
                    }
                };
                post.enqueue(callback);
            }catch (Exception e) {
            }
        }else
        {
            setCanLoadNext(false);
            processDataManager(null);
        }
    }
    @Override
    protected void invokeLoadRefresh() {
        setCanLoadRefresh(false);
    }
    public interface PostsService{
        @GET("data1.txt")
        Call<BaseDataModel> dataModel();
    }
}
