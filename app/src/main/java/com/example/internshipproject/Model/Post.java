package com.example.internshipproject.Model;

public class Post {

    // defining member variables.
    int postId;
    String title;
    String body;


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