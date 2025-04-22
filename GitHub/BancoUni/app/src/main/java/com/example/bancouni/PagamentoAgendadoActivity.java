package com.example.bancouni;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class PagamentoAgendadoActivity extends AppCompatActivity {

    private EditText etChave, etDataTransferencia, etValor;
    private Button btnAgendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_agendado);

        etChave = findViewById(R.id.etChave);
        etDataTransferencia = findViewById(R.id.etDataTransferencia);
        etValor = findViewById(R.id.etValor);
        btnAgendar = findViewById(R.id.btnAgendar);

        btnAgendar.setOnClickListener(view -> {
            // Aqui você pode validar os campos e simular um agendamento
            String chave = etChave.getText().toString();
            String data = etDataTransferencia.getText().toString();
            String valor = etValor.getText().toString();

            // Exemplo: mostrar no Logcat ou fazer um Toast
            // Toast.makeText(this, "Agendamento realizado!", Toast.LENGTH_SHORT).show();
        });
    }
}
