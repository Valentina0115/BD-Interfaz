package com.valen.basededatoslocal.model;

public class Constantes {
    // Nombre de la base de datos
    public static final String DB_NAME = "basededatoslocal.db";
    public static final int DB_VERSION = 1;

    // Tabla de Ciudades
    public static final String TABLE_CIUDAD = "Ciudad";
    public static final String COLUMN_CIUDAD_CODIGO = "codigo";
    public static final String COLUMN_CIUDAD_NOMBRE = "nombre";

    // Tabla de Departamentos
    public static final String TABLE_DEPARTAMENTO = "Departamento";
    public static final String COLUMN_DEPTO_CODIGO = "codigo";
    public static final String COLUMN_DEPTO_NOMBRE = "nombre";

    // Sentencias de creación de tablas
    public static final String CREATE_TABLE_CIUDAD =
            "CREATE TABLE " + TABLE_CIUDAD + " (" +
                    COLUMN_CIUDAD_CODIGO + " INTEGER PRIMARY KEY, " +
                    COLUMN_CIUDAD_NOMBRE + " TEXT NOT NULL);";

    public static final String CREATE_TABLE_DEPARTAMENTO =
            "CREATE TABLE " + TABLE_DEPARTAMENTO + " (" +
                    COLUMN_DEPTO_CODIGO + " INTEGER PRIMARY KEY, " +
                    COLUMN_DEPTO_NOMBRE + " TEXT NOT NULL);";

    // Sentencias de eliminación de tablas
    public static final String DROP_TABLE_CIUDAD = "DROP TABLE IF EXISTS " + TABLE_CIUDAD;
    public static final String DROP_TABLE_DEPARTAMENTO = "DROP TABLE IF EXISTS " + TABLE_DEPARTAMENTO;
}
