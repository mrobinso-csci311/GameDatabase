package com.example.gamedatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {

    public DatabaseManager(Context context){
        super(context, "GameDB", null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        String sql = "create table GameTable(";
        sql += "id integer primary key autoincrement, ";
        sql += "title text, console text, publisher text)";
        db.execSQL(sql);
    }

    public void updateByTitle(String title, String console, String publisher){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "update GameTable set console = '"+console+"', publisher = '"+publisher+"' ";
        sql += "where title = '"+title+"'";
        db.execSQL(sql);
        db.close();
    }

    public ArrayList<String> getTitles(){
        ArrayList<String> list = new ArrayList<String>();
        SQLiteDatabase db  = getWritableDatabase();
        String sql = "select * from GameTable";
        Cursor cursor  = db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            String title = cursor.getString(1);
            list.add(title);
        }
        db.close();
        return list;
    }

    public ArrayList<String> getTitlesByConsole(String consoleName){
        ArrayList<String> list = new ArrayList<String>();
        SQLiteDatabase db  = getWritableDatabase();
        String sql = "select * from GameTable";
        Cursor cursor  = db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            String title = cursor.getString(1);
            String console = cursor.getString(2);
            if(console.equals(consoleName)) {
                list.add(title);
            }
        }
        db.close();
        return list;
    }

    public String[] get(String gameTitle){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from GameTable where title = '"+gameTitle+"'";
        Cursor cursor = db.rawQuery(sql, null);
        String[] entry = new String[3];
        if (cursor.moveToFirst()){
            String title = cursor.getString(1);
            String console = cursor.getString(2);
            String publisher = cursor.getString(3);
            entry[0] = title;
            entry[1] = console;
            entry[2] = publisher;
        }
        db.close();
        return entry;
    }

    public void insert(String gameName, String consoleName, String publisherName){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into GameTable values(";
        sql += "null, '"+gameName+"', '"+consoleName+"', '"+publisherName+"')";
        db.execSQL(sql);
        db.close();
    }

    public void delete(String requestedDelete){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "delete from GameTable where title = '"+requestedDelete+"'";
        db.execSQL(sql);
        db.close();
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
