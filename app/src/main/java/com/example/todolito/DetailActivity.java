package com.example.todolito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initTodo();
        initButton();
    }

    private void initTodo(){
        TextView betreff = findViewById(R.id.textView9);
        TextView bemerkung = findViewById(R.id.textView10);
        TextView zusatz = findViewById(R.id.textView11);
        TextView date = findViewById(R.id.textView12);
        TextView timestart = findViewById(R.id.textView13);
        TextView timeend = findViewById(R.id.textView14);
        Intent intent = getIntent();
        betreff.setText(intent.getStringExtra("Betreff"));
        bemerkung.setText(intent.getStringExtra("Bemerkung"));
        zusatz.setText(intent.getStringExtra("Zusatz"));
        date.setText(intent.getStringExtra("Date"));
        timestart.setText(intent.getStringExtra("Timestart"));
        timeend.setText(intent.getStringExtra("Timeend"));
    }

    private void initButton(){
        Button back = findViewById(R.id.button2);
        back.setOnClickListener(l -> back());
        Button edit = findViewById(R.id.applybutton);
        edit.setOnClickListener(l -> edit());
    }

    private void back(){
        Intent intent = new Intent(this,MainActivity.class);
        setResult(-1,intent);
        finish();
    }

    private void edit(){
        Intent intent = getIntent();
        intent.setClass(this,EditToDo.class);
        startActivityForResult(intent,1);
    }

    @Override
    public void onBackPressed(){
        back();
    }

    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data){
        super.onActivityResult(requestcode,resultcode,data);
        data.setClass(this,MainActivity.class);
        setResult(resultcode,data);
        finish();
    }
}