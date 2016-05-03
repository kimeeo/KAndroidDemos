package com.kimeeo.kAndroidDemos.services.retrofilt;


import com.kimeeo.kAndroid.retrofitDataProvider.*;
import com.kimeeo.kAndroidDemos.services.BaseDataModel;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by BhavinPadhiyar on 02/05/16.
 */
public class RetrofitDataProvider2 extends BaseRetrofitDataProvider{

    int curruntPage=0;
    int minCurruntPage=0;
    PostsService service;
    public RetrofitDataProvider2()
    {
        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("http://www.googledrive.com/host/0B0GMnwpS0IrNRkI5WFVCZG5EUTQ/");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit =builder.build();
        service = retrofit.create(PostsService.class);
        setCanLoadRefresh(true);
        setNextEnabled(true);
        setRefreshEnabled(true);
    }

    @Override
    protected void invokeLoadNext() {
        if(curruntPage!=4) {
            try {
                curruntPage +=1;
                call(service.dataModel("data"+curruntPage+".txt"));
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
        if(minCurruntPage!=2) {
            try {
                minCurruntPage +=1;
                call(service.dataModel("data_m"+minCurruntPage+".txt"));
            }catch (Exception e) {
            }
        }else
        {
            setCanLoadRefresh(false);
            processDataManager(null);
        }
    }

    public interface PostsService{
        @GET("{path}")
        Call<BaseDataModel> dataModel(@Path("path") String path);
    }
}
