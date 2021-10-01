package com.example.internshipproject.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internshipproject.Model.Comment;
import com.example.internshipproject.R;

public class CommentViewHolder extends RecyclerView.ViewHolder {


    //declaring class variable.
    TextView postId, cId, cName,cEmail, cBody;



    //defining the class variable as  a itemView
    public CommentViewHolder(@NonNull View itemView) {
        super(itemView);


        postId    = itemView.findViewById(R.id.post_id);
        cId       = itemView.findViewById(R.id.list_id);
        cName     = itemView.findViewById(R.id.title);
        cEmail    = itemView.findViewById(R.id.email);
        cBody     = itemView.findViewById(R.id.body);
    }



    //setting the value of each member variable of Comment class.
    public void setCommentData(Comment comment){

          cId.setText("Id =>"+String.valueOf(comment.getId()));
          cName.setText("Name =>"+comment.getName());
          cEmail.setText("Email =>"+comment.getEmail());
          cBody.setText("Body =>"+comment.getBody());

    }
}
