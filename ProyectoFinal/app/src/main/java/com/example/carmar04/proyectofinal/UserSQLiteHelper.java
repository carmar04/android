package com.example.carmar04.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class UserSQLiteHelper extends SQLiteOpenHelper {
    String cadSQL = "CREATE TABLE Users (nickName TEXT, password TEXT)";

    public UserSQLiteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version){
        super(contexto, nombre, almacen, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(cadSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {
        bd.execSQL("DROP TABLE IF EXISTS Clientes");
        bd.execSQL(cadSQL);
    }
}