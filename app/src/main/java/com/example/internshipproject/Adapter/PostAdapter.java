package com.example.internshipproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internshipproject.Model.Post;
import com.example.internshipproject.R;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    ArrayList<Post>  posts;

   //constructor of PostAdapter with list as a parameter
    public PostAdapter(ArrayList<Post> postLists) {
        this.posts = postLists;
    }



    //Declaring the view for the adapter to populate the data.
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_post,parent,false);
        return new PostViewHolder(view);
    }


    //Holder set the data in the current position of every item.
    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.setData(posts.get(position));
    }


    // count the size of fetched data and return its size.
    @Override
    public int getItemCount() {
        return posts.size();
    }


}//end of class


