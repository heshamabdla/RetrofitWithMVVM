package com.example.retrofitwithmvvmrv.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofitwithmvvmrv.data.PostClient;
import com.example.retrofitwithmvvmrv.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<PostModel>> postMutableLiveData =new MutableLiveData<>();
    MutableLiveData<String> posts = new MutableLiveData<>();


    public  void getPost() {
        PostClient.getInstance().getPost().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                posts.setValue("error");

            }
        });

    }

    }

