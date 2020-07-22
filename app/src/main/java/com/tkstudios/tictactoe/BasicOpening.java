package com.tkstudios.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BasicOpening extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_opening);
         Intent namechanger = getIntent();
    }

    public void startGame(View view){
        Intent intent = new Intent (this, MainActivity.class);

        EditText enter1 = (EditText)findViewById(R.id.enter1);
        EditText enter2 = (EditText)findViewById(R.id.enter2);

        intent.putExtra("playern1", enter1.getText().toString());
        intent.putExtra("playern2", enter2.getText().toString());
        startActivity(intent);
    }
}