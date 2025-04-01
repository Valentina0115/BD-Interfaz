package com.valen.basededatoslocal.controller;
import  com.valen.basededatoslocal.model.DbHelper;
import com.valen.basededatoslocal.model.ManagerDB; // Importación de ManagerDB desde el paquete model
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class ListaActivity{  // Asumí que este es el nombre correcto de tu clase, puedes cambiarlo si es diferente.
    private DbHelper dbHelper;
    private SQLiteDatabase db;
    private ManagerDB managerDB;  // Se usa ManagerDB desde el paquete model

    public ListaActivity(Context context) {
        dbHelper = new DbHelper(context);
        managerDB = new ManagerDB(context);  // Usamos la clase ManagerDB del paquete model
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
        return managerDB.insertCiudad(codigo, nombre); // Usar método de ManagerDB importado
    }

    // Método para insertar un departamento con datos dinámicos
    public long insertDepartamento(int codigo, String nombre) {
        return managerDB.insertDepartamento(codigo, nombre); // Usar método de ManagerDB importado
    }

    // Método para obtener todas las ciudades
    public ArrayList<String> getCiudades() {
        return managerDB.getCiudades();  // Usar método de ManagerDB importado
    }

    // Método para obtener todos los departamentos
    public ArrayList<String> getDepartamentos() {
        return managerDB.getDepartamentos();  // Usar método de ManagerDB importado
    }

    // Método para eliminar una ciudad por su código
    public void deleteCiudad(int codigo) {
        managerDB.deleteCiudad(codigo);  // Usar método de ManagerDB importado
    }

    // Método para eliminar un departamento por su código
    public void deleteDepartamento(int codigo) {
        managerDB.deleteDepartamento(codigo);  // Usar método de ManagerDB importado
    }
}
