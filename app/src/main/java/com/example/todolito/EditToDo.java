package com.example.todolito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class EditToDo extends AppCompatActivity {

    EditText betreff;
    EditText bemerkung;
    EditText zusatz;
    EditText date;
    EditText timestart;
    EditText timeend;
    CheckBox ganztaegig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_to_do);
        initToDo();
        initButtons();
    }


    private void initToDo(){
        betreff = findViewById(R.id.editTextTextPersonName);
        bemerkung = findViewById(R.id.editTextTextPersonName2);
        zusatz = findViewById(R.id.editTextTextPersonName3);
        date = findViewById(R.id.editTextDate);
        timestart = findViewById(R.id.editTextTime);
        timeend = findViewById(R.id.editTextTime2);
        ganztaegig = findViewById(R.id.checkBox2);
        Intent intent = getIntent();
        betreff.setText(intent.getStringExtra("Betreff"));
        bemerkung.setText(intent.getStringExtra("Bemerkung"));
        zusatz.setText(intent.getStringExtra("Zusatz"));
        date.setText(intent.getStringExtra("Date"));
        timestart.setText(intent.getStringExtra("Timestart"));
        timeend.setText(intent.getStringExtra("Timeend"));
        ganztaegig.setChecked(intent.getBooleanExtra("Ganztaegig",false));
    }

    private void initButtons(){
        Button back = findViewById(R.id.button2);
        back.setOnClickListener(l -> back());
        Button apply = findViewById(R.id.applybutton);
        apply.setOnClickListener(l -> apply());
    }

    private void back(){
        Intent intent = new Intent(this,DetailActivity.class);
        setResult(-1,intent);
        finish();
    }

    private void apply(){
        Intent intent = getIntent();
        intent.setClass(this,DetailActivity.class);
        intent.putExtra("Betreff",betreff.getText().toString());
        intent.putExtra("Bemerkung",bemerkung.getText().toString());
        intent.putExtra("Zusatz",zusatz.getText().toString());
        intent.putExtra("Date",date.getText().toString());
        intent.putExtra("Timestart",timestart.getText().toString());
        intent.putExtra("Timeend",timeend.getText().toString());
        intent.putExtra("Ganztaegig",ganztaegig.isChecked());
        setResult(1,intent);
        finish();
    }

    @Override
    public void onBackPressed(){ back();}


}