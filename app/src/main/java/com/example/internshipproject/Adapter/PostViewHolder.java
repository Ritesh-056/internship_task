package com.example.internshipproject.Adapter;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internshipproject.Model.Post;
import com.example.internshipproject.Screens.PostDetailScreenActivity;
import com.example.internshipproject.R;

public class PostViewHolder extends RecyclerView.ViewHolder {

    //defining the member variables
    TextView postId , postTitle, postBody;
    Post mPosts;



   //defining and handling the populated items.
    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        postId      = itemView.findViewById(R.id.post_id);
        postTitle   = itemView.findViewById(R.id.title);
        postBody    = itemView.findViewById(R.id.body);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(itemView.getContext(), PostDetailScreenActivity.class);
                intent.putExtra("postId",String.valueOf(mPosts.getPostId()));
                itemView.getContext().startActivity(intent);
            }
        });


    }


    //this method set data to the UI view point.
    public  void setData(Post post){
        mPosts = post ;
        postId.setText("ID       => "+String.valueOf(post.getPostId()));
        postTitle.setText("Title   => "+post.getTitle());
        postBody.setText("Body  => "+post.getBody());
    }
}
