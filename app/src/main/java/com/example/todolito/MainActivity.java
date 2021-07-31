package com.example.todolito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SelectedData{

    private ArrayList<ToDo> todolist;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private FloatingActionButton button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainActivity","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this,AddToDoActivity.class);
            startActivityForResult(intent,0);
        });
        todolist = new ArrayList<>();
        setToDoInfo();
        setAdapter();
    }

    private void setToDoInfo() {
        todolist.add(new ToDo("Bier holen"));
        todolist.add(new ToDo("Mehr Bier holen"));
        todolist.add(new ToDo("Noch mehr Bier holen"));
    }

    private void setAdapter() {
        final MainActivity ma = this;
        adapter = new RecyclerAdapter(todolist);
        adapter.setRelistener(new RecyclerAdapter.Recyclerclicklistener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(ma,DetailActivity.class);
                String betreffText = todolist.get(position).getBetreff() ;
                intent.putExtra("Betreff",betreffText);
                String bemerkungText = todolist.get(position).getBemerkung();
                intent.putExtra("Bemerkung",bemerkungText);
                String zusatzText = todolist.get(position).getZusatz();
                intent.putExtra("Zusatz",zusatzText);
                String dateText = todolist.get(position).getDate();
                intent.putExtra("Date",dateText);
                String timestartText = todolist.get(position).getTimestart();
                intent.putExtra("Timestart",timestartText);
                String timeendText = todolist.get(position).getTimeend();
                intent.putExtra("Timeend",timeendText);
                intent.putExtra("Ganztaegig",todolist.get(position).isGanztaegig());
                intent.putExtra("Index",position);
                startActivityForResult(intent,1);

            }

            @Override
            public void onItemLongClick(int position, View v) {
                DeleteDialogFragment dialogFragment = new DeleteDialogFragment();
                dialogFragment.setPosition(position);
                dialogFragment.show(ma.getSupportFragmentManager(),"DeleteDialogFragment");
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }



    @Override
    protected void onActivityResult(int requestcode,int resultcode,Intent data){
        super.onActivityResult(requestcode,resultcode,data);
        if(resultcode == -1){

        } else if(data.getStringExtra("Betreff") != null && (!data.getStringExtra("Betreff").equals("")) && resultcode == 0){
            ToDo temp = new ToDo(data.getStringExtra("Betreff"));
            temp.setBemerkung(data.getStringExtra("Bemerkung"));
            temp.setZusatz(data.getStringExtra("Zusatz"));
            temp.setDate(data.getStringExtra("Date"));
            temp.setTimestart(data.getStringExtra("Timestart"));
            temp.setTimeend(data.getStringExtra("Timeend"));
            temp.setGanztaegig(data.getBooleanExtra("Ganztaegig",false));
            todolist.add(temp);
        } else if(data.getStringExtra("Betreff") != null && (!data.getStringExtra("Betreff").equals("")) && resultcode == 1){
            ToDo temp = new ToDo(data.getStringExtra("Betreff"));
            temp.setBemerkung(data.getStringExtra("Bemerkung"));
            temp.setZusatz(data.getStringExtra("Zusatz"));
            temp.setDate(data.getStringExtra("Date"));
            temp.setTimestart(data.getStringExtra("Timestart"));
            temp.setTimeend(data.getStringExtra("Timeend"));
            temp.setGanztaegig(data.getBooleanExtra("Ganztaegig",false));
            int i = data.getIntExtra("Index",-1);
            if(i >= 0) {
                todolist.remove(i);
                todolist.add(i,temp);
            } else {
                Toast t = Toast.makeText(this, "Es ist ein unerwarteter Fehler aufgetreten", Toast.LENGTH_LONG);
                t.show();
            }
        } else {
            Toast toast = Toast.makeText(this,"Ungültige Eingabe",Toast.LENGTH_LONG);
            toast.show();
        }

    }




    @Override
    protected void onStart(){
        Log.i("Mainactivity","onStart");
        super.onStart();
    }

    @Override
    protected void onResume(){
        Log.i("MainActivity","onResume");
        super.onResume();
    }

    @Override
    protected void onPause(){
        Log.i("MainActivity","onPause");
        super.onPause();
    }

    @Override
    protected void onStop(){
        Log.i("Mainactivity","onStop");
        super.onStop();
    }

    @Override
    protected void onRestart(){
        Log.i("Mainactivity","onRestart");
        setAdapter();
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.i("MainActivity","onDestroy");
        super.onDestroy();
    }


    @Override
    public void onSelectedData(int pos) {
        todolist.remove(pos);
        recyclerView.removeViewAt(pos);
        adapter.notifyItemRemoved(pos);
        adapter.notifyItemChanged(pos);

    }
}