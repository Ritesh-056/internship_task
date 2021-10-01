package com.example.internshipproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internshipproject.Model.Comment;
import com.example.internshipproject.R;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentViewHolder> {


    //defining Comment class as a Arraylist
    ArrayList<Comment> comments ;


    //constructor of CommentAdapter with list as a parameter
    public CommentAdapter(ArrayList<Comment> commentLists) {
        this.comments = commentLists;
    }



    //Declaring the view for the adapter to populate the data.
    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_comment,parent,false);
        return new CommentViewHolder(view);
    }


    //Holder set the data in the current position of every item.
    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
      holder.setCommentData(comments.get(position));
    }

    // count the size of fetched data and return its size.
    @Override
    public int getItemCount() {
        return comments.size();
    }

}//end of class
