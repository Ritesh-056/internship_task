package com.example.internshipproject.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.example.internshipproject.Adapter.PostAdapter;
import com.example.internshipproject.Model.Post;
import com.example.internshipproject.PostCommentInterface;
import com.example.internshipproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class PostScreen extends AppCompatActivity {

    ArrayList<Post> postArrayList ;
    RecyclerView recyclerView ;
    private static final String TAG = "MainActivity";
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialization
        init();
        setProgressDialog();



        //retrofit implementation with the URL
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                 .build();


        //requesting the URL for json data

        PostCommentInterface postCommentInterface = retrofit.create(PostCommentInterface.class);
        postCommentInterface.getPosts().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {

                  if(response !=null){
                      JSONArray jsonArray = new JSONArray(response.body().string());
                      Log.d(TAG, "onResponse: Item count =>" +jsonArray.length());


                      for(int i =0 ; i <jsonArray.length() ; i++){

                          JSONObject jsonObject = jsonArray.getJSONObject(i);


                          //converting the jsonObject in class member variable

                          int postID  =jsonObject.getInt("id");
                          String postTitle = jsonObject.getString("title");
                          String postBody = jsonObject.getString("body");


                          //adding the data to list
                          postArrayList.add(new Post(postID,postTitle,postBody));
                      }


                      //set adapter in recyclerView to populate data and notify the user
                      PostAdapter postAdapter = new PostAdapter(postArrayList);
                      recyclerView.setAdapter(postAdapter);
                      postAdapter.notifyDataSetChanged();
                      progressDialog.dismiss();

                  }

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }



    public void init(){

        //initialization
        recyclerView = findViewById(R.id.recyclerView);
        postArrayList = new ArrayList<>();

        //setting layout manager as linearlayout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    public void setProgressDialog(){
        progressDialog = new ProgressDialog(PostScreen.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );
    }



} //end of class

