package com.valen.basededatoslocal.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class ManagerDB {
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public ManagerDB(Context context) {
        dbHelper = new DbHelper(context);
    }

    // Método para abrir la base de datos en modo escritura
    public void openDbWr() {
        db = dbHelper.getWritableDatabase();
    }

    // Método para abrir la base de datos en modo lectura
    public void openDbRd() {
        db = dbHelper.getReadableDatabase();
    }

    // Método para cerrar la base de datos y evitar fugas de memoria
    public void closeDb() {
        if (db != null && db.isOpen()) {
            db.close();
        }
    }

    // Método para insertar una ciudad con datos dinámicos
    public long insertCiudad(int codigo, String nombre) {
        openDbWr();
        ContentValues valores = new ContentValues();
        valores.put("codigo", codigo);
        valores.put("nombre", nombre);
        long res = db.insert("Ciudad", null, valores);
        closeDb();
        return res;
    }

    // Método para insertar un departamento con datos dinámicos
    public long insertDepartamento(int codigo, String nombre) {
        openDbWr();
        ContentValues valores = new ContentValues();
        valores.put("codigo", codigo);
        valores.put("nombre", nombre);
        long res = db.insert("Departamento", null, valores);
        closeDb();
        return res;
    }

    // Método para obtener todas las ciudades
    public ArrayList<String> getCiudades() {
        openDbRd();
        ArrayList<String> ciudades = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Ciudad", null);

        if (cursor != null && cursor.moveToFirst()) {
            int columnIndexNombre = cursor.getColumnIndex("nombre");
            int columnIndexCodigo = cursor.getColumnIndex("codigo");

            // Verificar si las columnas existen
            if (columnIndexNombre != -1 && columnIndexCodigo != -1) {
                do {
                    String ciudad = cursor.getString(columnIndexNombre);
                    int codigo = cursor.getInt(columnIndexCodigo);
                    ciudades.add(codigo + " - " + ciudad);
                } while (cursor.moveToNext());
            } else {
                Log.e("ManagerDB", "Las columnas 'codigo' o 'nombre' no fueron encontradas.");
            }
            cursor.close();
        }
        closeDb();
        return ciudades;
    }

    // Método para obtener todos los departamentos
    public ArrayList<String> getDepartamentos() {
        openDbRd();
        ArrayList<String> departamentos = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Departamento", null);

        if (cursor != null && cursor.moveToFirst()) {
            int columnIndexNombre = cursor.getColumnIndex("nombre");
            int columnIndexCodigo = cursor.getColumnIndex("codigo");

            // Verificar si las columnas existen
            if (columnIndexNombre != -1 && columnIndexCodigo != -1) {
                do {
                    String departamento = cursor.getString(columnIndexNombre);
                    int codigo = cursor.getInt(columnIndexCodigo);
                    departamentos.add(codigo + " - " + departamento);
                } while (cursor.moveToNext());
            } else {
                Log.e("ManagerDB", "Las columnas 'codigo' o 'nombre' no fueron encontradas.");
            }
            cursor.close();
        }
        closeDb();
        return departamentos;
    }

    // Método para eliminar una ciudad por su código
    public void deleteCiudad(int codigo) {
        openDbWr();
        int rowsDeleted = db.delete("Ciudad", "codigo = ?", new String[]{String.valueOf(codigo)});
        if (rowsDeleted > 0) {
            Log.d("ManagerDB", "Ciudad eliminada con éxito");
        } else {
            Log.d("ManagerDB", "No se encontró la ciudad con el código: " + codigo);
        }
        closeDb();
    }

    // Método para eliminar un departamento por su código
    public void deleteDepartamento(int codigo) {
        openDbWr();
        int rowsDeleted = db.delete("Departamento", "codigo = ?", new String[]{String.valueOf(codigo)});
        if (rowsDeleted > 0) {
            Log.d("ManagerDB", "Departamento eliminado con éxito");
        } else {
            Log.d("ManagerDB", "No se encontró el departamento con el código: " + codigo);
        }
        closeDb();
    }
}
