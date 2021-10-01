package com.example.internshipproject.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.internshipproject.Adapter.CommentAdapter;
import com.example.internshipproject.Model.Comment;
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

public class PostDetailScreen extends AppCompatActivity {


    //defining the class variables

    TextView postIds ;
    RecyclerView commentRecyclerView;
    ArrayList<Comment> commentsList ;
    ProgressDialog progressDialog ;

    private static final String TAG = "PostDetailScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail_screen);


        //defining the xml to class variable
        postIds = findViewById(R.id.post_id);
        commentRecyclerView = findViewById(R.id.recyclerView);
        commentRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        commentsList = new ArrayList<>();



        //show progress dialog
        setProgressDialog();



        //getting the intent data
        Intent intent = getIntent();
        int postID = Integer.parseInt(intent.getStringExtra("postId"));

        Log.d(TAG, "onResponse: [postID]= " + postID);

        //set the  value of postID to textView
        postIds.setText("PostID ="+String.valueOf(postID));




        //retrofit implementation with the URL
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();




        //requesting the URL for json data by providing the appropriate URI as postID
        PostCommentInterface commentInterface = retrofit.create(PostCommentInterface.class);
        commentInterface.getComments(postID).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                //check whether the response is successful.
                if(response.isSuccessful()){

                    try {


                        //response to jsonArray
                        JSONArray jsonArray = new JSONArray(response.body().string());
                        Log.d(TAG, "onResponse: CommentListSize =" +jsonArray.length());

                        for(int i=0 ; i<jsonArray.length() ; i++){

                            //holding the every index value as a jsonObject
                            JSONObject jsonObject = jsonArray.getJSONObject(i);


                            //converting the jsonObject in class member variable

                            int id        = jsonObject.getInt("id");
                            String cName  = jsonObject.getString("name");
                            String cEmail = jsonObject.getString("email");
                            String cBody  = jsonObject.getString("body");


                            //adding the data to list
                            commentsList.add(new Comment(id,cName,cEmail,cBody));

                        }

                        //setting adapter to recycler and notify the user changed data.
                        CommentAdapter commentAdapter = new CommentAdapter(commentsList);
                        commentRecyclerView.setAdapter(commentAdapter);
                        commentAdapter.notifyDataSetChanged();
                        progressDialog.dismiss();


                    }
                    //catch whether the exception is Json exception or IO exception.

                    catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }


            //onFailure of response
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure: =" +t.toString());

            }
        });
    }



    //progress dialog function
    public void setProgressDialog(){
        progressDialog = new ProgressDialog(PostDetailScreen.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );
    }

}//end of class