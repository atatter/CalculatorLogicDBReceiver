package com.aleks.calculatorlogicdbreceiver;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by aleks on 11/04/16.
 */
public class StatisticsRepo extends Repo<Statistics> {

    public StatisticsRepo(SQLiteDatabase database, String tablename, String[] allColumns) {
        super(database, tablename, allColumns);
    }

    @Override
    public ContentValues entityToContentValues(Statistics entity) {
        ContentValues values = new ContentValues();
        values.put(getAllColumns()[1], entity.getDaystamp());
        values.put(getAllColumns()[2], entity.getOperandId());
        values.put(getAllColumns()[3], entity.getDayCounter());
        return values;
    }

    @Override
    public Statistics cursorToEntity(Cursor cursor) {
        Statistics statistics = new Statistics();
        statistics.setId(cursor.getLong(0));
        statistics.setDaystamp(cursor.getInt(1));
        statistics.setOperandId(cursor.getInt(2));
        statistics.setDayCounter(cursor.getInt(3));
        return statistics;
    }
}
