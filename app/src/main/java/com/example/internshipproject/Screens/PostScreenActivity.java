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
import com.example.internshipproject.ServiceGenerator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class PostScreenActivity extends AppCompatActivity {

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
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://jsonplaceholder.typicode.com/")
//                 .build();


        //requesting the URL for json data

//
//        ServiceGenerator.createRequest(PostCommentInterface.class).getPosts().enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//
//
//                postArrayList = (ArrayList<Post>) response.body();
//
//                for (Post p :postArrayList
//                     ) {
//
//                    Log.d(TAG, "onResponse: "+p.toString());
////                    p.save();
//
//
//                }
//
//                PostAdapter postAdapter = new PostAdapter(postArrayList);
//                recyclerView.setAdapter(postAdapter);
//                postAdapter.notifyDataSetChanged();
//                progressDialog.dismiss();
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                   t.printStackTrace();
//            }
//        });


        ServiceGenerator.createRequest(PostCommentInterface.class).getPosts().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {

                  if(response !=null){
                      JSONArray jsonArray = new JSONArray(response.body().string());
                      Log.d(TAG, "onResponse: Item count =>" +jsonArray.length());


                      for(int i =0 ; i <jsonArray.length() ; i++){

                          JSONObject jsonObject = jsonArray.getJSONObject(i);


                          //converting the jsonObject in class member variable

                          int postID       = jsonObject.getInt("id");
                          String postTitle = jsonObject.getString("title");
                          String postBody  = jsonObject.getString("body");


                          //adding the data to list
                          Post p = new Post(postID,postTitle,postBody);
                          p.save();
                          postArrayList.add(p);
                          Log.d(TAG, "onResponse: "+p.getTitle()+"body"+p.getBody());

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
        progressDialog = new ProgressDialog(PostScreenActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );
    }



} //end of class

