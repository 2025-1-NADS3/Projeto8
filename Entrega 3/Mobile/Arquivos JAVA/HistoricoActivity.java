package com.example.bancouni; 

  

import android.os.Bundle; 

import android.view.ViewGroup; 

import android.widget.Button; 

import android.widget.LinearLayout; 

import android.widget.TextView; 

import androidx.appcompat.app.AppCompatActivity; 

  

public class HistoricoActivity extends AppCompatActivity { 

  

    private LinearLayout layoutTransacoes; 

  

    @Override 

    protected void onCreate(Bundle savedInstanceState) { 

        super.onCreate(savedInstanceState); 

        setContentView(R.layout.activity_historico); 

  

        Button btnVoltar = findViewById(R.id.btnVoltar); 

        layoutTransacoes = findViewById(R.id.layoutTransacoes); 

  

        btnVoltar.setOnClickListener(view -> finish()); 

  

        adicionarTransacoesFicticias(); // Load some example transactions 

    } 

  

    private void adicionarTransacoesFicticias() { 

        for (int i = 0; i < 5; i++) { 

            LinearLayout card = new LinearLayout(this); 

            card.setLayoutParams(new LinearLayout.LayoutParams( 

                    ViewGroup.LayoutParams.MATCH_PARENT, 

                    ViewGroup.LayoutParams.WRAP_CONTENT 

            )); 

            card.setPadding(20, 20, 20, 20); 

            card.setOrientation(LinearLayout.VERTICAL); 

            card.setBackgroundColor(0xFFEFEFEF); // Light background 

            card.setElevation(4); 

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams( 

                    ViewGroup.LayoutParams.MATCH_PARENT, 

                    ViewGroup.LayoutParams.WRAP_CONTENT); 

            params.setMargins(0, 0, 0, 20); 

            card.setLayoutParams(params); 

  

            TextView title = new TextView(this); 

            title.setText("Pix para Amanda"); 

            title.setTextColor(0xFF0A2F4F); 

            title.setTextSize(16); 

  

            TextView valor = new TextView(this); 

            valor.setText("R$15,00"); 

            valor.setTextColor(0xFF0A2F4F); 

            valor.setTextSize(14); 

  

            card.addView(title); 

            card.addView(valor); 

  

            layoutTransacoes.addView(card); 

        } 

    } 

} 
