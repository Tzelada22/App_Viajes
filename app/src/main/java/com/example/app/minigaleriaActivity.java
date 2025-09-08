package com.example.app;

import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class minigaleriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minigaleria);
        // Se encontro el boton por su ID
        ImageButton btnRetroceso = findViewById(R.id.btn_atras);

// Configuracion del boton para retroceder
        btnRetroceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra el activity y regresa al anterior
                finish();
            }
        });

    }
}