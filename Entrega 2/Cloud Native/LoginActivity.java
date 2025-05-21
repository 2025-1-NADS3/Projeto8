package com.exemplo.bancouni; 

  

import android.os.Bundle; 

import android.view.View; 

import android.widget.EditText; 

import android.widget.Toast; 

import androidx.appcompat.app.AppCompatActivity; 

  

public class LoginActivity extends AppCompatActivity { 

    private EditText etUsuario, etSenha; 

  

    @Override 

    protected void onCreate(Bundle savedInstanceState) { 

        super.onCreate(savedInstanceState); 

        setContentView(R.layout.activity_login); 

  

        etUsuario = findViewById(R.id.editNome); 

        etSenha = findViewById(R.id.editSenha); 

    } 

  

    public void fazerLogin(View view) { 

        UsuarioDAO dao = new UsuarioDAO(this); 

        String usuario = etUsuario.getText().toString(); 

        String senha = etSenha.getText().toString(); 

  

        if (dao.validarLogin(usuario, senha)) { 

            Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show(); 

        } else { 

            Toast.makeText(this, "Usuário ou senha inválidos!", Toast.LENGTH_SHORT).show(); 

        } 

    } 

  

    public void voltar(View view) { 

        finish(); 

    } 

} 
