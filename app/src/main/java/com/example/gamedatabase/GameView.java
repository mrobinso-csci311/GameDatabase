package com.example.gamedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameView extends AppCompatActivity {

    public TextView titleView;
    public TextView consoleView;
    public TextView publisherView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

        titleView = findViewById(R.id.titleView);
        consoleView = findViewById(R.id.consoleView);
        publisherView  = findViewById(R.id.publisherView);

        DatabaseManager dbm = new DatabaseManager(this);
        Intent i = getIntent();
        String title = i.getStringExtra("TITLE");
        String[] entry = dbm.get(title);
        titleView.setText(entry[0]);
        consoleView.setText(entry[1]);
        publisherView.setText(entry[2]);
    }

    public void editPressed(View v){
        Intent i = new Intent(this,AddGame.class);
        i.putExtra("ADD",false);
        i.putExtra("TITLE",titleView.getText().toString());
        i.putExtra("CONSOLE",consoleView.getText().toString());
        i.putExtra("PUBLISHER",publisherView.getText().toString());
        startActivity(i);
    }
}
