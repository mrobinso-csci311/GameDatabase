package com.example.gamedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchList extends AppCompatActivity {

    private ScrollView searchScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
        searchScrollView = findViewById(R.id.searchScrollView);
        searchScrollView.removeAllViewsInLayout();
        DatabaseManager dbm = new DatabaseManager(this);
        Intent i = getIntent();
        String search = i.getStringExtra("SEARCH");
        ArrayList<String> list = dbm.getTitlesByConsole(search);
        GridLayout grid = new GridLayout(this);
        grid.setColumnCount(1);
        grid.setRowCount(list.size());
        for(String title: list){
            TextView text = new TextView(this);
            text.setText(title);
            text.setTextSize(40);
            text.setClickable(true);
            text.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent i = new Intent(getApplicationContext(),GameView.class);
                    i.putExtra("TITLE",((TextView) view).getText().toString());
                    startActivity(i);
                }
            });
            grid.addView(text);
        }
        searchScrollView.addView(grid);
    }
}
