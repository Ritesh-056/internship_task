package com.example.internshipproject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostCommentInterface {

  //getting the endpoint of API and field for queries.
    @GET("posts")
    Call<ResponseBody> getPosts();



    //getting the list of comments from the endpoints comments having specific postID
    // passing post_id as input in a query as a parameter.

    @GET("posts/{post_id}/comments")
    Call<ResponseBody> getComments(@Path("post_id") int postId);

}
