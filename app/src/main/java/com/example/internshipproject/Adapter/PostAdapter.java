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


    public PostAdapter(ArrayList<Post> postLists) {
        this.posts = postLists;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_post,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.setData(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
