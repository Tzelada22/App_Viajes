package com.example.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;
public class principalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Se encontro los botones por su ID
        ImageButton btnGaleria = findViewById(R.id.galeriaButton);
        ImageButton btnDiario = findViewById(R.id.diarioButton);
        ImageButton btnDestino = findViewById(R.id.btnDestino);

        //Configuración del OnClickListener para el boton de galeria
        btnGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se crea el Intent para poder ir al activity de la galeria
                Intent intent = new Intent(principalActivity.this, minigaleriaActivity.class);
                //Se inicia el nuevo activity
                startActivity(intent);
            }
        });
        //Configuración del OnClickListener para el boton de la notas
        btnDiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se crea el Intent para poder ir al activity de las notas
                Intent intent = new Intent(principalActivity.this, notas_viajeros.class);
                //Se inicia el nuevo activity
                startActivity(intent);
            }
        });
        //Configuración del OnClickListener para el boton del destino
        btnDestino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se crea el Intent para poder ir al activity de los destinos
                Intent intent = new Intent(principalActivity.this, destinos.class);
                //Se inicia el nuevo activity
                startActivity(intent);
            }
        });
    }
}