package com.example.bancouni;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.bancouni.DBHelper;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText editEmail, editSenha;
    ImageView iconeOlho;
    boolean mostrarSenha = false;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnVoltar = findViewById(R.id.btnVoltar);
        Button btnFazerLogin = findViewById(R.id.btnFazerLogin);
        editEmail = findViewById(R.id.editNome);
        editSenha = findViewById(R.id.editSenha);
        iconeOlho = findViewById(R.id.iconeOlho);
        dbHelper = new DBHelper(this);

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
                String email = editEmail.getText().toString().trim();
                String senha = editSenha.getText().toString().trim();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(senha)) {
                    Toast.makeText(LoginActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    boolean loginValido = dbHelper.verificarUsuario(email, senha);

                    if (loginValido) {
                        Toast.makeText(LoginActivity.this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Email ou senha inválidos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
