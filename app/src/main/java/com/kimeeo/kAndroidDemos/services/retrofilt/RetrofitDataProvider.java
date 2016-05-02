package com.kimeeo.kAndroidDemos.services.retrofilt;

import com.kimeeo.kAndroid.listViews.dataProvider.BackgroundDataProvider;

import java.io.IOException;
import java.util.List;

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
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://kimeeo.com/restT/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();
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
                List<Posts.Post> posts = post.execute().body().posts;
                //addData(posts);
                addDataThreadSafe(posts);
                //addDataInThread(posts);
            } catch (IOException e) {
                dataLoadError(e);
            } catch (Exception e) {
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
