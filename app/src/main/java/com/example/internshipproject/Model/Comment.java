package com.example.internshipproject.Model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class Comment extends SugarRecord<Comment> {

    //defining a member variable
      int cid;
      String name;
      String email;
      String body;
      int postId;


     public  Comment(){

     }


    //creating the constructor of the Comment class


    public Comment(int cid, String name, String email, String body, int postId) {
        this.cid = cid;
        this.name = name;
        this.email = email;
        this.body = body;
        this.postId = postId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }


    //getter and setter of member variables.


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


} //end of class
