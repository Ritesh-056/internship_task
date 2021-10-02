package com.example.internshipproject.Model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class Post extends  SugarRecord{

    // defining member variables.

//
//    @SerializedName("id")
    int postId;

    String title;
    String body;

    public Post() {
    }

    //constructor of class Post
    public Post(int postId, String title, String body) {
        this.postId = postId;
        this.title = title;
        this.body = body;
    }


    //getter and setter of class member variable
    public int getPostId() {
        return postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }


}//end of class