package com.example.bancouni;

import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class PagamentoActivity extends AppCompatActivity {

    private boolean isSaldoVisivel = false;
    private EditText editSaldoPagamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        Button btnVoltar = findViewById(R.id.btnVoltarPagamentos);
        ImageButton btnToggle = findViewById(R.id.btnToggleSaldoPagamentos);
        editSaldoPagamentos = findViewById(R.id.editSaldoPagamentos);

        btnVoltar.setOnClickListener(v -> finish());

        btnToggle.setOnClickListener(v -> {
            isSaldoVisivel = !isSaldoVisivel;
            editSaldoPagamentos.setInputType(isSaldoVisivel ?
                    InputType.TYPE_CLASS_TEXT :
                    InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            editSaldoPagamentos.setSelection(editSaldoPagamentos.getText().length());
        });

        // Ação do botão "Pagar"
        Button btnPagar = findViewById(R.id.btnPagar);
        btnPagar.setOnClickListener(v -> {
            // Aqui você pode implementar a lógica de pagamento
        });
    }
}

