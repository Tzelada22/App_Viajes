package com.example.app;

import android.os.Bundle;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etCorreo, etClave;
    private Button btnIniciar;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etCorreo = findViewById(R.id.correo);
        etClave = findViewById(R.id.clave);
        btnIniciar = findViewById(R.id.btnIniciar);

        dbHelper = new DBHelper(this);

        btnIniciar.setOnClickListener(v -> validarLogin());
    }

    private void validarLogin() {
        String correo = etCorreo.getText().toString().trim();
        String clave = etClave.getText().toString().trim();

        if (correo.isEmpty() || clave.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + ViajeContract.UsuarioEntry.TABLE_NAME +
                        " WHERE " + ViajeContract.UsuarioEntry.COLUMN_USER_EMAIL + "=? AND " +
                        ViajeContract.UsuarioEntry.COLUMN_USER_PASSWORD + "=?",
                new String[]{correo, clave}
        );

        if (cursor.moveToFirst()) {
            Toast.makeText(this, "Login exitoso, bienvenido " +
                            cursor.getString(cursor.getColumnIndexOrThrow(ViajeContract.UsuarioEntry.COLUMN_USER_NAME)),
                    Toast.LENGTH_SHORT).show();

            // Ir a la pantalla principal
            Intent intent = new Intent(LoginActivity.this, principalActivity.class);
            startActivity(intent);

            // Finaliza el login
            finish();
        } else {
            Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }

        cursor.close();
        db.close();
    }
}
