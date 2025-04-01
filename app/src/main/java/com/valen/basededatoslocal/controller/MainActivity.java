package com.valen.basededatoslocal.controller;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.valen.basededatoslocal.R;
import com.valen.basededatoslocal.model.ManagerDB;

public class MainActivity extends AppCompatActivity {

    private ManagerDB managerDB;
    private EditText etCodigoCiudad, etNombreCiudad, etCodigoDepto, etNombreDepto;
    private Button btnGuardar, btnVerLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar ManagerDB
        managerDB = new ManagerDB(this);

        // Referencias a los EditText
        etCodigoCiudad = findViewById(R.id.etCodigoCiudad);
        etNombreCiudad = findViewById(R.id.etNombreCiudad);
        etCodigoDepto = findViewById(R.id.etCodigoDepto);
        etNombreDepto = findViewById(R.id.etNombreDepto);

        // Referencias a los botones
        btnGuardar = findViewById(R.id.btnGuardar);
        btnVerLista = findViewById(R.id.btnVerLista);

        // Acción para guardar datos
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos();
            }
        });

        // Acción para ver la lista
        btnVerLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void guardarDatos() {
        try {
            // Obtener datos ingresados
            int codigoCiudad = Integer.parseInt(etCodigoCiudad.getText().toString());
            String nombreCiudad = etNombreCiudad.getText().toString();
            int codigoDepto = Integer.parseInt(etCodigoDepto.getText().toString());
            String nombreDepto = etNombreDepto.getText().toString();

            // Insertar en la base de datos
            long resulCiudad = managerDB.insertCiudad(codigoCiudad, nombreCiudad);
            long resulDepto = managerDB.insertDepartamento(codigoDepto, nombreDepto);

            // Verificar si la inserción fue exitosa
            if (resulCiudad > 0 && resulDepto > 0) {
                Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
                limpiarCampos();
            } else {
                Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Ingrese valores válidos", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiarCampos() {
        etCodigoCiudad.setText("");
        etNombreCiudad.setText("");
        etCodigoDepto.setText("");
        etNombreDepto.setText("");
    }
}
