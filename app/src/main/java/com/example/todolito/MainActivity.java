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
        Intent uebergabe = data;
        if(resultcode == -1){

        } else if(uebergabe.getStringExtra("Betreff") != null && (!uebergabe.getStringExtra("Betreff").equals(""))){
            Log.i("MainActivity","ToDo gefunden");
            ToDo temp = new ToDo(uebergabe.getStringExtra("Betreff"));
            temp.setBemerkung(uebergabe.getStringExtra("Bemerkung"));
            temp.setZusatz(uebergabe.getStringExtra("Zusatz"));
            temp.setDate(uebergabe.getStringExtra("Date"));
            temp.setTime(uebergabe.getStringExtra("Time"));
            temp.setGanztaegig(uebergabe.getBooleanExtra("Ganztaegig",false));
            todolist.add(temp);
        } else {
            Toast toast = Toast.makeText(this,"Ungültige Eingabe",Toast.LENGTH_LONG);
            toast.show();
        }

    }


    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(todolist);
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