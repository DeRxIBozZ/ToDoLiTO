package com.example.todolito;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<ToDo> todolist;

    public RecyclerAdapter(ArrayList<ToDo> todos){
        todolist = todos;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView todo;
        private CheckBox check;

        public MyViewHolder(View view){
            super(view);
            todo = view.findViewById(R.id.textView);
            check = view.findViewById(R.id.checkBox);
        }
    }
    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.todolist_items,parent,false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerAdapter.MyViewHolder holder, int position) {
        String todo = todolist.get(position).getBetreff();
        holder.todo.setText(todo);
    }

    @Override
    public int getItemCount() {
        return todolist.size();
    }
}
