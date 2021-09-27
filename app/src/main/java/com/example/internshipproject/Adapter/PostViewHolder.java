package com.example.internshipproject.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internshipproject.Model.Post;
import com.example.internshipproject.R;

public class PostViewHolder extends RecyclerView.ViewHolder {

    //defining the member variables
    TextView postId , postTitle, postBody;



   //defining and handling the populated items.
    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        postId      = itemView.findViewById(R.id.post_id);
        postTitle   = itemView.findViewById(R.id.title);
        postBody    = itemView.findViewById(R.id.body);

    }


    //this method set data to the UI view point.
    public  void setData(Post post){

        postId.setText("id: "+String.valueOf(post.getPostId()));
        postTitle.setText("title: "+post.getTitle());
        postBody.setText("body: "+post.getBody());
    }
}
