package com.example.exam1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created with IntelliJ IDEA.
 * User: kris13
 * Date: 14.01.14
 * Time: 16:51
 * To change this template use File | Settings | File Templates.
 */
public class DbClient  extends SQLiteOpenHelper {

    private static final int DB_VERSION = 2;
    private static final String DB_NAME = "clients";

    public static final String TABLE_NAME = "clients";
    public static final String MARK = "mark";
    public static final String COLOR = "color";
    public static final String SIGN = "sign";
    public static final String TELEPHONE = "telephone";
    public static final String TIME = "time";
    public static final String BOX = "box";
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + " ( _id integer primary key autoincrement, "
            + MARK + " TEXT, " + COLOR + " TEXT, " + SIGN + " TEXT, " + TELEPHONE + " TEXT, " + TIME + " TEXT, " + BOX + " TEXT)";

    public DbClient(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}