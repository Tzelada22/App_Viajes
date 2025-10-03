package com.example.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AppViajeDB.db";
    private static final String SQL_CREATE_USERS =
            "CREATE TABLE " + ViajeContract.UsuarioEntry.TABLE_NAME + " (" +
                    ViajeContract.UsuarioEntry.COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ViajeContract.UsuarioEntry.COLUMN_USER_EMAIL + " TEXT UNIQUE NOT NULL," +
                    ViajeContract.UsuarioEntry.COLUMN_USER_PASSWORD + " TEXT NOT NULL," +
                    ViajeContract.UsuarioEntry.COLUMN_USER_NAME + " TEXT)";
    private static final String SQL_CREATE_NOTAS =
            "CREATE TABLE " + ViajeContract.NotaEntry.TABLE_NAME + " (" +
                    ViajeContract.NotaEntry.COLUMN_NOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ViajeContract.NotaEntry.COLUMN_NOTA_AUTHOR + " TEXT," +
                    ViajeContract.NotaEntry.COLUMN_NOTA_PLACE + " TEXT," +
                    ViajeContract.NotaEntry.COLUMN_NOTA_CONTENT + " TEXT," +
                    ViajeContract.NotaEntry.COLUMN_NOTA_DATE + " DATETIME DEFAULT CURRENT_TIMESTAMP)";
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_NOTAS);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ViajeContract.UsuarioEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ViajeContract.NotaEntry.TABLE_NAME);
        onCreate(db);
    }
}