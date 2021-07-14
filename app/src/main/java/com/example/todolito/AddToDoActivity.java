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
    EditText time;
    CheckBox ganztaegig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);
        betreff = findViewById(R.id.editTextTextPersonName);
        bemerkung = findViewById(R.id.editTextTextPersonName2);
        zusatz = findViewById(R.id.editTextTextPersonName3);
        date = findViewById(R.id.editTextDate);
        time = findViewById(R.id.editTextTime);
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
        String timeText = time.getText().toString();
        intent.putExtra("Time",timeText);
        intent.putExtra("Ganztaegig",ganztaegig.isChecked());
        setResult(0,intent);
        finish();
    }
}