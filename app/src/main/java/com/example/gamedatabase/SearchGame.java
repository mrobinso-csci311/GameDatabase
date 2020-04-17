package com.example.gamedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SearchGame extends AppCompatActivity {

    public EditText searchedGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_game);

        searchedGame = findViewById(R.id.searchedGame);
    }

    public void searchPressed(View v){
        Intent i = new Intent(this, SearchList.class);
        i.putExtra("SEARCH",searchedGame.getText().toString());
        startActivity(i);
        finish();
    }
}
