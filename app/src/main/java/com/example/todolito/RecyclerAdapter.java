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
    private Recyclerclicklistener relistener;

    public RecyclerAdapter(ArrayList<ToDo> todos) {
        todolist = todos;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private TextView todo;
        private CheckBox check;
        private ArrayList<ToDo> todolist;

        public MyViewHolder(View view, ArrayList<ToDo> todos) {
            super(view);
            this.todolist = todos;
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            todo = view.findViewById(R.id.textView);
            check = view.findViewById(R.id.checkBox);
        }

        @Override
        public void onClick(View v) {
            relistener.onItemClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            relistener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.todolist_items, parent, false);
        return new MyViewHolder(itemview, todolist);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        String todo = todolist.get(position).getBetreff();
        holder.todo.setText(todo);
    }

    @Override
    public int getItemCount() {
        return todolist.size();
    }

    public Recyclerclicklistener getRelistener() {
        return relistener;
    }

    public void setRelistener(Recyclerclicklistener relistener) {
        this.relistener = relistener;
    }

    interface Recyclerclicklistener {
        void onItemClick(int position, View v);

        void onItemLongClick(int position, View v);
    }
}