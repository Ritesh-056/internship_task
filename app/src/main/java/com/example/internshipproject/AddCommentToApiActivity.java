package com.example.internshipproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.internshipproject.Model.Comment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCommentToApiActivity extends AppCompatActivity {



    //declaring class member variables
    EditText userId,postEmail,postName,postBody;
    Button buttonPost;
    private static final String TAG = "AddCommentClass";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comments_to_api);

        //declaring the member variables of view XML

        userId = findViewById(R.id.userId);
        postEmail = findViewById(R.id.postEmail);
        postBody  = findViewById(R.id.postBody);
        postName = findViewById(R.id.postName);
        buttonPost = findViewById(R.id.buttonPost);




        //getting intent data
        Intent intent =getIntent();
        int postId =intent.getIntExtra("postId",0);




        //button to POST
        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 int id  = Integer.parseInt(userId.getText().toString());
                 String email =postEmail.getText().toString();
                 String body =postBody.getText().toString();
                 String name=postName.getText().toString();




                 //comment object and add value to member variables
                Comment comment = new Comment();
                 comment.setCid(id);
                 comment.setEmail(email);
                 comment.setBody(body);
                 comment.setName(name);






                //POST operation -> api
                ServiceGenerator.createRequest(PostCommentInterface.class).postComment(postId,comment).enqueue(new Callback<Comment>() {

                     @Override
                     public void onResponse(Call<Comment> call, Response<Comment> response) {


                         //response body to Comment class.
                         Comment comment1 = response.body();
                         String checkResponse = comment1.getName()+"\n"+comment1.getEmail()+"\n"+comment1.getBody();
                         Log.d(TAG, "onResponse: " +checkResponse);


                         Toast.makeText(getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();


                         //clearing the editText value
                         userId.setText("");
                         postEmail.setText("");
                         postBody.setText("");
                         postName.setText("");
                     }



                     @Override
                     public void onFailure(Call<Comment> call, Throwable t) {

                         t.printStackTrace();
                     }
                 });
            }



        });
    }
}