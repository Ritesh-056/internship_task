package com.example.internshipproject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostCommentInterface {


    @GET("posts")
    Call<ResponseBody> getPosts();
}
