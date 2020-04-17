package com.example.gamedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddGame extends AppCompatActivity {

    private EditText gameTitle;
    private EditText gameConsole;
    private EditText gamePublisher;
    private Button addButton;
    private boolean add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);

        gameTitle = findViewById(R.id.gameTitle);
        gameConsole = findViewById(R.id.gameConsole);
        gamePublisher = findViewById(R.id.gamePublisher);
        addButton = findViewById(R.id.addButton);

        Intent i = getIntent();
        add = i.getBooleanExtra("ADD",true);
        if(add){
            addButton.setText("ADD");
        }else{
            addButton.setText("EDIT");
            gameTitle.setText(i.getStringExtra("TITLE"));
            gameConsole.setText(i.getStringExtra("CONSOLE"));
            gamePublisher.setText(i.getStringExtra("PUBLISHER"));
        }
    }

    public void addPressed(View v){
        String title = gameTitle.getText().toString();
        String console = gameConsole.getText().toString();
        String publisher = gamePublisher.getText().toString();
        DatabaseManager dbm = new DatabaseManager(this);
        if(add){
            dbm.insert(title, console, publisher);
        }else{
            dbm.updateByTitle(title, console, publisher);
        }
        finish();
    }
}
