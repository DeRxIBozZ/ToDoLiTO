package com.example.todolito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class AddToDoActivity extends AppCompatActivity {

    private Button back;
    private Button add;
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
        setContentView(R.layout.activity_add_to_do);
        betreff = findViewById(R.id.editTextTextPersonName);
        bemerkung = findViewById(R.id.editTextTextPersonName2);
        zusatz = findViewById(R.id.editTextTextPersonName3);
        date = findViewById(R.id.editTextDate);
        timestart = findViewById(R.id.editTextTime);
        timeend = findViewById(R.id.editTextTime2);
        ganztaegig = findViewById(R.id.checkBox2);
        back = findViewById(R.id.button2);
        back.setOnClickListener(l -> back());
        add = findViewById(R.id.button);
        add.setOnClickListener(l -> add());
    }


    private void back(){
        Intent intent = new Intent(this,MainActivity.class);
        setResult(-1,intent);
        finish();

    }

    private void add(){
        Intent intent = new Intent(this,MainActivity.class);
        String betreffText = betreff.getText().toString();
        intent.putExtra("Betreff",betreffText);
        String bemerkungText = bemerkung.getText().toString();
        intent.putExtra("Bemerkung",bemerkungText);
        String zusatzText = zusatz.getText().toString();
        intent.putExtra("Zusatz",zusatzText);
        String dateText = date.getText().toString();
        intent.putExtra("Date",dateText);
        String timestartText = timestart.getText().toString();
        intent.putExtra("Timestart",timestartText);
        String timeendText = timeend.getText().toString();
        intent.putExtra("Timeend",timeendText);
        intent.putExtra("Ganztaegig",ganztaegig.isChecked());
        setResult(0,intent);
        finish();
    }
}