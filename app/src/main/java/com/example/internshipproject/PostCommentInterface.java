package com.example.internshipproject;

import com.example.internshipproject.Model.Comment;
import com.example.internshipproject.Model.Post;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


//ApiInterface
public interface PostCommentInterface {

  //getting the endpoint of API and field for queries.
    @GET("posts")
    Call<ResponseBody> getPosts();


    //  @GET("posts")
    //  Call<List<Post>> getPosts();



    //getting the list of comments from the endpoints comments having specific postID
    // passing post_id as input in a query as a parameter.
    @GET("posts/{post_id}/comments")
    Call<ResponseBody> getComments(@Path("post_id") int postId);




  // post operation endpoints to post the new comments
    @POST("posts/{post_id}/comments")
    Call<Comment> postComment(@Path("post_id") int postId, @Body Comment comment);

}
