package com.example.internshipproject.Model;

public class Comment {

    //defining a member variable
      int id ;
      String name;
      String email;
      String body;



     public  Comment(){

     }


    //creating the constructor of the Comment class
    public Comment( int id, String name, String email, String body) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }



    //getter and setter of member variables.


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
