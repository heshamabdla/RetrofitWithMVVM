package com.example.retrofitwithmvvmrv.data;

import com.example.retrofitwithmvvmrv.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private static final String base_URL="https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
   private static PostClient instance;
    public PostClient() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface=retrofit.create(PostInterface.class);

    }

    public static PostClient getInstance() {
        if (null == instance){
            instance = new PostClient();
        }
        return instance;
    }
    public Call<List<PostModel>> getPost(){
        return postInterface.getPost();
    }
}
