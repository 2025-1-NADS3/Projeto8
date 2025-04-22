package com.example.bancouni;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;


import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText editSenha;
    ImageView iconeOlho;
    boolean mostrarSenha = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnVoltar = findViewById(R.id.btnVoltar);
        Button btnFazerLogin = findViewById(R.id.btnFazerLogin);
        editSenha = findViewById(R.id.editSenha);
        iconeOlho = findViewById(R.id.iconeOlho);


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Volta pra tela anterior
            }
        });


        iconeOlho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mostrarSenha) {
                    editSenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    mostrarSenha = false;
                } else {
                    editSenha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    mostrarSenha = true;
                }
                editSenha.setSelection(editSenha.length());
            }
        });


        btnFazerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

    }
}
