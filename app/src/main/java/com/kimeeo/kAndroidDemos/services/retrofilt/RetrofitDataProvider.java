package com.kimeeo.kAndroidDemos.services.retrofilt;

import android.os.Handler;
import android.os.Looper;

import com.jakewharton.retrofit.Ok3Client;
import com.kimeeo.kAndroid.listViews.dataProvider.BackgroundDataProvider;

import java.io.IOException;
import java.util.List;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by BhavinPadhiyar on 02/05/16.
 */
public class RetrofitDataProvider extends BackgroundDataProvider{

    int curruntPage=0;
    PostsService service;
    public RetrofitDataProvider()
    {
        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("http://kimeeo.com/restT/api/");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit =builder.build();
        service = retrofit.create(PostsService.class);
        setCanLoadRefresh(true);
        setNextEnabled(true);
    }

    @Override
    protected void invokeLoadNext() {
        if(curruntPage!=20) {
            try {
                curruntPage +=1;
                Call<Posts> post = service.listPost();
                retrofit2.Callback<Posts> callback =new retrofit2.Callback<Posts>(){
                    @Override
                    public void onResponse(final Call<Posts> call,final  retrofit2.Response<Posts> response) {
                        addDataThreadSafe(response.body().posts);
                    }
                    @Override
                    public void onFailure(Call<Posts> call, final Throwable t) {
                        dataLoadErrorThreadSafe(t);
                    }
                };
                post.enqueue(callback);
            }catch (Exception e) {
                dataLoadError(e);
            }
        }else
        {
            setCanLoadNext(false);
        }
    }

    @Override
    protected void invokeloadRefresh() {
        setCanLoadRefresh(false);
        dataLoadError(null);
    }

    public interface PostsService {
        @GET("posts?X-API-KEY=KimeeoApp&transform=1")
        Call<Posts> listPost();
    }

    public class Posts{

        public List<Post> posts;


        public class Post{

            private String id;
            private String category_id;
            private String content;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}
