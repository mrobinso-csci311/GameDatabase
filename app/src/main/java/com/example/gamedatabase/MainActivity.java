package com.example.gamedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addPressed(View v){
        Intent i = new Intent(this, AddGame.class);
        startActivity(i);
    }

    public void viewPressed(View v){
        Intent i = new Intent(this, ViewAll.class);
        startActivity(i);
    }

    public void mainSearchPressed(View v){
        Intent i = new Intent(this, SearchGame.class);
        startActivity(i);
    }

    public void deletePressed(View v){
        Intent i = new Intent(this, DeleteGame.class);
        startActivity(i);
    }

    //Edit and Help options were deleted, but classes remain in file
}
