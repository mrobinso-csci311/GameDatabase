package com.example.gamedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DeleteGame extends AppCompatActivity {

    public EditText deletedGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_game);

        deletedGame = findViewById(R.id.deletedGame);
    }

    public void deletePressed(View v){
        DatabaseManager dbm = new DatabaseManager(this);
        dbm.delete(deletedGame.getText().toString());
        Intent i = new Intent(this, ViewAll.class);
        startActivity(i);
    }
}
