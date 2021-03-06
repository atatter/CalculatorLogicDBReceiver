package com.aleks.calculatorlogicdbreceiver;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleks on 11/04/16.
 */
public abstract class Repo<T> {

    private SQLiteDatabase database;
    private String tablename;
    private String[] allColumns;

    public Repo(SQLiteDatabase database, String tablename, String[] allColumns){
        this.database = database;
        this.tablename = tablename;
        this.allColumns = allColumns;
    }

    public String[] getAllColumns(){
        return allColumns;
    }

    public List<T> all(){
        ArrayList<T> list = new ArrayList<T>();

        Cursor cursor = database.query(tablename,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            T entity = cursorToEntity(cursor);
            list.add(entity);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return list;
    }

    public T add(T entity){
        ContentValues values = entityToContentValues(entity);
        long insertId = database.insert(tablename, null,
                values);
        return getById(insertId);
    }

    public T getById(long id){
        Cursor cursor = database.query(tablename,
                allColumns, allColumns[0] + " = " + id, null,
                null, null, null);
        cursor.moveToFirst();
        T entity = cursorToEntity(cursor);
        cursor.close();
        return entity;
    }

    public void update(T entity){

    }

    public void delete(T entity){

    }

    public void delete(long id){

    }

    public abstract ContentValues entityToContentValues(T entity);
    public abstract T cursorToEntity(Cursor cursor);
}

