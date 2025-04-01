package com.valen.basededatoslocal.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    // Constructor
    public DbHelper(@Nullable Context context) {
        super(context, Constantes.DB_NAME, null, Constantes.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creación de las tablas
        db.execSQL(Constantes.CREATE_TABLE_CIUDAD);
        db.execSQL(Constantes.CREATE_TABLE_DEPARTAMENTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Eliminar las tablas antiguas si hay una actualización de versión
        db.execSQL(Constantes.DROP_TABLE_CIUDAD);
        db.execSQL(Constantes.DROP_TABLE_DEPARTAMENTO);
        onCreate(db); // Volver a crear las tablas
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
