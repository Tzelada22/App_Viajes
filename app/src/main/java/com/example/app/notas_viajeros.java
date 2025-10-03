package com.example.app;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;



public class notas_viajeros extends AppCompatActivity {
    private EditText editNombre, editNota;
    private Button btnGuardar;
    private ImageButton btnAtras;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_viajeros);

        editNombre = findViewById(R.id.edit_nombre);
        editNota = findViewById(R.id.edit_nota);
        btnGuardar = findViewById(R.id.btn_guardar);
        btnAtras = findViewById(R.id.atrasButton);

        dbHelper = new DBHelper(this);

        // Acción del botón "Guardar"
        btnGuardar.setOnClickListener(v -> guardarNota());

        // Acción del botón "Atrás"
        btnAtras.setOnClickListener(v -> finish());
    }

    private void guardarNota() {
        String nombre = editNombre.getText().toString().trim();
        String contenido = editNota.getText().toString().trim();

        if(nombre.isEmpty() || contenido.isEmpty()){
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Abrir base de datos en modo escritura
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ViajeContract.NotaEntry.COLUMN_NOTA_AUTHOR, nombre);
        values.put(ViajeContract.NotaEntry.COLUMN_NOTA_CONTENT, contenido);

        long newRowId = db.insert(ViajeContract.NotaEntry.TABLE_NAME, null, values);

        if(newRowId != -1){
            Toast.makeText(this, "Nota guardada exitosamente", Toast.LENGTH_SHORT).show();
            // Limpiar campos después de guardar
            editNombre.setText("");
            editNota.setText("");
        } else {
            Toast.makeText(this, "Error al guardar la nota", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }
}

