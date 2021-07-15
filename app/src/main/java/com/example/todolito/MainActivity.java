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

public class MainActivity extends AppCompatActivity {

    private ArrayList<ToDo> todolist;
    private RecyclerView recyclerView;
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
    protected void onActivityResult(int requestcode,int resultcode,Intent data){
        super.onActivityResult(requestcode,resultcode,data);
        if(resultcode == -1){

        } else if(data.getStringExtra("Betreff") != null && (!data.getStringExtra("Betreff").equals(""))){
            Log.i("MainActivity","ToDo gefunden");
            ToDo temp = new ToDo(data.getStringExtra("Betreff"));
            temp.setBemerkung(data.getStringExtra("Bemerkung"));
            temp.setZusatz(data.getStringExtra("Zusatz"));
            temp.setDate(data.getStringExtra("Date"));
            temp.setTimestart(data.getStringExtra("Timestart"));
            temp.setTimeend(data.getStringExtra("Timeend"));
            temp.setGanztaegig(data.getBooleanExtra("Ganztaegig",false));
            todolist.add(temp);
        } else {
            Toast toast = Toast.makeText(this,"Ungültige Eingabe",Toast.LENGTH_LONG);
            toast.show();
        }

    }


    private void setAdapter() {
        final MainActivity ma = this;
        RecyclerAdapter adapter = new RecyclerAdapter(todolist);
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
                startActivityForResult(intent,1);
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setToDoInfo() {
        todolist.add(new ToDo("Bier holen"));
        todolist.add(new ToDo("Mehr Bier holen"));
        todolist.add(new ToDo("Noch mehr Bier holen"));
    }

}